
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

// 类A的equals方法总是返回true，但没有重写其hashCode()方法
class A
{
	public boolean equals(Object obj)
	{
		return true;
	}
}
// 类B的hashCode()方法总是返回1，但没有重写其equals()方法
class B
{
	public int hashCode()
	{
		return 1;
	}
}
// 类C的hashCode()方法总是返回2，且重写其equals()方法总是返回true
class C
{
	public int hashCode()
	{
		return 2;
	}
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class HashSetTest
{
	public static void main(String[] args)
	{
		HashSet books = new HashSet();
		// 分别向books集合中添加两个A对象，两个B对象，两个C对象
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
	}
}
