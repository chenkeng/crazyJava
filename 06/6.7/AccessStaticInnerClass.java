

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
public class AccessStaticInnerClass
{
	static class StaticInnerClass
	{
		private static int prop1 = 5;
		private int prop2 = 9;
	}
	public void accessInnerProp()
	{
		// System.out.println(prop1);
		// 上面代码出现错误，应改为如下形式：
		// 通过类名访问静态内部类的类成员
		System.out.println(StaticInnerClass.prop1);
		// System.out.println(prop2);
		// 上面代码出现错误，应改为如下形式：
		// 通过实例访问静态内部类的实例成员
		System.out.println(new StaticInnerClass().prop2);
	}
}

