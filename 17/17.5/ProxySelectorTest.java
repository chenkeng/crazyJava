
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
public class ProxySelectorTest
{
	// 下面是代理服务器的地址和端口，
	// 随便一个代理服务器的地址和端口
	final String PROXY_ADDR = "139.82.12.188";
	final int PROXY_PORT = 3124;
	// 定义需要访问的网站地址
	String urlStr = "http://www.crazyit.org";
	public void init()
		throws IOException , MalformedURLException
	{
		// 注册默认的代理选择器
		ProxySelector.setDefault(new ProxySelector()
		{
			@Override
			public void connectFailed(URI uri
				, SocketAddress sa, IOException ioe)
			{
				System.out.println("无法连接到指定代理服务器！");
			}
			// 根据"业务需要"返回特定的对应的代理服务器
			@Override
			public List<Proxy> select(URI uri)
			{
				// 本程序总是返回某个固定的代理服务器。
				List<Proxy> result = new ArrayList<>();
				result.add(new Proxy(Proxy.Type.HTTP
					, new InetSocketAddress(PROXY_ADDR , PROXY_PORT)));
				return result;
			}
		});
		URL url = new URL(urlStr);
		// 没有指定代理服务器、直接打开连接
		URLConnection conn = url.openConnection();   //①
		// 设置超时时长。
		conn.setConnectTimeout(3000);
		try(
			// 通过代理服务器读取数据的Scanner
			Scanner scan = new Scanner(conn.getInputStream());
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
		new ProxySelectorTest().init();
	}
}