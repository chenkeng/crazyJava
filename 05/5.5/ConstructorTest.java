

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
public class ConstructorTest
{
	public String name;
	public int count;
	// 提供自定义的构造器，该构造器包含两个参数
	public ConstructorTest(String name , int count)
	{
		// 构造器里的this代表它进行初始化的对象
		// 下面两行代码将传入的2个参数赋给this代表对象的name和count实例变量
		this.name = name;
		this.count = count;
	}
	public static void main(String[] args)
	{
		// 使用自定义的构造器来创建对象
		// 系统将会对该对象执行自定义的初始化
		ConstructorTest tc = new ConstructorTest("疯狂Java讲义" , 90000);
		// 输出ConstructorTest对象的name和count两个实例变量
		System.out.println(tc.name);
		System.out.println(tc.count);
	}
}

