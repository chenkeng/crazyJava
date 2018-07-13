
import java.lang.reflect.*;
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
public class ArrayTest1
{
	public static void main(String args[])
	{
		try
		{
			// 创建一个元素类型为String ，长度为10的数组
			Object arr = Array.newInstance(String.class, 10);
			// 依次为arr数组中index为5、6的元素赋值
			Array.set(arr, 5, "疯狂Java讲义");
			Array.set(arr, 6, "轻量级Java EE企业应用实战");
			// 依次取出arr数组中index为5、6的元素的值
			Object book1 = Array.get(arr , 5);
			Object book2 = Array.get(arr , 6);
			// 输出arr数组中index为5、6的元素
			System.out.println(book1);
			System.out.println(book2);
		}
		catch (Throwable e)
		{
			System.err.println(e);
		}
	}
}
