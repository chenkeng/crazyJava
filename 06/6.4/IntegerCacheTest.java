

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
public class IntegerCacheTest
{
	public static void main(String[] args)
	{
		// 生成新的Integer对象
		Integer in1 = new Integer(6);
		// 生成新的Integer对象，并缓存该对象
		Integer in2 = Integer.valueOf(6);
		// 直接从缓存中取出Ineger对象
		Integer in3 = Integer.valueOf(6);
		System.out.println(in1 == in2); // 输出false
		System.out.println(in2 == in3); // 输出true
		// 由于Integer只缓存-128~127之间的值，
		// 因此200对应的Integer对象没有被缓存。
		Integer in4 = Integer.valueOf(200);
		Integer in5 = Integer.valueOf(200);
		System.out.println(in4 == in5); //输出false
	}
}

