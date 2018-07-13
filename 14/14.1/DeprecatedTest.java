

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
class Apple
{
	// 定义info方法已过时
	// since属性指定从哪个版本开始，forRemoval指定该API将来会被删除
	@Deprecated(since="9", forRemoval=true)
	public void info()
	{
		System.out.println("Apple的info方法");
	}
}
public class DeprecatedTest
{
	public static void main(String[] args)
	{
		// 下面使用info方法时将会被编译器警告
		new Apple().info();
	}
}

