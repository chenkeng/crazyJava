
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
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
public class SimpleClipboard
{
	private Frame f = new Frame("简单的剪贴板程序");
	// 获取系统剪贴板
	private Clipboard clipboard = Toolkit
		.getDefaultToolkit().getSystemClipboard();
	// 下面是创建本地剪贴板的代码
	// Clipboard clipboard = new Clipboard("cb");   // ①
	// 用于复制文本的文本框
	private TextArea jtaCopyTo = new TextArea(5,20);
	// 用于粘贴文本的文本框
	private TextArea jtaPaste = new TextArea(5,20);
	private Button btCopy = new Button("复制"); // 复制按钮
	private Button btPaste = new Button("粘贴"); // 粘贴按钮
	public void init()
	{
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(event ->
		{
			// 将一个多行文本域里的字符串封装成StringSelection对象
			StringSelection contents = new
				StringSelection(jtaCopyTo.getText());
			// 将StringSelection对象放入剪贴板
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(event ->
		{
			// 如果剪贴板中包含stringFlavor内容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
			{
				try
				{
					// 取出剪贴板中stringFlavor内容
					String content = (String)clipboard
						.getData(DataFlavor.stringFlavor);
					jtaPaste.append(content);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		// 创建一个水平排列的Box容器
		Box box = new Box(BoxLayout.X_AXIS);
		// 将两个多行文本域放在Box容器中
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		// 将按钮所在Panel、Box容器添加到Frame窗口中
		f.add(p,BorderLayout.SOUTH);
		f.add(box,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleClipboard().init();
	}
}
