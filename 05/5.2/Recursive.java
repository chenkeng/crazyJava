

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
public class Recursive
{
	public static int fn(int n)
	{
		if (n == 0)
		{
			return 1;
		}
		else if (n == 1)
		{
			return 4;
		}
		else
		{
			// 方法中调用它自身，就是方法递归
			return 2 * fn(n - 1) + fn(n - 2);
		}
	}
	public static void main(String[] args)
	{
		// 输出fn(10)的结果
		System.out.println(fn(10));
	}
}

