

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
@FunctionalInterface
public interface FunInterface
{
	static void foo()
	{
		System.out.println("foo类方法");
	}
	default void bar()
	{
		System.out.println("bar默认方法");
	}
	void test(); // 只定义一个抽象方法

	void abc();
}

