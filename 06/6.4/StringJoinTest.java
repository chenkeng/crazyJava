

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
public class StringJoinTest
{
	public static void main(String[] args)
	{
		String s1 = "疯狂Java";
		// s2变量引用的字符串可以编译时就确定出来，
		// 因此s2直接引用常量池中已有的"疯狂Java"字符串
		String s2 = "疯狂" + "Java";
		System.out.println(s1 == s2); // 输出true
		// 定义2个字符串直接量
		String str1 = "疯狂";     //①
		String str2 = "Java";     //②
		// 将str1和str2进行连接运算
		String s3 = str1 + str2;
		System.out.println(s1 == s3); // 输出false
	}
}
