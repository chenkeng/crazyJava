
import java.net.*;
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
public class SimpleAIOClient
{
	static final int PORT = 30000;
	public static void main(String[] args)
		throws Exception
	{
		// 用于读取数据的ByteBuffer。
		ByteBuffer buff = ByteBuffer.allocate(1024);
		Charset utf = Charset.forName("utf-8");
		try(
			// ①创建AsynchronousSocketChannel对象
			AsynchronousSocketChannel clientChannel
				= AsynchronousSocketChannel.open())
		{
			// ②连接远程服务器
			clientChannel.connect(new InetSocketAddress("127.0.0.1"
				, PORT)).get();     // ④
			buff.clear();
			// ③从clientChannel中读取数据
			clientChannel.read(buff).get();     // ⑤
			buff.flip();
			// 将buff中内容转换为字符串
			String content = utf.decode(buff).toString();
			System.out.println("服务器信息：" + content);
		}
	}
}
