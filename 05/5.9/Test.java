

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
class Root
{
	static{
		System.out.println("Root的静态初始化块");
	}
	{
		System.out.println("Root的普通初始化块");
	}
	public Root()
	{
		System.out.println("Root的无参数的构造器");
	}
}
class Mid extends Root
{
	static{
		System.out.println("Mid的静态初始化块");
	}
	{
		System.out.println("Mid的普通初始化块");
	}
	public Mid()
	{
		System.out.println("Mid的无参数的构造器");
	}
	public Mid(String msg)
	{
		// 通过this调用同一类中重载的构造器
		this();
		System.out.println("Mid的带参数构造器，其参数值："
			+ msg);
	}
}
class Leaf extends Mid
{
	static{
		System.out.println("Leaf的静态初始化块");
	}
	{
		System.out.println("Leaf的普通初始化块");
	}
	public Leaf()
	{
		// 通过super调用父类中有一个字符串参数的构造器
		super("疯狂Java讲义");
		System.out.println("执行Leaf的构造器");
	}
}
public class Test
{
	public static void main(String[] args)
	{
		new Leaf();
		new Leaf();
	}
}

