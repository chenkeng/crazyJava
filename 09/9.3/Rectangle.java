
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
// 定义Shape的子类Rectangle
public class Rectangle extends Shape
{
	// 实现画图方法，以打印字符串来模拟画图方法实现
	public void draw(Canvas c)
	{
		System.out.println("把一个矩形画在画布" + c + "上");
	}
}
