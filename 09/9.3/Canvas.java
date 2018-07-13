
import java.util.*;
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
public class Canvas
{
//	// 同时在画布上绘制多个形状
//	public void drawAll(List<Shape> shapes)
//	{
//		for (Shape s : shapes)
//		{
//			s.draw(this);
//		}
//	}

	// 同时在画布上绘制多个形状，使用被限制的泛型通配符
	public void drawAll(List<? extends Shape> shapes)
	{
		for (Shape s : shapes)
		{
			s.draw(this);
		}
	}

	public static void main(String[] args)
	{
		List<Circle> circleList = new ArrayList<Circle>();
		Canvas c = new Canvas();
		// 由于List<Circle>并不是List<Shape>的子类型,
		// 所以下面代码引发编译错误
		c.drawAll(circleList);
	}
}
