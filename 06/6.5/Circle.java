

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
public class Circle extends Shape
{
	private double radius;
	public Circle(String color , double radius)
	{
		super(color);
		this.radius = radius;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	// 重写Shape类的的计算周长的抽象方法
	public double calPerimeter()
	{
		return 2 * Math.PI * radius;
	}
	// 重写Shape类的的返回形状的抽象方法
	public String getType()
	{
		return getColor() + "圆形";
	}
	public static void main(String[] args)
	{
		Shape s1 = new Triangle("黑色" , 3 , 4, 5);
		Shape s2 = new Circle("黄色" , 3);
		System.out.println(s1.getType());
		System.out.println(s1.calPerimeter());
		System.out.println(s2.getType());
		System.out.println(s2.calPerimeter());
	}
}
