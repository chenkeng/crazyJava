

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
public class MathTest
{
	public static void main(String[] args)
	{
		double a = 3.2; // 定义变量a为3.2
		// 求a的5次方，并将计算结果赋为b。
		double b = Math.pow(a , 5);
		System.out.println(b); // 输出b的值。
		// 求a的平方根，并将结果赋给c
		double c = Math.sqrt(a);
		System.out.println(c); // 输出c的值。
		// 计算随机数,返回一个0～1之间的伪随机数。
		double d = Math.random();
		System.out.println(d); // 输出随机数d的值
		// 求1.57的sin函数值：1.57被当成弧度数
		double e = Math.sin(1.57);
		System.out.println(e); // 输出接近1
	}
}
