

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
public class BooleanTest
{
	public static void main(String[] args)
	{
		boolean b1 = true;
		boolean b2 = false;
		// 下面代码将出现错误：字符串不能直接变成boolean型的值
		// boolean b3 = "true";
		// 使用boolean和字符串进行连接运算，boolean会自动转换成字符串
		String str = true + "";
		// 下面将输出true
		System.out.println(str);
	}
}
