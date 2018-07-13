

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
public class ArrayTest
{
	public static void main(String[] args)
	{
		// 定义一个int数组类型的变量，变量名为intArr.
		int[] intArr;
		// 使用静态初始化，初始化数组时只指定数组元素的初始值，不指定数组长度。
		intArr = new int[]{5, 6, 8 , 20};
		// 定义一个Object数组类型的变量，变量名为objArr.
		Object[] objArr ;
		// 使用静态初始化，初始化数组时数组元素的类型是
		// 定义数组时所指定的数组元素类型的子类
		objArr = new String[]{"Java" , "李刚"};
		Object[] objArr2 ;
		// 使用静态初始化
		objArr2 = new Object[] {"Java" , "李刚"};


		// 数组的定义和初始化同时完成，使用简化的静态初始化写法
		int[] a = {5, 6 , 7, 9};


		//数组的定义和初始化同时完成，使用动态初始化语法
		int[] prices = new int[5];
		// 数组的定义和初始化同时完成，初始化数组时元素的类型是定义数组时元素类型的子类
		Object[] books = new String[4];


		// 输出objArr数组的第二个元素，将输出字符串"李刚"
		System.out.println(objArr[1]);
		// 为objArr2的第一个数组元素赋值
		objArr2[0] = "Spring";

		// 访问数组元素指定的索引等于数组长度，所以下面代码将在运行时出现异常
		// System.out.println(objArr2[2]);


		// 使用循环输出prices数组的每个数组元素的值
		for (int i = 0; i < prices.length ; i ++ )
		{
			System.out.println(prices[i]);
		}

		// 对动态初始化后的数组元素进行赋值
		books[0] = "疯狂Java讲义";
		books[1] = "轻量级Java EE企业应用实战";
		// 使用循环输出books数组的每个数组元素的值
		for (int i = 0 ; i < books.length ; i++ )
		{
			System.out.println(books[i]);
		}
	}
}
