

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
public class NullAccessStatic
{
	private static void test()
	{
		System.out.println("static修饰的类方法");
	}
	public static void main(String[] args)
	{
		// 定义一个NullAccessStatic变量，其值为null
		NullAccessStatic nas = null;
		// 使用null对象调用所属类的静态方法
		nas.test();
	}
}
