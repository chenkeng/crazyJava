

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
public class BlockTest
{
	public static void main(String[] args)
	{
		{
			// 定义一个代码块局部变量a
			int a;
			// 下面代码将出现错误，因为a变量还未初始化
			// System.out.println("代码块局部变量a的值：" + a);
			// 为a变量赋初始值，也就是进行初始化
			a = 5;
			System.out.println("代码块局部变量a的值：" + a);
		}
		// 下面试图访问的a变量并不存在
		// System.out.println(a);
	}
}

