
import java.util.Arrays;
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
public class ArraysTest
{
	public static void main(String[] args)
	{
		// 定义一个a数组
		int[] a = new int[]{3, 4 , 5, 6};
		// 定义一个a2数组
		int[] a2 = new int[]{3, 4 , 5, 6};
		// a数组和a2数组的长度相等，每个元素依次相等，将输出true
		System.out.println("a数组和a2数组是否相等："
			+ Arrays.equals(a , a2));
		// 通过复制a数组，生成一个新的b数组
		int[] b = Arrays.copyOf(a, 6);
		System.out.println("a数组和b数组是否相等："
			+ Arrays.equals(a , b));
		// 输出b数组的元素，将输出[3, 4, 5, 6, 0, 0]
		System.out.println("b数组的元素为："
			+ Arrays.toString(b));
		// 将b数组的第3个元素（包括）到第5个元素（不包括）赋为1
		Arrays.fill(b , 2, 4 , 1);
		// 输出b数组的元素，将输出[3, 4, 1, 1, 0, 0]
		System.out.println("b数组的元素为："
			+ Arrays.toString(b));
		// 对b数组进行排序
		Arrays.sort(b);
		// 输出b数组的元素，将输出[0, 0, 1, 1, 3, 4]
		System.out.println("b数组的元素为："
			+ Arrays.toString(b));
	}
}
