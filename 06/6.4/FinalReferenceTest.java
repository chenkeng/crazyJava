
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
class Person
{
	private int age;
	public Person(){}
	// 有参数的构造器
	public Person(int age)
	{
		this.age = age;
	}
	// 省略age的setter和getter方法
	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}
}
public class FinalReferenceTest
{
	public static void main(String[] args)
	{
		// final修饰数组变量，iArr是一个引用变量
		final int[] iArr = {5, 6, 12, 9};
		System.out.println(Arrays.toString(iArr));
		// 对数组元素进行排序，合法
		Arrays.sort(iArr);
		System.out.println(Arrays.toString(iArr));
		// 对数组元素赋值，合法
		iArr[2] = -8;
		System.out.println(Arrays.toString(iArr));
		// 下面语句对iArr重新赋值，非法
		// iArr = null;
		// final修饰Person变量，p是一个引用变量
		final Person p = new Person(45);
		// 改变Person对象的age实例变量，合法
		p.setAge(23);
		System.out.println(p.getAge());
		// 下面语句对p重新赋值，非法
		// p = null;
	}
}