
import java.net.*;
import java.io.*;
import java.util.*;
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
public class AIOServer
{
	static final int PORT = 30000;
	final static String UTF_8 = "utf-8";
	static List<AsynchronousSocketChannel> channelList
		= new ArrayList<>();
	public void startListen() throws InterruptedException,
		Exception
	{
		// 创建一个线程池
		ExecutorService executor = Executors.newFixedThreadPool(20);
		// 以指定线程池来创建一个AsynchronousChannelGroup
		AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup
			.withThreadPool(executor);
		// 以指定线程池来创建一个AsynchronousServerSocketChannel
		AsynchronousServerSocketChannel serverChannel
			= AsynchronousServerSocketChannel.open(channelGroup)
			// 指定监听本机的PORT端口
			.bind(new InetSocketAddress(PORT));
		// 使用CompletionHandler接受来自客户端的连接请求
		serverChannel.accept(null, new AcceptHandler(serverChannel));  // ①
		Thread.sleep(100000);
	}
	public static void main(String[] args)
		throws Exception
	{
		AIOServer server = new AIOServer();
		server.startListen();
	}
}
// 实现自己的CompletionHandler类
class AcceptHandler implements
	CompletionHandler<AsynchronousSocketChannel, Object>
{
	private AsynchronousServerSocketChannel serverChannel;
	public AcceptHandler(AsynchronousServerSocketChannel sc)
	{
		this.serverChannel = sc;
	}
	// 定义一个ByteBuffer准备读取数据
	ByteBuffer buff = ByteBuffer.allocate(1024);
	// 当实际IO操作完成时候触发该方法
	@Override
	public void completed(final AsynchronousSocketChannel sc
		, Object attachment)
	{
		// 记录新连接的进来的Channel
		AIOServer.channelList.add(sc);
		// 准备接受客户端的下一次连接
		serverChannel.accept(null , this);
		sc.read(buff , null
			, new CompletionHandler<Integer,Object>()  // ②
		{
			@Override
			public void completed(Integer result
				, Object attachment)
			{
				buff.flip();
				// 将buff中内容转换为字符串
				String content = StandardCharsets.UTF_8
					.decode(buff).toString();
				// 遍历每个Channel，将收到的信息写入各Channel中
				for(AsynchronousSocketChannel c : AIOServer.channelList)
				{
					try
					{
						c.write(ByteBuffer.wrap(content.getBytes(
							AIOServer.UTF_8))).get();
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
				buff.clear();
				// 读取下一次数据
				sc.read(buff , null , this);
			}
			@Override
			public void failed(Throwable ex, Object attachment)
			{
				System.out.println("读取数据失败: " + ex);
				// 从该Channel读取数据失败，就将该Channel删除
				AIOServer.channelList.remove(sc);
			}
		});
	}
	@Override
	public void failed(Throwable ex, Object attachment)
	{
		System.out.println("连接失败: " + ex);
	}
}