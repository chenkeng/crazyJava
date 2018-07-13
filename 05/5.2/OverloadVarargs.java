

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
public class OverloadVarargs
{
	public void test(String msg)
	{
		System.out.println("只有一个字符串参数的test方法 ");
	}
	// 因为前面已经有了一个test()方法，test()方法里有一个字符串参数。
	// 此处的个数可变形参里不包含一个字符串参数的形式
	public void test(String... books)
	{
		System.out.println("****形参个数可变的test方法****");
	}
	public static void main(String[] args)
	{
		OverloadVarargs olv = new OverloadVarargs();
		// 下面两次调用将执行第二个test()方法
		olv.test();
		olv.test("aa" , "bb");
		// 下面将执行第一个test()方法
		olv.test("aa");
		// 下面调用将执行第二个test()方法
		olv.test(new String[]{"aa"});
	}
}

