

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
public class Cow
{
	private double weight;
	// 外部类的两个重载的构造器
	public Cow(){}
	public Cow(double weight)
	{
		this.weight = weight;
	}
	// 定义一个非静态内部类
	private class CowLeg
	{
		// 非静态内部类的两个实例变量
		private double length;
		private String color;
		// 非静态内部类的两个重载的构造器
		public CowLeg(){}
		public CowLeg(double length , String color)
		{
			this.length = length;
			this.color = color;
		}
		// 下面省略length、color的setter和getter方法
		public void setLength(double length)
		{
			this.length = length;
		}
		public double getLength()
		{
			return this.length;
		}
		public void setColor(String color)
		{
			this.color = color;
		}
		public String getColor()
		{
			return this.color;
		}
		// 非静态内部类的实例方法
		public void info()
		{
			System.out.println("当前牛腿颜色是："
				+ color + ", 高：" + length);
			// 直接访问外部类的private修饰的成员变量
			System.out.println("本牛腿所在奶牛重：" + weight);   //①
		}
	}
	public void test()
	{
		CowLeg cl = new CowLeg(1.12 , "黑白相间");
		cl.info();
	}
	public static void main(String[] args)
	{
		Cow cow = new Cow(378.9);
		cow.test();
	}
}
