

/**
 * Description:
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ThreeTest
{
	public static void main(String[] args)
	{
		String str = 5 > 3 ? "5大于3" : "5不大于3";
		System.out.println(str); // 输出"5大于3"
		String str2 = null;
		if (5 > 3)
		{
			str2 = "5大于3";
		}
		else
		{
			str2 = "5不大于3";
		}
		int a = 11;
		int b = 12;
		// 三目运算符支持嵌套
		System.out.println(a > b ?
			"a大于b" : (a < b ? "a小于b" : "a等于b"));
	}
}
