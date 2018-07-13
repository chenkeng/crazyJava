package org.fkjava.main;

import org.crazyit.user.User;
import java.lang.reflect.*;

import java.sql.*;
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
public class Main
{
	public static void main(String[] args)throws Exception
	{
		// org.crazyit.shop包中类只是声明为“导出（exports）”，
		// 因此可以自由访问User类
		User user = new User();
		System.out.println(user.addUser("yeeku"));
		// org.crazyit.shop包中类只是声明为“开放（opens）”，
		// 因此只能通过反射访问该包中的Item类
		Class<?> clazz = Class.forName("org.crazyit.shop.Item");
		Object im = clazz.getConstructor().newInstance();
		Method mtd = clazz.getMethod("showInfo");
		mtd.invoke(im);
	}
}
