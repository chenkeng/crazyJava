

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
public class StaticTest
{
	// 定义一个非静态的内部类，是一个空类
	private class In{}
	// 外部类的静态方法
	public static void main(String[] args)
	{
		// 下面代码引发编译异常，因为静态成员（main()方法）
		// 无法访问非静态成员（In类）
		new In();
	}
}
