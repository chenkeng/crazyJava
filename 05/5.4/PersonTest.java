

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
public class PersonTest
{
	public static void main(String[] args)
	{
		Person p = new Person();
		// 因为age成员变量已被隐藏，所以下面语句将出现编译错误。
//		p.age = 1000;
		// 下面语句编译不会出现错误，但运行时将提示"您设置的年龄不合法"
		// 程序不会修改p的age成员变量
		p.setAge(1000);
		// 访问p的age成员变量也必须通过其对应的getter方法
		// 因为上面从未成功设置p的age成员变量，故此处输出0
		System.out.println("未能设置age成员变量时："
			+ p.getAge());
		// 成功修改p的age成员变量
		p.setAge(30);
		// 因为上面成功设置了p的age成员变量，故此处输出30
		System.out.println("成功设置age成员变量后："
			+ p.getAge());
		// 不能直接操作p的name成员变量，只能通过其对应的setter方法
		// 因为"李刚"字符串长度满足2~6,所以可以成功设置
		p.setName("李刚");
		System.out.println("成功设置name成员变量后："
			+ p.getName());
	}
}
