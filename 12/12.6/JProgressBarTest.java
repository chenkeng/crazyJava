
import java.awt.*;
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
public class JProgressBarTest
{
	JFrame frame = new JFrame("测试进度条");
	// 创建一条垂直进度条
	JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL );
	JCheckBox indeterminate = new JCheckBox("不确定进度");
	JCheckBox noBorder = new JCheckBox("不绘制边框");
	public void init()
	{
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(indeterminate);
		box.add(noBorder);
		frame.setLayout(new FlowLayout());
		frame.add(box);
		// 把进度条添加到JFrame窗口中
		frame.add(bar);
		// 设置进度条的最大值和最小值
		bar.setMinimum(0);
		bar.setMaximum(100);
		// 设置在进度条中绘制完成百分比
		bar.setStringPainted(true);
		// 根据该选择框决定是否绘制进度条的边框
		noBorder.addActionListener(event ->
			bar.setBorderPainted(!noBorder.isSelected()));
		indeterminate.addActionListener(event -> {
			// 设置该进度条的进度是否确定
			bar.setIndeterminate(indeterminate.isSelected());
			bar.setStringPainted(!indeterminate.isSelected());
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// 采用循环方式来不断改变进度条的完成进度
		for (int i = 0 ; i <= 100 ; i++)
		{
			// 改变进度条的完成进度
			bar.setValue(i);
			try
			{
				// 程序暂停0.1秒
				Thread.sleep(100);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
	{
		new JProgressBarTest().init();
	}
}

