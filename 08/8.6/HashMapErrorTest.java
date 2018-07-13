
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
public class HashMapErrorTest
{
	public static void main(String[] args)
	{
		HashMap ht = new HashMap();
		// 此处的A类与前一个程序的A类是同一个类
		ht.put(new A(60000) , "疯狂Java讲义");
		ht.put(new A(87563) , "轻量级Java EE企业应用实战");
		// 获得Hashtable的key Set集合对应的Iterator迭代器
		Iterator it = ht.keySet().iterator();
		// 取出Map中第一个key，并修改它的count值
		A first = (A)it.next();
		first.count = 87563;   // ①
		// 输出{A@1560b=疯狂Java讲义, A@1560b=轻量级Java EE企业应用实战}
		System.out.println(ht);
		// 只能删除没有被修改过的key所对应的key-value对
		ht.remove(new A(87563));
		System.out.println(ht);
		// 无法获取剩下的value，下面两行代码都将输出null。
		System.out.println(ht.get(new A(87563)));   // ② 输出null
		System.out.println(ht.get(new A(60000)));   // ③ 输出null
	}
}

