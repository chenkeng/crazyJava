

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
	private String name;
	public Person(String name)
	{
		this.name = name;
	}
}
public class PrintObject
{
	public static void main(String[] args)
	{
		// 创建一个Person对象，将之赋给p变量
		Person p = new Person("孙悟空");
		// 打印p所引用的Person对象
		System.out.println(p);
	}
}

