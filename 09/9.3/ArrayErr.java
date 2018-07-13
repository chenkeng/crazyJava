
import java.util.*;
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
public class ArrayErr
{
	public static void main(String[] args)
	{
		// 定义一个Integer数组
		Integer[] ia = new Integer[5];
		// 可以把一个Integer[]数组赋给Number[]变量
		Number[] na = ia;
		// 下面代码编译正常，但运行时会引发ArrayStoreException异常
		// 因为0.5并不是Integer
		na[0] = 0.5;   // ①
		List<Integer> iList = new ArrayList<>();
		// 下面代码导致编译错误
		List<Number> nList = iList;
	}
}
