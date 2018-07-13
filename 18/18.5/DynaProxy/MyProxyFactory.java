
import java.lang.reflect.*;
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
public class MyProxyFactory
{
	// 为指定target生成动态代理对象
	public static Object getProxy(Object target)
		throws Exception
		{
		// 创建一个MyInvokationHandler对象
		MyInvokationHandler handler =
		new MyInvokationHandler();
		// 为MyInvokationHandler设置target对象
		handler.setTarget(target);
		// 创建、并返回一个动态代理
		return Proxy.newProxyInstance(target.getClass().getClassLoader()
			, target.getClass().getInterfaces() , handler);
	}
}

