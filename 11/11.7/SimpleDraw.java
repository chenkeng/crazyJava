
import java.awt.*;
import java.awt.event.*;
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
public class SimpleDraw
{
	private final String RECT_SHAPE = "rect";
	private final String OVAL_SHAPE = "oval";
	private Frame f = new Frame("简单绘图");
	private Button rect = new Button("绘制矩形");
	private Button oval = new Button("绘制圆形");
	private MyCanvas drawArea = new MyCanvas();
	// 用于保存需要绘制什么图形的变量
	private String shape = "";
	public void init()
	{
		Panel p = new Panel();
		rect.addActionListener(e ->
		{
			// 设置shape变量为RECT_SHAPE
			shape = RECT_SHAPE;
			// 重画MyCanvas对象，即调用它的repaint()方法
			drawArea.repaint();
		});
		oval.addActionListener(e ->
		{
			// 设置shape变量为OVAL_SHAPE
			shape = OVAL_SHAPE;
			// 重画MyCanvas对象，即调用它的repaint()方法
			drawArea.repaint();
		});
		p.add(rect);
		p.add(oval);
		drawArea.setPreferredSize(new Dimension(250 , 180));
		f.add(drawArea);
		f.add(p , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleDraw().init();
	}
	class MyCanvas extends Canvas
	{
		// 重写Canvas的paint方法，实现绘画
		public void paint(Graphics g)
		{
			Random rand = new Random();
			if (shape.equals(RECT_SHAPE))
			{
				// 设置画笔颜色
				g.setColor(new Color(220, 100, 80));
				// 随机地绘制一个矩形框
				g.drawRect( rand.nextInt(200)
					, rand.nextInt(120) , 40 , 60);
			}
			if (shape.equals(OVAL_SHAPE))
			{
				// 设置画笔颜色
				g.setColor(new Color(80, 100, 200));
				// 随机地填充一个实心圆形
				g.fillOval( rand.nextInt(200)
					, rand.nextInt(120) , 50 , 40);
			}
		}
	}
}
