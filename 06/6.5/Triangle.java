

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
public class Triangle extends Shape
{
	// 定义三角形的三边
	private double a;
	private double b;
	private double c;
	public Triangle(String color , double a
		, double b , double c)
	{
		super(color);
		this.setSides(a , b , c);
	}
	public void setSides(double a , double b , double c)
	{
		if (a >= b + c || b >= a + c || c >= a + b)
		{
			System.out.println("三角形两边之和必须大于第三边");
			return;
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}
	// 重写Shape类的的计算周长的抽象方法
	public double calPerimeter()
	{
		return a + b + c;
	}
	// 重写Shape类的的返回形状的抽象方法
	public String getType()
	{
		return "三角形";
	}
}
