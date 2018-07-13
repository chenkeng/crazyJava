

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
public class ForErrorTest
{
	public static void main(String[] args)
	{
		// 循环的初始化条件,循环条件，循环迭代语句都在下面一行
		for (int count = 0 ; count < 10 ; count++)
		{
			System.out.println(count);
			// 再次修改了循环变量
			count *= 0.1;
		}
		System.out.println("循环结束!");
	}
}