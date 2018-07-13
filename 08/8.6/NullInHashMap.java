
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
public class NullInHashMap
{
	public static void main(String[] args)
	{
		HashMap hm = new HashMap();
		// 试图将两个key为null的key-value对放入HashMap中
		hm.put(null , null);
		hm.put(null , null);    // ①
		// 将一个value为null的key-value对放入HashMap中
		hm.put("a" , null);    // ②
		// 输出Map对象
		System.out.println(hm);
	}
}
