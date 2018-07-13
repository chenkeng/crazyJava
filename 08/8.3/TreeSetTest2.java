
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

class Z implements Comparable
{
	int age;
	public Z(int age)
	{
		this.age = age;
	}
	// 重写equals()方法，总是返回true
	public boolean equals(Object obj)
	{
		return true;
	}
	// 重写了compareTo(Object obj)方法，总是返回1
	public int compareTo(Object obj)
	{
		return 1;
	}
}
public class TreeSetTest2
{
	public static void main(String[] args)
	{
		TreeSet set = new TreeSet();
		Z z1 = new Z(6);
		set.add(z1);
		// 第二次添加同一个对象，输出true，表明添加成功
		System.out.println(set.add(z1));    //①
		// 下面输出set集合，将看到有两个元素
		System.out.println(set);
		// 修改set集合的第一个元素的age变量
		 ((Z)(set.first())).age = 9;
		// 输出set集合的最后一个元素的age变量，将看到也变成了9
		System.out.println(((Z)(set.last())).age);
	}
}
