

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
class Tester
{
	static
	{
		System.out.println("Tester类的静态初始化块...");
	}
}
public class ClassLoaderTest
{
	public static void main(String[] args)
		throws ClassNotFoundException
	{
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		// 下面语句仅仅是加载Tester类
		cl.loadClass("Tester");
		System.out.println("系统加载Tester类");
		// 下面语句才会初始化Tester类
		Class.forName("Tester");
	}
}

