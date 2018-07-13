
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
// GUI界面类继承WindowAdapter作为事件监听器类
public class SimpleEventHandler extends WindowAdapter
{
	private Frame f = new Frame("测试");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 将该类的默认对象作为事件监听器对象
		f.addWindowListener(this);
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	// GUI界面类直接包含事件处理器方法
	public void windowClosing(WindowEvent e)
	{
		System.out.println("用户关闭窗口！\n");
		System.exit(0);
	}
	public static void main(String[] args)
	{
		new SimpleEventHandler().init();
	}
}
