

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
public class Apple
{
	public String name;
	public String color;
	public double weight;
	public Apple(){}
	// 两个参数的构造器
	public Apple(String name , String color)
	{
		this.name = name;
		this.color = color;
	}
	// 三个参数的构造器
	public Apple(String name , String color , double weight)
	{
		// 通过this调用另一个重载的构造器的初始化代码
		this(name , color);
		// 下面this引用该构造器正在初始化的Java对象
		this.weight = weight;
	}
}
