

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
class Base
{
	public double size;
	public String name;
	public Base(double size , String name)
	{
		this.size = size;
		this.name = name;
	}
}
public class Sub extends Base
{
	public String color;
	public Sub(double size , String name , String color)
	{
		// 通过super调用来调用父类构造器的初始化过程
		super(size , name);
		this.color = color;
	}
	public static void main(String[] args)
	{
		Sub s = new Sub(5.6 , "测试对象" , "红色");
		// 输出Sub对象的三个实例变量
		System.out.println(s.size + "--" + s.name
			+ "--" + s.color);
	}
}
