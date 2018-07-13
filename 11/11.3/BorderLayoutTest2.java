
import java.awt.*;
import static java.awt.BorderLayout.*;
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
public class BorderLayoutTest2
{
	public static void main(String[] args)
	{
		Frame f = new Frame("测试窗口");
		// 设置Frame容器使用BorderLayout布局管理器
		f.setLayout(new BorderLayout(30, 5));
		f.add(new Button("南") , SOUTH);
		f.add(new Button("北") , NORTH);
		// 创建一个Panel对象
		Panel p = new Panel();
		// 向Panel对象中添加两个组件
		p.add(new TextField(20));
		p.add(new Button("单击我"));
		// 默认添加到中间，向中间添加一个Panel容器
		f.add(p);
		f.add(new Button("东") , EAST);
		// 设置窗口为最佳大小
		f.pack();
		// 将窗口显示出来（Frame对象默认处于隐藏状态）
		f.setVisible(true);
	}
}
