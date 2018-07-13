
import java.io.*;
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
public class ThrowsTest2
{
	public static void main(String[] args)
		throws Exception
	{
		// 因为test()方法声明抛出IOException异常，
		// 所以调用该方法的代码要么处于try...catch块中，
		// 要么处于另一个带throws声明抛出的方法中。
		test();
	}
	public static void test()throws IOException
	{
		// 因为FileInputStream的构造器声明抛出IOException异常，
		// 所以调用FileInputStream的代码要么处于try...catch块中，
		// 要么处于另一个带throws声明抛出的方法中。
		FileInputStream fis = new FileInputStream("a.txt");
	}
}
