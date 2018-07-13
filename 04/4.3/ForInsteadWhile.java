

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
public class ForInsteadWhile
{
	public static void main(String[] args)
	{
		// 把for循环的初始化条件提出来独立定义
		int count = 0;
		// for循环里只放循环条件
		for( ; count < 10 ; )
		{
			System.out.println(count);
			// 把循环迭代部分放在循环体之后定义
			count++;
		}
		System.out.println("循环结束!");
		// 此处将还可以访问count变量
	}
}
