

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
public enum Gender implements GenderDesc
{
	// 此处的枚举值必须调用对应构造器来创建
	MALE("男")
	// 花括号部分实际上是一个类体部分
	{
		public void info()
		{
			System.out.println("这个枚举值代表男性");
		}
	},
	FEMALE("女")
	{
		public void info()
		{
			System.out.println("这个枚举值代表女性");
		}
	};
	// 其他部分与codes\06\6.9\best\Gender.java中的Gender类完全相同
	private final String name;
	// 枚举类的构造器只能使用private修饰
	private Gender(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	// 增加下面的info()方法，实现GenderDesc接口必须实现的方法
	public void info()
	{
		System.out.println(
			"这是一个用于用于定义性别的枚举类");
	}
}
