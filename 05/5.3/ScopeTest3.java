

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
public class ScopeTest3
{
	public static void main(String[] args)
	{
		// 定义一个代码块局部变量作为循环变量
		for (int i = 0 ; i < 10 ; i++)
		{
			System.out.println("Hello");
		}
	}
}
