
import javax.swing.*;
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
interface Converter{
	Integer convert(String from);
}
@FunctionalInterface
interface MyTest
{
	String test(String a , int b , int c);
}
@FunctionalInterface
interface YourTest
{
	JFrame win(String title);
}
public class MethodRefer
{
	public static void main(String[] args)
	{
		// 下面代码使用Lambda表达式创建Converter对象
//		Converter converter1 = from -> Integer.valueOf(from);
//		// 方法引用代替Lambda表达式：引用类方法。
//		// 函数式接口中被实现方法的全部参数传给该类方法作为参数。
//		Converter converter1 = Integer::valueOf;
//		Integer val = converter1.convert("99");
//		System.out.println(val); // 输出整数99



		// 下面代码使用Lambda表达式创建Converter对象
//		Converter converter2 = from -> "fkit.org".indexOf(from);
//		// 方法引用代替Lambda表达式：引用特定对象的实例方法。
//		// 函数式接口中被实现方法的全部参数传给该方法作为参数。
//		Converter converter2 = "fkit.org"::indexOf;
//		Integer value = converter2.convert("it");
//		System.out.println(value); // 输出2



		// 下面代码使用Lambda表达式创建MyTest对象
//		MyTest mt = (a , b , c) -> a.substring(b , c);
		// 方法引用代替Lambda表达式：引用某类对象的实例方法。
		// 函数式接口中被实现方法的第一个参数作为调用者，
		// 后面的参数全部传给该方法作为参数。
//		MyTest mt = String::substring;
//		String str = mt.test("Java I Love you" , 2 , 9);
//		System.out.println(str); // 输出:va I Lo



		// 下面代码使用Lambda表达式创建YourTest对象
//		YourTest yt = (String a) -> new JFrame(a);
		// 构造器引用代替Lambda表达式。
		// 函数式接口中被实现方法的全部参数传给该构造器作为参数。
		YourTest yt = JFrame::new;
		JFrame jf = yt.win("我的窗口");
		System.out.println(jf);
	}
}
