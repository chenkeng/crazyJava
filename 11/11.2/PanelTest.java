
import java.awt.*;
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
public class PanelTest
{
	public static void main(String[] args)
	{
		Frame f = new Frame("测试窗口");
		// 创建一个Panel容器
		Panel p = new Panel();
		// 向Panel容器中添加两个组件
		p.add(new TextField(20));
		p.add(new Button("单击我"));
		// 将Panel容器添加到Frame窗口中
		f.add(p);
		// 设置窗口的大小、位置
		f.setBounds(30, 30 , 250, 120);
		// 将窗口显示出来（Frame对象默认处于隐藏状态）
		f.setVisible(true);
	}
}
