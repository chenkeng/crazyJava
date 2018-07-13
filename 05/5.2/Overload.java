

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
public class Overload
{
	// 下面定义了两个test()方法，但方法的形参列表不同
	// 系统可以区分这两个方法，这种被称为方法重载
	public void test()
	{
		System.out.println("无参数");
	}
	public void test(String msg)
	{
		System.out.println("重载的test方法 " + msg);
	}
	public static void main(String[] args)
	{
		Overload ol = new Overload();
		// 调用test()时没有传入参数，因此系统调用上面没有参数的test()方法。
		ol.test();
		// 调用test()时传入了一个字符串参数，
		// 因此系统调用上面带一个字符串参数的test()方法。
		ol.test("hello");
	}
}
