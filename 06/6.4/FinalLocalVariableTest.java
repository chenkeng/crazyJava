

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
public class FinalLocalVariableTest
{
	public void test(final int a)
	{
		// 不能对final修饰的形参赋值，下面语句非法
		// a = 5;
	}
	public static void main(String[] args)
	{
		// 定义final局部变量时指定默认值，则str变量无法重新赋值
		final String str = "hello";
		// 下面赋值语句非法
		// str = "Java";
		// 定义final局部变量时没有指定默认值，则d变量可被赋值一次
		final double d;
		// 第一次赋初始值，成功
		d = 5.6;
		// 对final变量重复赋值，下面语句非法
		// d = 3.4;
	}
}
