
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
public class LambdaArrays
{
	public static void main(String[] args)
	{
		String[] arr1 = new String[]{"java" , "fkava" , "fkit", "ios" , "android"};
		Arrays.parallelSort(arr1, (o1, o2) -> o1.length() - o2.length());
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = new int[]{3, -4 , 25, 16, 30, 18};
		// left代表数组中前一个所索引处的元素，计算第一个元素时，left为1
		// right代表数组中当前索引处的元素
		Arrays.parallelPrefix(arr2, (left, right)-> left * right);
		System.out.println(Arrays.toString(arr2));
		long[] arr3 = new long[5];
		// operand代表正在计算的元素索引
		Arrays.parallelSetAll(arr3 , operand -> operand * 5);
		System.out.println(Arrays.toString(arr3));
	}
}
