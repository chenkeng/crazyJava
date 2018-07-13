
import java.beans.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.geom.Point2D;
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
class FirstLayerUI extends LayerUI<JComponent>
{
	public void paint(Graphics g, JComponent c)
	{
		super.paint(g, c);
		Graphics2D g2 = (Graphics2D) g.create();
		// 设置透明效果
		g2.setComposite(AlphaComposite.getInstance(
			AlphaComposite.SRC_OVER, .5f));
		// 使用渐变画笔绘图
		g2.setPaint(new GradientPaint(0 , 0 , Color.RED
			, 0 , c.getHeight() , Color.BLUE));
		// 绘制一个与被装饰组件相同大小的矩形
		g2.fillRect(0, 0, c.getWidth(), c.getHeight());    // ①
		g2.dispose();
	}
}
class BlurLayerUI extends LayerUI<JComponent>
{
	private BufferedImage screenBlurImage;
	private BufferedImageOp operation;
	public BlurLayerUI()
	{
		float ninth = 1.0f / 9.0f;
		// 定义模糊参数
		float[] blurKernel = {
			ninth, ninth, ninth,
			ninth, ninth, ninth,
			ninth, ninth, ninth
		};
		// ConvolveOp代表一个模糊处理，它将原图片的每一个像素与周围
		// 像素的颜色进行混合，从而计算出当前像素的颜色值，
		operation = new ConvolveOp(
			new Kernel(3, 3, blurKernel),
			ConvolveOp.EDGE_NO_OP, null);
	}
	public void paint(Graphics g, JComponent c)
	{
		int w = c.getWidth();
		int h = c.getHeight();
		// 如果被装饰窗口大小为0X0,直接返回
		if (w == 0 || h == 0)
			return;
		// 如果screenBlurImage没有初始化，或它的尺寸不对。
		if (screenBlurImage == null
			|| screenBlurImage.getWidth() != w
			|| screenBlurImage.getHeight() != h)
		{
			// 重新创建新的BufferdImage
			screenBlurImage = new BufferedImage(w
				, h , BufferedImage.TYPE_INT_RGB);
		}
		Graphics2D ig2 = screenBlurImage.createGraphics();
		// 把被装饰组件的界面绘制到当前screenBlurImage上
		ig2.setClip(g.getClip());
		super.paint(ig2, c);
		ig2.dispose();
		Graphics2D g2 = (Graphics2D)g;
		// 对JLayer装饰的组件进行模糊处理
		g2.drawImage(screenBlurImage, operation, 0, 0);
	}
}
class SpotlightLayerUI extends LayerUI<JComponent>
{
	private boolean active;
	private int cx, cy;

	public void installUI(JComponent c)
	{
		super.installUI(c);
		JLayer layer = (JLayer)c;
		// 设置JLayer可以响应鼠标、鼠标动作事件
		layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK
			| AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}
	public void uninstallUI(JComponent c)
	{
		JLayer layer = (JLayer)c;
		// 设置JLayer不响应任何事件
		layer.setLayerEventMask(0);
		super.uninstallUI(c);
	}
	public void paint(Graphics g, JComponent c)
	{
		Graphics2D g2 = (Graphics2D)g.create();
		super.paint (g2, c);
		// 如果处于激活状态
		if (active)
		{
			// 定义一个cx、cy位置的点
			Point2D center = new Point2D.Float(cx, cy);
			float radius = 72;
			float[] dist = {0.0f, 1.0f};
			Color[] colors = {Color.YELLOW , Color.BLACK};
			// 以center为中心、colors为颜色数组创建环形渐变
			RadialGradientPaint p = new RadialGradientPaint(center
				, radius , dist , colors);
			g2.setPaint(p);
			// 设置渐变效果
			g2.setComposite(AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, .6f));
			// 绘制矩形
			g2.fillRect(0, 0, c.getWidth(), c.getHeight());
		}
		g2.dispose();
	}

	// 处理鼠标事件的方法
	public void processMouseEvent(MouseEvent e, JLayer layer)
	{
		if (e.getID() == MouseEvent.MOUSE_ENTERED)
			active = true;
		if (e.getID() == MouseEvent.MOUSE_EXITED)
			active = false;
		layer.repaint();
	}
	// 处理鼠标动作事件的方法
	public void processMouseMotionEvent(MouseEvent e, JLayer layer)
	{
		Point p = SwingUtilities.convertPoint(
			e.getComponent(), e.getPoint(), layer);
		// 获取鼠标动作事件的发生点的坐标
		cx = p.x;
		cy = p.y;
		layer.repaint();
	}
}
public class JLayerTest
{
	public void init()
	{
		JFrame f = new JFrame("JLayer测试");
		JPanel p = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JRadioButton radioButton;
		// 创建3个RadioButton，并将它们添加成一组
		p.add(radioButton = new JRadioButton("网购购买", true));
		group.add(radioButton);
		p.add(radioButton = new JRadioButton("书店购买"));
		group.add(radioButton);
		p.add(radioButton = new JRadioButton("图书馆借阅"));
		group.add(radioButton);
		// 添加3个JCheckBox
		p.add(new JCheckBox("疯狂Java讲义"));
		p.add(new JCheckBox("疯狂Android讲义"));
		p.add(new JCheckBox("疯狂Ajax讲义"));
		p.add(new JCheckBox("轻量级Java EE企业应用"));
		JButton orderButton = new JButton("投票");
		p.add(orderButton);
		// 创建LayerUI对象
		LayerUI<JComponent> layerUI = new SpotlightLayerUI();     // ②
		// 使用layerUI来装饰指定的JPanel组件
		JLayer<JComponent> layer = new JLayer<JComponent>(p, layerUI);
		// 将装饰后的JPanel组件添加到容器中
		f.add(layer);
		f.setSize(300, 170);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		f.setVisible (true);
	}
	public static void main(String[] args)
	{
		new JLayerTest().init();
	}
}