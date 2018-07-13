

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
public class ModTest
{
	public static void main(String[] args)
	{
		double a = 5.2;
		double b = 3.1;
		double mod = a % b;

		System.out.println(mod); // mod的值为2.1
		System.out.println("5对0.0求余的结果是:" + 5 % 0.0); // 输出非数:NaN
		System.out.println("-5.0对0求余的结果是:" + -5.0 % 0); // 输出非数:NaN
		System.out.println("0对5.0求余的结果是:" + 0 % 5.0); // 输出0.0
		System.out.println("0对0.0求余的结果是:" + 0 % 0.0); // 输出非数:NaN
		// 下面代码将出现异常：java.lang.ArithmeticException: / by zero
		System.out.println("-5对0求余的结果是:" + -5 % 0);
	}
}
