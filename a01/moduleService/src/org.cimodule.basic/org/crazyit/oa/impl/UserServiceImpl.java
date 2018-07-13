package org.crazyit.oa.impl;

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
public class UserServiceImpl implements UserService
{
	static final String IMPL_NAME = "basic user service";
	public Integer addUser(String name)
	{
		System.out.println("普通的UserService实现添加用户：" + name);
		return 19;
	}
	@Override
	public String getImplName()
	{
		return IMPL_NAME;
	}
}
