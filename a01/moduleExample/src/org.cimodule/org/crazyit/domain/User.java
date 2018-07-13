package org.crazyit.domain;
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
public class User
{
	public String sayHi(String name)
	{
		System.out.println("--执行User的sayHi方法--");
		return name + "您好！" + new java.util.Date();
	}
}
