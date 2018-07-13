
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Dictionary;
import java.util.Hashtable;
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
public class JSliderTest
{
	JFrame mainWin = new JFrame("滑动条示范");
	Box sliderBox = new Box(BoxLayout.Y_AXIS);
	JTextField showVal = new JTextField();
	ChangeListener listener;
	public void init()
	{
		// 定义一个监听器，用于监听所有滑动条
		listener = event -> {
			// 取出滑动条的值，并在文本中显示出来
			JSlider source = (JSlider) event.getSource();
			showVal.setText("当前滑动条的值为："
				+ source.getValue());
		};
		// -----------添加一个普通滑动条-----------
		JSlider slider = new JSlider();
		addSlider(slider, "普通滑动条");
		// -----------添加保留区为30的滑动条-----------
		slider = new JSlider();
		slider.setExtent(30);
		addSlider(slider, "保留区为30");
		// ---添加带主、次刻度的滑动条,并设置其最大值，最小值---
		slider = new JSlider(30 , 200);
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "有刻度");
		// -----------添加滑块必须停在刻度处滑动条-----------
		slider = new JSlider();
		// 设置滑块必须停在刻度处
		slider.setSnapToTicks(true);
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "滑块停在刻度处");
		// -----------添加没有滑轨的滑动条-----------
		slider = new JSlider();
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 设置不绘制滑轨
		slider.setPaintTrack(false);
		addSlider(slider, "无滑轨");
		// -----------添加方向反转的滑动条-----------
		slider = new JSlider();
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 设置方向反转
		slider.setInverted(true);
		addSlider(slider, "方向反转");
		// --------添加绘制默认刻度标签的滑动条--------
		slider = new JSlider();
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 设置绘制刻度标签，默认绘制数值刻度标签
		slider.setPaintLabels(true);
		addSlider(slider, "数值刻度标签");
		// ------添加绘制Label类型的刻度标签的滑动条------
		slider = new JSlider();
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 设置绘制刻度标签
		slider.setPaintLabels(true);
		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		// 指定刻度标签，标签是JLabel
		slider.setLabelTable(labelTable);
		addSlider(slider, "JLable标签");
		// ------添加绘制Label类型的刻度标签的滑动条------
		slider = new JSlider();
		// 设置绘制刻度
		slider.setPaintTicks(true);
		// 设置主、次刻度的间距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 设置绘制刻度标签
		slider.setPaintLabels(true);
		labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0, new JLabel(new ImageIcon("ico/0.GIF")));
		labelTable.put(20, new JLabel(new ImageIcon("ico/2.GIF")));
		labelTable.put(40, new JLabel(new ImageIcon("ico/4.GIF")));
		labelTable.put(60, new JLabel(new ImageIcon("ico/6.GIF")));
		labelTable.put(80, new JLabel(new ImageIcon("ico/8.GIF")));
		// 指定刻度标签，标签是ImageIcon
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon标签");
		mainWin.add(sliderBox, BorderLayout.CENTER);
		mainWin.add(showVal, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	// 定义一个方法，用于将滑动条添加到容器中
	public void addSlider(JSlider slider, String description)
	{
		slider.addChangeListener(listener);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JLabel(description + "："));
		box.add(slider);
		sliderBox.add(box);
	}
	public static void main(String[] args)
	{
		new JSliderTest().init();
	}
}

