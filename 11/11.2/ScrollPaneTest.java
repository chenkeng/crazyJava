
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
public class ScrollPaneTest
{
	public static void main(String[] args)
	{
		Frame f = new Frame("测试窗口");
		// 创建一个ScrollPane容器，指定总是具有滚动条
		ScrollPane sp = new ScrollPane(
			ScrollPane.SCROLLBARS_ALWAYS);
		// 向ScrollPane容器中添加两个组件
		sp.add(new TextField(20));
		sp.add(new Button("单击我"));
		// 将ScrollPane容器添加到Frame对象中
		f.add(sp);
		// 设置窗口的大小、位置
		f.setBounds(30, 30 , 250, 120);
		// 将窗口显示出来（Frame对象默认处于隐藏状态）
		f.setVisible(true);
	}
}

