
package yeeku;
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

public class OutputFieldTest
{
	public static void main(String[] args)
	{
		// 访问另一个包中的Output接口的MAX_CACHE_LINE
		System.out.println(lee.Output.MAX_CACHE_LINE);
		// 下面语句将引起"为final变量赋值"的编译异常
		// lee.Output.MAX_CACHE_LINE = 20;
		// 使用接口来调用类方法
		System.out.println(lee.Output.staticTest());
	}
}
