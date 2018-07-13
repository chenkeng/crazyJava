
import java.awt.*;
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
public class BoxLayoutTest
{
	private Frame f = new Frame("测试");
	public void init()
	{
		f.setLayout(new BoxLayout(f , BoxLayout.Y_AXIS));
		// 下面按钮将会垂直排列
		f.add(new Button("第一个按钮"));
		f.add(new Button("按钮二"));
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BoxLayoutTest().init();
	}
}
