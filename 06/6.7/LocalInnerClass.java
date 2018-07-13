

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
public class LocalInnerClass
{
	public static void main(String[] args)
	{
		// 定义局部内部类
		class InnerBase
		{
			int a;
		}
		// 定义局部内部类的子类
		class InnerSub extends InnerBase
		{
			int b;
		}
		// 创建局部内部类的对象
		InnerSub is = new InnerSub();
		is.a = 5;
		is.b = 8;
		System.out.println("InnerSub对象的a和b实例变量是："
			+ is.a + "," + is.b);
	}
}

