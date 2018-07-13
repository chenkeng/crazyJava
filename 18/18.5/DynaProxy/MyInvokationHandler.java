
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
public class MyInvokationHandler implements InvocationHandler
{
	// 需要被代理的对象
	private Object target;
	public void setTarget(Object target)
	{
		this.target = target;
	}
	// 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Exception
	{
		DogUtil du = new DogUtil();
		// 执行DogUtil对象中的method1。
		du.method1();
		// 以target作为主调来执行method方法
		Object result = method.invoke(target , args);
		// 执行DogUtil对象中的method2。
		du.method2();
		return result;
	}
}

