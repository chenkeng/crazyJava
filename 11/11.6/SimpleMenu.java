
import java.awt.*;
import java.awt.event.*;
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
public class SimpleMenu
{
	private Frame f = new Frame("测试");
	private MenuBar mb = new MenuBar();
	Menu file = new Menu("文件");
	Menu edit = new Menu("编辑");
	MenuItem newItem = new MenuItem("新建");
	MenuItem saveItem = new MenuItem("保存");
	// 创建exitItem菜单项，指定使用 Ctrl+X 快捷键
	MenuItem exitItem = new MenuItem("退出"
		, new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");
	Menu format = new Menu("格式");
	// 创建commentItem菜单项，指定使用 Ctrl+Shift+/ 快捷键
	MenuItem commentItem = new MenuItem("注释" ,
		new MenuShortcut(KeyEvent.VK_SLASH , true));
	MenuItem cancelItem = new MenuItem("取消注释");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 以Lambda表达式创建菜单事件监听器
		ActionListener menuListener = e ->
		{
			String cmd = e.getActionCommand();
			ta.append("单击“" + cmd + "”菜单" + "\n");
			if (cmd.equals("退出"))
			{
				System.exit(0);
			}
		};
		// 为commentItem菜单项添加事件监听器
		commentItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		// 为file菜单添加菜单项
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		// 为edit菜单添加菜单项
		edit.add(autoWrap);
		// 使用addSeparator方法来添加菜单分隔线
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		// 为format菜单添加菜单项
		format.add(commentItem);
		format.add(cancelItem);
		// 使用添加new MenuItem("-")的方式添加菜单分隔线
		edit.add(new MenuItem("-"));
		// 将format菜单组合到edit菜单中，从而形成二级菜单
		edit.add(format);
		// 将file、edit菜单添加到mb菜单条中
		mb.add(file);
		mb.add(edit);
		// 为f窗口设置菜单条
		f.setMenuBar(mb);
		// 以匿名内部类的形式来创建事件监听器对象
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleMenu().init();
	}
}
