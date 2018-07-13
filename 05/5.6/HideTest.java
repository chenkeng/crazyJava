

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
class Parent
{
	public String tag = "疯狂Java讲义";         //①
}
class Derived extends Parent
{
	// 定义一个私有的tag实例变量来隐藏父类的tag实例变量
	private String tag = "轻量级Java EE企业应用实战";         //②
}
public class HideTest
{
	public static void main(String[] args)
	{
		Derived d = new Derived();
		// 程序不可访问d的私有变量tag，所以下面语句将引起编译错误
		// System.out.println(d.tag);         //③
		// 将d变量显式地向上转型为Parent后，即可访问tag实例变量
		// 程序将输出：“疯狂Java讲义”
		System.out.println(((Parent)d).tag);         //④
	}
}
