
import java.util.*;
import java.net.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
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
public class NClient
{
	// 定义检测SocketChannel的Selector对象
	private Selector selector = null;
	static final int PORT = 30000;
	// 定义处理编码和解码的字符集
	private Charset charset = Charset.forName("UTF-8");
	// 客户端SocketChannel
	private SocketChannel sc = null;
	public void init()throws IOException
	{
		selector = Selector.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		// 调用open静态方法创建连接到指定主机的SocketChannel
		sc = SocketChannel.open(isa);
		// 设置该sc以非阻塞方式工作
		sc.configureBlocking(false);
		// 将SocketChannel对象注册到指定Selector
		sc.register(selector, SelectionKey.OP_READ);
		// 启动读取服务器端数据的线程
		new ClientThread().start();
		// 创建键盘输入流
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine())
		{
			// 读取键盘输入
			String line = scan.nextLine();
			// 将键盘输入的内容输出到SocketChannel中
			sc.write(charset.encode(line));
		}
	}
	// 定义读取服务器数据的线程
	private class ClientThread extends Thread
	{
		public void run()
		{
			try
			{
				while (selector.select() > 0)    // ①
				{
					// 遍历每个有可用IO操作Channel对应的SelectionKey
					for (SelectionKey sk : selector.selectedKeys())
					{
						// 删除正在处理的SelectionKey
						selector.selectedKeys().remove(sk);
						// 如果该SelectionKey对应的Channel中有可读的数据
						if (sk.isReadable())
						{
							// 使用NIO读取Channel中的数据
							SocketChannel sc = (SocketChannel)sk.channel();
							ByteBuffer buff = ByteBuffer.allocate(1024);
							String content = "";
							while(sc.read(buff) > 0)
							{
								buff.flip();
								content += charset.decode(buff);
							}
							// 打印输出读取的内容
							System.out.println("聊天信息：" + content);
							// 为下一次读取作准备
							sk.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
		throws IOException
	{
		new NClient().init();
	}
}
