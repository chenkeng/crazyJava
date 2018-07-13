

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
		/*---------下面是三角运算---------*/
		// 将弧度转换角度
		System.out.println("Math.toDegrees(1.57)："
			+ Math.toDegrees(1.57));
		// 将角度转换为弧度
		System.out.println("Math.toRadians(90)："
			+ Math.toRadians(90));
		// 计算反余弦，返回的角度范围在 0.0 到 pi 之间。
		System.out.println("Math.acos(1.2)：" + Math.acos(1.2));
		// 计算反正弦；返回的角度范围在 -pi/2 到 pi/2 之间。
		System.out.println("Math.asin(0.8)：" + Math.asin(0.8));
		// 计算反正切；返回的角度范围在 -pi/2 到 pi/2 之间。
		System.out.println("Math.atan(2.3)：" + Math.atan(2.3));
		// 计算三角余弦。
		System.out.println("Math.cos(1.57)：" + Math.cos(1.57));
		// 计算值的双曲余弦。
		System.out.println("Math.cosh(1.2 )：" + Math.cosh(1.2 ));
		// 计算正弦
		System.out.println("Math.sin(1.57 )：" + Math.sin(1.57 ));
		// 计算双曲正弦
		System.out.println("Math.sinh(1.2 )：" + Math.sinh(1.2 ));
		// 计算三角正切
		System.out.println("Math.tan(0.8 )：" + Math.tan(0.8 ));
		// 计算双曲正切
		System.out.println("Math.tanh(2.1 )：" + Math.tanh(2.1 ));
		// 将矩形坐标 (x, y) 转换成极坐标 (r, thet));
		System.out.println("Math.atan2(0.1, 0.2)：" + Math.atan2(0.1, 0.2));
		/*---------下面是取整运算---------*/
		// 取整，返回小于目标数的最大整数。
		System.out.println("Math.floor(-1.2 )：" + Math.floor(-1.2 ));
		// 取整，返回大于目标数的最小整数。
		System.out.println("Math.ceil(1.2)：" + Math.ceil(1.2));
		// 四舍五入取整
		System.out.println("Math.round(2.3 )：" + Math.round(2.3 ));
		/*---------下面是乘方、开方、指数运算---------*/
		// 计算平方根。
		System.out.println("Math.sqrt(2.3 )：" + Math.sqrt(2.3 ));
		// 计算立方根。
		System.out.println("Math.cbrt(9)：" + Math.cbrt(9));
		// 返回欧拉数 e 的n次幂。
		System.out.println("Math.exp(2)：" + Math.exp(2));
		// 返回 sqrt(x2 +y2)
		System.out.println("Math.hypot(4 , 4)：" + Math.hypot(4 , 4));
		// 按照 IEEE 754 标准的规定，对两个参数进行余数运算。
		System.out.println("Math.IEEEremainder(5 , 2)："
			+ Math.IEEEremainder(5 , 2));
		// 计算乘方
		System.out.println("Math.pow(3, 2)：" + Math.pow(3, 2));
		// 计算自然对数
		System.out.println("Math.log(12)：" + Math.log(12));
		// 计算底数为 10 的对数。
		System.out.println("Math.log10(9)：" + Math.log10(9));
		// 返回参数与 1 之和的自然对数。
		System.out.println("Math.log1p(9)：" + Math.log1p(9));
		/*---------下面是符号相关的运算---------*/
		// 计算绝对值。
		System.out.println("Math.abs(-4.5)：" + Math.abs(-4.5));
		// 符号赋值，返回带有第二个浮点数符号的第一个浮点参数。
		System.out.println("Math.copySign(1.2, -1.0)："
			+ Math.copySign(1.2, -1.0));
		// 符号函数；如果参数为 0，则返回 0；如果参数大于 0，
		// 则返回 1.0；如果参数小于 0，则返回 -1.0。
		System.out.println("Math.signum(2.3)：" + Math.signum(2.3));
		/*---------下面是大小相关的运算---------*/
		// 找出最大值
		System.out.println("Math.max(2.3 , 4.5)：" + Math.max(2.3 , 4.5));
		// 计算最小值
		System.out.println("Math.min(1.2 , 3.4)：" + Math.min(1.2 , 3.4));
		// 返回第一个参数和第二个参数之间与第一个参数相邻的浮点数。
		System.out.println("Math.nextAfter(1.2, 1.0)："
			+ Math.nextAfter(1.2, 1.0));
		// 返回比目标数略大的浮点数
		System.out.println("Math.nextUp(1.2 )：" + Math.nextUp(1.2 ));
		// 返回一个伪随机数，该值大于等于 0.0 且小于 1.0。
		System.out.println("Math.random()：" + Math.random());
	}
}
