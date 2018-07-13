

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
public class Varargs
{
	// 定义了形参个数可变的方法
	public static void test(int a , String... books)
	{
		// books被当成数组处理
		for (String tmp : books)
		{
			System.out.println(tmp);
		}
		// 输出整数变量a的值
		System.out.println(a);
	}
	public static void main(String[] args)
	{
		// 调用test方法
		test(5 , "疯狂Java讲义" , "轻量级Java EE企业应用实战");
	}
}

