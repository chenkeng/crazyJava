
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
public class WindowListenerTest
{
	private Frame f = new Frame("测试");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 为窗口添加窗口事件监听器
		f.addWindowListener(new MyListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	// 实现一个窗口监听器类
	class MyListener implements WindowListener
	{
		public void windowActivated(WindowEvent e)
		{
			ta.append("窗口被激活！\n");
		}
		public void windowClosed(WindowEvent e)
		{
			ta.append("窗口被成功关闭！\n");
		}
		public void windowClosing(WindowEvent e)
		{
			ta.append("用户关闭窗口！\n");
			System.exit(0);
		}
		public void windowDeactivated(WindowEvent e)
		{
			ta.append("窗口失去焦点！\n");
		}
		public void windowDeiconified(WindowEvent e)
		{
			ta.append("窗口被恢复！\n");
		}
		public void windowIconified(WindowEvent e)
		{
			ta.append("窗口被最小化！\n");
		}
		public void windowOpened(WindowEvent e)
		{
			ta.append("窗口初次被打开！\n");
		}
	}
	public static void main(String[] args)
	{
		new WindowListenerTest().init();
	}
}
