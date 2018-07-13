
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
public class AnonymousEventHandler
{
	private Frame f = new Frame("测试");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 以匿名内部类的形式来创建事件监听器对象
		f.addWindowListener(new WindowAdapter()
		{
			// 实现事件处理方法
			public void windowClosing(WindowEvent e)
			{
				System.out.println("用户试图关闭窗口！\n");
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new AnonymousEventHandler().init();
	}
}
