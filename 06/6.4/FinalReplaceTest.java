

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
public class FinalReplaceTest
{
	public static void main(String[] args)
	{
		// 下面定义了4个final“宏变量”
		final int a = 5 + 2;
		final double b = 1.2 / 3;
		final String str = "疯狂" + "Java";
		final String book = "疯狂Java讲义：" + 99.0;
		// 下面的book2变量的值因为调用了方法，所以无法在编译时被确定下来
		final String book2 = "疯狂Java讲义：" + String.valueOf(99.0);  //①
		System.out.println(book == "疯狂Java讲义：99.0");
		System.out.println(book2 == "疯狂Java讲义：99.0");
	}
}
