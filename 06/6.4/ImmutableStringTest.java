

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
public class ImmutableStringTest
{
	public static void main(String[] args)
	{
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1 == str2); // 输出false
		System.out.println(str1.equals(str2)); // 输出true
		// 下面两次输出的hashCode相同
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}
