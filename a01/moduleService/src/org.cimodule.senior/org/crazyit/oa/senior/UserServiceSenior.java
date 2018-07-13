package org.crazyit.oa.senior;

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
public class UserServiceSenior implements UserService
{
	static final String IMPL_NAME = "senior user service";
	// 构造器私有
	private UserServiceSenior(){}
	// 通过static的、无参数的provider方法来返回服务实现者对象
	public static UserService provider()
	{
		return new UserServiceSenior();
	}
	public Integer addUser(String name)
	{
		System.out.println("===高级的UserService实现添加用户：" + name);
		return 29;
	}
	@Override
	public String getImplName()
	{
		return IMPL_NAME;
	}
}
