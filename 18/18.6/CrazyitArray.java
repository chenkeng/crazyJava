
import java.lang.reflect.*;
import java.lang.annotation.*;
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
public class CrazyitArray
{
	// 对Array的newInstance方法进行包装
	@SuppressWarnings("unchecked")
	public static <T> T[] newInstance(Class<T> componentType, int length)
	{
		return (T[])Array.newInstance(componentType , length);  //①
	}
	public static void main(String[] args)
	{
		// 使用CrazyitArray的newInstance()创建一维数组
		String[] arr = CrazyitArray.newInstance(String.class , 10);
		// 使用CrazyitArray的newInstance()创建二维数组
		// 在这种情况下，只要设置数组元素的类型是int[]即可。
		int[][] intArr = CrazyitArray.newInstance(int[].class , 5);
		arr[5] = "疯狂Java讲义";
		// intArr是二维数组，初始化该数组的第二个数组元素
		// 二维数组的元素必须是一维数组
		intArr[1] = new int[]{23, 12};
		System.out.println(arr[5]);
		System.out.println(intArr[1][1]);
	}
}
