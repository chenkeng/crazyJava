
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.concurrent.*;
/**
 * Description:
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class AIOClient
{
	final static String UTF_8 = "utf-8";
	final static int PORT = 30000;
	// 与服务器端通信的异步Channel
	AsynchronousSocketChannel clientChannel;
	JFrame mainWin = new JFrame("多人聊天");
	JTextArea jta = new JTextArea(16 , 48);
	JTextField jtf = new JTextField(40);
	JButton sendBn = new JButton("发送");
	public void init()
	{
		mainWin.setLayout(new BorderLayout());
		jta.setEditable(false);
		mainWin.add(new JScrollPane(jta), BorderLayout.CENTER);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(sendBn);
		// 发送消息的Action,Action是ActionListener的子接口
		Action sendAction = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				String content = jtf.getText();
				if (content.trim().length() > 0)
				{
					try
					{
						// 将content内容写入Channel中
						clientChannel.write(ByteBuffer.wrap(content
							.trim().getBytes(UTF_8))).get();    //①
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
				// 清空输入框
				jtf.setText("");
			}
		};
		sendBn.addActionListener(sendAction);
		// 将Ctrl+Enter键和"send"关联
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n'
			, java.awt.event.InputEvent.CTRL_DOWN_MASK) , "send");
		// 将"send"和sendAction关联
		jtf.getActionMap().put("send", sendAction);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.add(jp , BorderLayout.SOUTH);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public void connect()
		throws Exception
	{
		// 定义一个ByteBuffer准备读取数据
		final ByteBuffer buff = ByteBuffer.allocate(1024);
		// 创建一个线程池
		ExecutorService executor = Executors.newFixedThreadPool(80);
		// 以指定线程池来创建一个AsynchronousChannelGroup
		AsynchronousChannelGroup channelGroup =
			AsynchronousChannelGroup.withThreadPool(executor);
		// 以channelGroup作为组管理器来创建AsynchronousSocketChannel
		clientChannel = AsynchronousSocketChannel.open(channelGroup);
		// 让AsynchronousSocketChannel连接到指定IP、指定端口
		clientChannel.connect(new InetSocketAddress("127.0.0.1"
			, PORT)).get();
		jta.append("---与服务器连接成功---\n");
		buff.clear();
		clientChannel.read(buff, null
			, new CompletionHandler<Integer,Object>()   //②
		{
			@Override
			public void completed(Integer result, Object attachment)
			{
				buff.flip();
				// 将buff中内容转换为字符串
				String content = StandardCharsets.UTF_8
					.decode(buff).toString();
				// 显示从服务器端读取的数据
				jta.append("某人说：" + content + "\n");
				buff.clear();
				clientChannel.read(buff , null , this);
			}
			@Override
			public void failed(Throwable ex, Object attachment)
			{
				System.out.println("读取数据失败: " + ex);
			}
		});
	}
	public static void main(String[] args)
		throws Exception
	{
		AIOClient client = new AIOClient();
		client.init();
		client.connect();
	}
}