
import java.util.*;
/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0
 */
public class GenericAndArray
{
	public static void main(String[] args)
	{
//		// 下面代码编译时有“[unchecked] 未经检查的转换”警告
//		List<String>[] lsa = new ArrayList[10];
//		// 将lsa向上转型为Object[]类型的变量
//		Object[] oa = lsa;
//		List<Integer> li = new ArrayList<>();
//		li.add(3);
//		oa[1] = li;
//		// 下面代码引起ClassCastException异常
//		String s = lsa[1].get(0);              // ①

		List<?>[] lsa = new ArrayList<?>[10];
		Object[] oa = lsa;
		List<Integer> li = new ArrayList<>();
		li.add(3);
		oa[1] = li;
		Object target = lsa[1].get(0);
		if (target instanceof String)
		{
			// 下面代码安全了
			String s = (String) target;
		}
	}
}
