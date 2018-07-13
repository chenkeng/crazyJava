

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
public class InstanceofTest
{
	public static void main(String[] args)
	{
		// 声明hello时使用Object类，则hello的编译类型是Object，
		// Object是所有类的父类, 但hello变量的实际类型是String
		Object hello = "Hello";
		// String与Object类存在继承关系，可以进行instanceof运算。返回true。
		System.out.println("字符串是否是Object类的实例："
			+ (hello instanceof Object));
		System.out.println("字符串是否是String类的实例："
			+ (hello instanceof String)); // 返回true。
		// Math与Object类存在继承关系，可以进行instanceof运算。返回false。
		System.out.println("字符串是否是Math类的实例："
			+ (hello instanceof Math));
		// String实现了Comparable接口，所以返回true。
		System.out.println("字符串是否是Comparable接口的实例："
			+ (hello instanceof Comparable));
		String a = "Hello";
//		// String类与Math类没有继承关系，所以下面代码编译无法通过
//		System.out.println("字符串是否是Math类的实例："
//			+ (a instanceof Math));
	}
}
