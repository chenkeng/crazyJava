
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
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
public class SimpleAIOServer
{
	static final int PORT = 30000;
	public static void main(String[] args)
		throws Exception
	{
		try(
			// ①创建AsynchronousServerSocketChannel对象。
			AsynchronousServerSocketChannel serverChannel =
				AsynchronousServerSocketChannel.open())
		{
			// ②指定在指定地址、端口监听。
			serverChannel.bind(new InetSocketAddress(PORT));
			while (true)
			{
				// ③采用循环接受来自客户端的连接
				Future<AsynchronousSocketChannel> future
					= serverChannel.accept();
				// 获取连接完成后返回的AsynchronousSocketChannel
				AsynchronousSocketChannel socketChannel = future.get();
				// 执行输出。
				socketChannel.write(ByteBuffer.wrap("欢迎你来自AIO的世界！"
					.getBytes("UTF-8"))).get();
			}
		}
	}
}
