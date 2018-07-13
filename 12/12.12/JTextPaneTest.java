
import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;
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
public class JTextPaneTest
{
	JFrame mainWin = new JFrame("测试JTextPane");
	JTextPane txt = new JTextPane();
	StyledDocument doc = txt.getStyledDocument();
	// 定义三个SimpleAttributeSet对象
	SimpleAttributeSet android = new SimpleAttributeSet();
	SimpleAttributeSet java = new SimpleAttributeSet();
	SimpleAttributeSet javaee = new SimpleAttributeSet();
	public void init()
	{
		// 为android属性集设置颜色、字体大小、字体和下划线
		StyleConstants.setForeground(android, Color.RED);
		StyleConstants.setFontSize(android, 24);
		StyleConstants.setFontFamily(android, "Dialog");
		StyleConstants.setUnderline(android, true);
		// 为java属性集设置颜色、字体大小、字体和粗体字
		StyleConstants.setForeground(java, Color.BLUE);
		StyleConstants.setFontSize(java, 30);
		StyleConstants.setFontFamily(java, "Arial Black");
		StyleConstants.setBold(java, true);
		// 为javaee属性集设置颜色、字体大小、斜体字
		StyleConstants.setForeground(javaee, Color.GREEN);
		StyleConstants.setFontSize(javaee, 32);
		StyleConstants.setItalic(javaee, true);
		// 设置不允许编辑
		txt.setEditable(false);
		txt.setText("疯狂Android讲义\n"
			+ "疯狂Java讲义\n" + "轻量级Java EE企业应用实战\n");
		// 分别为文档中三段文字设置不同的外观样式
		doc.setCharacterAttributes(0 , 12 , android, true);
		doc.setCharacterAttributes(12 , 12 , java, true);
		doc.setCharacterAttributes(24 , 30 , javaee, true);
		mainWin.add(new JScrollPane(txt), BorderLayout.CENTER);
		// 获取屏幕尺寸
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int inset = 100;
		// 设置主窗口的大小
		mainWin.setBounds(inset, inset, screenSize.width - inset * 2
			, screenSize.height - inset * 2);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JTextPaneTest().init();
	}
}

