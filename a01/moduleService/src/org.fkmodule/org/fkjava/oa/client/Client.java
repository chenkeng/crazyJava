package org.fkjava.oa.client;

import org.crazyit.oa.UserService;
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
public class Client
{
	public static void main(String[] args)
	{
		// 使用默认的服务提供者，具体使用哪个不确定
		UserService us1 = UserService.newInstance();
		System.out.println(us1.addUser("yeeku"));
		// 获取"basic user service"服务实现者
		UserService us2 = UserService.newInstance("basic user service");
		System.out.println(us2.addUser("yeeku"));
		// 获取"senior user service"服务实现者
		UserService us3 = UserService.newInstance("senior user service");
		System.out.println(us3.addUser("yeeku"));
		// 获取"best user service"服务实现者
		UserService us4 = UserService.newInstance("best user service");
		System.out.println(us4.addUser("yeeku"));
	}
}
