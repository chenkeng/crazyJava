

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
class Base
{
	public Base()
	{
		test();
	}
	public void test()           // ①号test()方法
	{
		System.out.println("将被子类重写的方法");
	}
}
public class Sub extends Base
{
	private String name;
	public void test()         // ②号test()方法
	{
		System.out.println("子类重写父类的方法，"
			+ "其name字符串长度" + name.length());
	}
	public static void main(String[] args)
	{
		// 下面代码会引发空指针异常
		Sub s = new Sub();
	}
}
