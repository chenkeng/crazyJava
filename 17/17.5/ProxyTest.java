
import java.io.*;
import java.net.*;
import java.util.*;
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
public class ProxyTest
{
	// 下面是代理服务器的地址和端口，
	// 换成实际有效的代理服务器的地址和端口
	final String PROXY_ADDR = "129.82.12.188";
	final int PROXY_PORT = 3124;
	// 定义需要访问的网站地址
	String urlStr = "http://www.crazyit.org";
	public void init()
		throws IOException , MalformedURLException
	{
		URL url = new URL(urlStr);
		// 创建一个代理服务器对象
		Proxy proxy = new Proxy(Proxy.Type.HTTP
			, new InetSocketAddress(PROXY_ADDR , PROXY_PORT));
		// 使用指定的代理服务器打开连接
		URLConnection conn = url.openConnection(proxy);
		// 设置超时时长。
		conn.setConnectTimeout(5000);
		try(
			// 通过代理服务器读取数据的Scanner
			Scanner scan = new Scanner(conn.getInputStream(), "utf-8");
			PrintStream ps = new PrintStream("index.htm"))
		{
			while (scan.hasNextLine())
			{
				String line = scan.nextLine();
				// 在控制台输出网页资源内容
				System.out.println(line);
				// 将网页资源内容输出到指定输出流
				ps.println(line);
			}
		}
	}
	public static void main(String[] args)
		throws IOException , MalformedURLException
	{
		new ProxyTest().init();
	}
}
