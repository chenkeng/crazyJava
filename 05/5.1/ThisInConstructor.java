

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
public class ThisInConstructor
{
	// 定义一个名为foo的成员变量
	public int foo;
	public ThisInConstructor()
	{
		// 在构造器里定义一个foo变量
		int foo = 0;
		// 使用this代表该构造器正在初始化的对象
		// 下面的代码将会把该构造器正在初始化的对象的foo成员变量设为6。
		this.foo = 6;
	}
	public static void main(String[] args)
	{
		// 所有使用ThisInConstructor创建的对象的foo成员变量
		// 都将被设为6，所以下面代码将输出6。
		System.out.println(new ThisInConstructor().foo);
	}
}
