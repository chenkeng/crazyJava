

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
public class DiscernVariable
{
	private String prop = "外部类的实例变量";
	private class InClass
	{
		private String prop = "内部类的实例变量";
		public void info()
		{
			String prop = "局部变量";
			// 通过 外部类类名.this.varName 访问外部类实例变量
			System.out.println("外部类的实例变量值："
				+ DiscernVariable.this.prop);
			// 通过 this.varName 访问内部类实例的变量
			System.out.println("内部类的实例变量值：" + this.prop);
			// 直接访问局部变量
			System.out.println("局部变量的值：" + prop);
		}
	}
	public void test()
	{
		InClass in = new InClass();
		in.info();
	}
	public static void main(String[] args)
	{
		new DiscernVariable().test();
	}
}
