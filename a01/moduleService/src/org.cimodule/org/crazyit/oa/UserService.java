package org.crazyit.oa;

import java.util.ServiceLoader;
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
public interface UserService
{
	Integer addUser(String name);
	String getImplName();
	static UserService newInstance(){
		// 通过ServiceLoader加载所有服务实现者
		return ServiceLoader.load(UserService.class)
			// 返回第一个服务实现者
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(
				"找不到默认的服务实现着！"));
	}
	static UserService newInstance(String providerName){
		// 通过ServiceLoader加载所有服务实现者
		ServiceLoader<UserService> sl = ServiceLoader.load(UserService.class);
		// 遍历所有服务实现者
		for (UserService us : sl)
		{
			if (us.getImplName().equalsIgnoreCase(providerName))
			{
				return us;
			}
		}
		throw new IllegalArgumentException("无法找到名为'"
			+ providerName + "'的服务实现者！");
	}
}
