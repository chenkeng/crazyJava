
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
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
public class JToolBarTest
{
	JFrame jf = new JFrame("测试工具条");
	JTextArea jta = new JTextArea(6, 35);
	JToolBar jtb = new JToolBar();
	JMenuBar jmb = new JMenuBar();
	JMenu edit = new JMenu("编辑");
	// 获取系统剪贴板
	Clipboard clipboard = Toolkit.getDefaultToolkit()
		.getSystemClipboard();
	// 创建"粘贴"Action，该Action用于创建菜单项、工具按钮和普通按钮
	Action pasteAction = new AbstractAction("粘贴"
		, new ImageIcon("ico/paste.png"))
	{
		public void actionPerformed(ActionEvent e)
		{
			// 如果剪贴板中包含stringFlavor内容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
			{
				try
				{
					// 取出剪贴板中stringFlavor内容
					String content = (String)clipboard.getData
					(DataFlavor.stringFlavor);
					// 将选中内容替换成剪贴板中的内容
					jta.replaceRange(content , jta.getSelectionStart()
						, jta.getSelectionEnd());
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
			}
		}
	};
	// 创建"复制"Action
	Action copyAction = new AbstractAction("复制"
		, new ImageIcon("ico/copy.png"))
	{
		public void actionPerformed(ActionEvent e)
		{
			StringSelection contents = new StringSelection(
				jta.getSelectedText());
			// 将StringSelection对象放入剪贴板
			clipboard.setContents(contents, null);
			// 如果剪贴板中包含stringFlavor内容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
			{
				// 将pasteAction激活
				pasteAction.setEnabled(true);
			}
		}
	};
	public void init()
	{
		// pasteAction默认处于不激活状态
		pasteAction.setEnabled(false);   // ①
		jf.add(new JScrollPane(jta));
		// 以Action创建按钮，并将该按钮添加到Panel中
		JButton copyBn = new JButton(copyAction);
		JButton pasteBn = new JButton(pasteAction);
		JPanel jp = new JPanel();
		jp.add(copyBn);
		jp.add(pasteBn);
		jf.add(jp , BorderLayout.SOUTH);
		// 向工具条中添加Action对象，该对象将会转换成工具按钮
		jtb.add(copyAction);
		jtb.addSeparator();
		jtb.add(pasteAction);
		// 向菜单中添加Action对象，该对象将会转换成菜单项
		edit.add(copyAction);
		edit.add(pasteAction);
		// 将edit菜单添加到菜单条中
		jmb.add(edit);
		jf.setJMenuBar(jmb);
		// 设置工具条和工具按钮之间的页边距。
		jtb.setMargin(new Insets(20 ,10 , 5 , 30));    // ②
		// 向窗口中添加工具条
		jf.add(jtb , BorderLayout.NORTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JToolBarTest().init();
	}
}
