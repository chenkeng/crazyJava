

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
public class PrimitiveAndString
{
	public static void main(String[] args)
	{
		// 下面代码是错的，因为5是一个整数，不能直接赋给一个字符串
		// String str1 = 5;
		// 一个基本类型值和字符串进行连接运算时，基本类型值自动转换为字符串
		String str2 = 3.5f + "";
		// 下面输出3.5
		System.out.println(str2);
		// 下面语句输出7Hello!
		System.out.println(3 + 4 + "Hello！");
		// 下面语句输出Hello!34，因为Hello! + 3会把3当成字符串处理，
		// 而后再把4当成字符串处理
		System.out.println("Hello！" + 3 + 4);
	}
}
