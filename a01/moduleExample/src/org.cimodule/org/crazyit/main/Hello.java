package org.crazyit.main;

import org.crazyit.domain.*;
/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0
 */
public class Hello
{
	public void info()
	{
		System.out.println("Hello的info方法");
	}
	public static void main(String[] args)
	{
		//  获取Hello类
		Class<Hello> cls = Hello.class;
		// 获取Hello类所在的模块
        Module mod = cls.getModule();
		// 输出模块名
        System.out.println(mod.getName());
		new Hello().info();
		// 创建User对象的实例，并调用它的方法
		System.out.println(new User().sayHi("孙悟空"));
	}
}
