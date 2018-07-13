

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
public class Apple<T extends Number>
{
	T col;
	public static void main(String[] args)
	{
		Apple<Integer> ai = new Apple<>();
		Apple<Double> ad = new Apple<>();
		// 下面代码将引起编译异常，下面代码试图把String类型传给T形参
		// 但String不是Number的子类型，所以引发编译错误
//		Apple<String> as = new Apple<>();		// ①
	}
}
