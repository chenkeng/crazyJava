
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
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
public class HandDraw
{
	// 画图区的宽度
	private final int AREA_WIDTH = 500;
	// 画图区的高度
	private final int AREA_HEIGHT = 400;
	// 下面的preX、preY保存了上一次鼠标拖动事件的鼠标坐标
	private int preX = -1;
	private int preY = -1;
	// 定义一个右键菜单用于设置画笔颜色
	JPopupMenu pop = new JPopupMenu();
	JMenuItem chooseColor = new JMenuItem("选择颜色");
	// 定义一个BufferedImage对象
	BufferedImage image = new BufferedImage(AREA_WIDTH
		, AREA_HEIGHT , BufferedImage.TYPE_INT_RGB);
	// 获取image对象的Graphics
	Graphics g = image.getGraphics();
	private JFrame f = new JFrame("简单手绘程序");
	private DrawCanvas drawArea = new DrawCanvas();
	// 用于保存画笔颜色
	private Color foreColor = new Color(255, 0 ,0);
	public void init()
	{
		chooseColor.addActionListener(ae -> {
			// 下面代码直接弹出一个模式的颜色选择对话框，并返回用户选择的颜色
			// foreColor = JColorChooser.showDialog(f
			// 	, "选择画笔颜色" , foreColor);   // ①
			// 下面代码则弹出一个非模式的颜色选择对话框，
			// 并可以分别为“确定”按钮、“取消”按钮指定事件监听器
			final JColorChooser colorPane = new JColorChooser(foreColor);
			JDialog jd = JColorChooser.createDialog(f , "选择画笔颜色"
				, false, colorPane, e -> foreColor = colorPane.getColor(), null);
			jd.setVisible(true);
		});
		// 将菜单项组合成右键菜单
		pop.add(chooseColor);
		// 将右键菜单添加到drawArea对象中
		drawArea.setComponentPopupMenu(pop);
		// 将image对象的背景色填充成白色
		g.fillRect(0 , 0 ,AREA_WIDTH , AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH , AREA_HEIGHT));
		// 监听鼠标移动动作
		drawArea.addMouseMotionListener(new MouseMotionAdapter()
		{
			// 实现按下鼠标键并拖动的事件处理器
			public void mouseDragged(MouseEvent e)
			{
				// 如果preX和preY大于0
				if (preX > 0 && preY > 0)
				{
					// 设置当前颜色
					g.setColor(foreColor);
					// 绘制从上一次鼠标拖动事件点到本次鼠标拖动事件点的线段
					g.drawLine(preX , preY , e.getX() , e.getY());
				}
				// 将当前鼠标事件点的X、Y坐标保存起来
				preX = e.getX();
				preY = e.getY();
				// 重绘drawArea对象
				drawArea.repaint();
			}
		});
		// 监听鼠标事件
		drawArea.addMouseListener(new MouseAdapter()
		{
			// 实现鼠标松开的事件处理器
			public void mouseReleased(MouseEvent e)
			{
				// 松开鼠标键时，把上一次鼠标拖动事件的X、Y坐标设为-1。
				preX = -1;
				preY = -1;
			}
		});
		f.add(drawArea);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new HandDraw().init();
	}
	// 让画图区域继承JPanel类
	class DrawCanvas extends JPanel
	{
		// 重写JPanel的paint方法，实现绘画
		public void paint(Graphics g)
		{
			// 将image绘制到该组件上
			g.drawImage(image , 0 , 0 , null);
		}
	}
}