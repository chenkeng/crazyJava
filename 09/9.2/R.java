

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
public class R<T>
{
	// 下面代码错误，不能在静态变量声明中使用泛型形参
//	static T info;
	T age;
	public void foo(T msg){}
	// 下面代码错误，不能在静态方法声明中使用泛型形参
//	public static void bar(T msg){}

}

