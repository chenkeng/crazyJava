

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
public class StringCompareTest
{
	public static void main(String[] args)
	{
		// s1直接引用常量池中的"疯狂Java"
		String s1 = "疯狂Java";
		String s2 = "疯狂";
		String s3 = "Java";
		// s4后面的字符串值可以在编译时就确定下来
		// s4直接引用常量池中的"疯狂Java"
		String s4 = "疯狂" + "Java";
		// s5后面的字符串值可以在编译时就确定下来
		// s5直接引用常量池中的"疯狂Java"
		String s5 = "疯" + "狂" + "Java";
		// s6后面的字符串值不能在编译时就确定下来，
		// 不能引用常量池中的字符串
		String s6 = s2 + s3;
		// 使用new调用构造器将会创建一个新的String对象，
		// s7引用堆内存中新创建的String对象
		String s7 = new String("疯狂Java");
		System.out.println(s1 == s4); // 输出true
		System.out.println(s1 == s5); // 输出true
		System.out.println(s1 == s6); // 输出false
		System.out.println(s1 == s7); // 输出false
	}
}
