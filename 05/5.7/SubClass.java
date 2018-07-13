

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
class BaseClass
{
	public int book = 6;
	public void base()
	{
		System.out.println("父类的普通方法");
	}
	public void test()
	{
		System.out.println("父类的被覆盖的方法");
	}
}
public class SubClass extends BaseClass
{
	//重新定义一个book实例变量隐藏父类的book实例变量
	public String book = "轻量级Java EE企业应用实战";
	public void test()
	{
		System.out.println("子类的覆盖父类的方法");
	}
	public void sub()
	{
		System.out.println("子类的普通方法");
	}
	public static void main(String[] args)
	{
		// 下面编译时类型和运行时类型完全一样，因此不存在多态
		BaseClass bc = new BaseClass();
		// 输出 6
		System.out.println(bc.book);
		// 下面两次调用将执行BaseClass的方法
		bc.base();
		bc.test();
		// 下面编译时类型和运行时类型完全一样，因此不存在多态
		SubClass sc = new SubClass();
		// 输出"轻量级Java EE企业应用实战"
		System.out.println(sc.book);
		// 下面调用将执行从父类继承到的base()方法
		sc.base();
		// 下面调用将执行从当前类的test()方法
		sc.test();
		// 下面编译时类型和运行时类型不一样，多态发生
		BaseClass ploymophicBc = new SubClass();
		// 输出6 —— 表明访问的是父类对象的实例变量
		System.out.println(ploymophicBc.book);
		// 下面调用将执行从父类继承到的base()方法
		ploymophicBc.base();
		// 下面调用将执行从当前类的test()方法
		ploymophicBc.test();
		// 因为ploymophicBc的编译类型是BaseClass，
		// BaseClass类没有提供sub方法,所以下面代码编译时会出现错误。
		// ploymophicBc.sub();
	}
}
