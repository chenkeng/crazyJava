

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
public class BitOperatorTest
{
	public static void main(String[] args)
	{
//		System.out.println(2.5 & 3.0);
		System.out.println(5 & 9); // 将输出1
		System.out.println(5 | 9); // 将输出13
		System.out.println(~-5); // 将输出4
		System.out.println(5 ^ 9); // 将输出12
		System.out.println(5 << 2); // 输出20
		System.out.println(-5 << 2); // 输出-20
		System.out.println(-5 >> 2); // 输出-2
		System.out.println(-5 >>> 2); // 输出1073741822
	}
}
