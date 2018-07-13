

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
public class BreakTest
{
	public static void main(String[] args)
	{
		// 一个简单的for循环
		for (int i = 0; i < 10 ; i++ )
		{
			System.out.println("i的值是" + i);
			if (i == 2)
			{
				// 执行该语句时将结束循环
				break;
			}
		}
	}
}
