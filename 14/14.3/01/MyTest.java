

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
public class MyTest
{
	// 使用@Testable注解指定该方法是可测试的
	@Testable
	public static void m1()
	{
	}
	public static void m2()
	{
	}
	// 使用@Testable注解指定该方法是可测试的
	@Testable
	public static void m3()
	{
		throw new IllegalArgumentException("参数出错了！");
	}
	public static void m4()
	{
	}
	// 使用@Testable注解指定该方法是可测试的
	@Testable
	public static void m5()
	{
	}
	public static void m6()
	{
	}
	// 使用@Testable注解指定该方法是可测试的
	@Testable
	public static void m7()
	{
		throw new RuntimeException("程序业务出现异常！");
	}
	public static void m8()
	{
	}
}
