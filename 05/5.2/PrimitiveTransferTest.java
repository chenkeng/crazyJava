

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
public class PrimitiveTransferTest
{
	public static void swap(int a , int b)
	{
		// 下面三行代码实现a、b变量的值交换。
		// 定义一个临时变量来保存a变量的值
		int tmp = a;
		// 把b的值赋给a
		a = b;
		// 把临时变量tmp的值赋给b
		b = tmp;
		System.out.println("swap方法里，a的值是"
			+ a + "；b的值是" + b);
	}
	public static void main(String[] args)
	{
		int a = 6;
		int b = 9;
		swap(a , b);
		System.out.println("交换结束后，变量a的值是"
			+ a + "；变量b的值是" + b);
	}
}
