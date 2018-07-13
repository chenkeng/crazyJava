

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
public class WhileTest
{
	public static void main(String[] args)
	{
//		// 循环的初始化条件
//		int count = 0;
//		// 当count小于10时，执行循环体
//		while (count < 10)
//		{
//			System.out.println(count);
//			// 迭代语句
//			count++;
//		}
//		System.out.println("循环结束!");


//		// 下面是一个死循环
//		int count = 0;
//		while (count < 10)
//		{
//			System.out.println("不停执行的死循环 " + count);
//			count--;
//		}
//		System.out.println("永远无法跳出的循环体");


		int count = 0;
		// while后紧跟一个分号，表明循环体是一个分号（空语句）
		while (count < 10);
		// 下面的代码块与while循环已经没有任何关系
		{
			System.out.println("------" + count);
			count++;
		}

	}
}
