
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

class A
{
	int count;
	public A(int count)
	{
		this.count = count;
	}
	// 根据count的值来判断两个对象是否相等。
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (obj != null && obj.getClass() == A.class)
		{
			A a = (A)obj;
			return this.count == a.count;
		}
		return false;
	}
	// 根据count来计算hashCode值。
	public int hashCode()
	{
		return this.count;
	}
}
class B
{
	// 重写equals()方法，B对象与任何对象通过equals()方法比较都返回true
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class HashtableTest
{
	public static void main(String[] args)
	{
		Hashtable ht = new Hashtable();
		ht.put(new A(60000) , "疯狂Java讲义");
		ht.put(new A(87563) , "轻量级Java EE企业应用实战");
		ht.put(new A(1232) , new B());
		System.out.println(ht);
		// 只要两个对象通过equals比较返回true，
		// Hashtable就认为它们是相等的value。
		// 由于Hashtable中有一个B对象，
		// 它与任何对象通过equals比较都相等，所以下面输出true。
		System.out.println(ht.containsValue("测试字符串")); // ① 输出true
		// 只要两个A对象的count相等，它们通过equals比较返回true，且hashCode相等
		// Hashtable即认为它们是相同的key，所以下面输出true。
		System.out.println(ht.containsKey(new A(87563)));   // ② 输出true
		// 下面语句可以删除最后一个key-value对
		ht.remove(new A(1232));    //③
		System.out.println(ht);
	}
}
