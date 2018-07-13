

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
public class Apple extends Fruit
{
	public static void main(String[] args)
	{
		// 创建Apple对象
		Apple a = new Apple();
		// Apple对象本身没有weight成员变量
		// 因为Apple的父类有weight成员变量，也可以访问Apple对象的weight成员变量
		a.weight = 56;
		// 调用Apple对象的info()方法
		a.info();
	}
}
