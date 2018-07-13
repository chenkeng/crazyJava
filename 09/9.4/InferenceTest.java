

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
class MyUtil<E>
{
	public static <Z> MyUtil<Z> nil()
	{
		return null;
	}
	public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail)
	{
		return null;
	}
	E head()
	{
		return null;
	}
}
public class InferenceTest
{
	public static void main(String[] args)
	{
		// 可以通过方法赋值的目标参数来推断类型参数为String
		MyUtil<String> ls = MyUtil.nil();
		// 无需使用下面语句在调用nil()方法时指定类型参数的类型
		MyUtil<String> mu = MyUtil.<String>nil();
		// 可调用cons方法所需的参数类型来推断类型参数为Integer
		MyUtil.cons(42, MyUtil.nil());
		// 无需使用下面语句在调用nil()方法时指定类型参数的类型
		MyUtil.cons(42, MyUtil.<Integer>nil());

		// 希望系统能推断出调用nil()方法类型参数为String类型，
		// 但实际上Java 8依然推断不出来，所以下面代码报错
//		String s = MyUtil.nil().head();
		String s = MyUtil.<String>nil().head();
	}
}