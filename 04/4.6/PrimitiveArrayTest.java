

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
public class PrimitiveArrayTest
{
	public static void main(String[] args)
	{
		// 定义一个int[]类型的数组变量
		int[] iArr;
		// 动态初始化数组，数组长度为5
		iArr = new int[5];
		// 采用循环方式为每个数组元素赋值。
		for (int i = 0; i <iArr.length ; i++ )
		{
			iArr[i] = i + 10;
		}
	}
}
