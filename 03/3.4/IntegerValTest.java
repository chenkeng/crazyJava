

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
public class IntegerValTest
{
	public static void main(String[] args)
	{
		// 下面代码是正确的，系统会自动把56当成byte类型处理
		byte a = 56;
		/*
		下面代码是错的，系统不会把9999999999999当成long类型处理，
		所以超出int的表数范围，从而引起错误
		*/
		// long bigValue = 9999999999999;
		// 下面代码是正确的，在巨大的整数值后使用L后缀，强制使用long类型
		long bigValue2 = 9223372036854775807L;

		// 以0开头的整数值是8进制的整数
		int octalValue = 013;
		System.out.println(octalValue);
		// 以0x或0X开头的整数值是16进制的整数
		int hexValue1 = 0x13;
		int hexValue2 = 0XaF;

		System.out.println(hexValue1);
		System.out.println(hexValue2);

		// 定义二个8位的二进制数
		int binVal1 = 0b11010100;
		byte binVal2 = 0B01101001;
		// 定义一个32位的二进制数,最高位是符号位。
		int binVal3 = 0B10000000000000000000000000000011;
		System.out.println(binVal1); // 输出212
		System.out.println(binVal2); // 输出105
		System.out.println(binVal3); // 输出-2147483645
		/*
		 定义一个8位的二进制，该数值默认占32位，因此它是一个正数。
		 只是强制类型转换成byte时产生了溢出，最终导致binVal4变成了-23
		 */
		byte binVal4 =  (byte)0b11101001;
		/*
		  定义一个32位的二进制数,最高位是1。
		  但由于数值后添加了L后缀，因此该整数的实际占64位，第32位的1不是符号位。
		  因此binVal5的值等于2的31次方 + 2 + 1
		 */
		long binVal5 = 0B10000000000000000000000000000011L;
		System.out.println(binVal4); // 输出-23
		System.out.println(binVal5); // 输出2147483651
	}
}