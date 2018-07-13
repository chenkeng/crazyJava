
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
public class GridBagTest
{
	private Frame f = new Frame("测试窗口");
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Button[] bs = new Button[10];
	public void init()
	{
		f.setLayout(gb);
		for (int i = 0; i < bs.length ; i++ )
		{
			bs[i] = new Button("按钮" + i);
		}
		// 所有组件都可以横向、纵向上扩大
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		addButton(bs[0]);
		addButton(bs[1]);
		addButton(bs[2]);
		// 该GridBagConstraints控制的GUI组件将会成为横向最后一个元素
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addButton(bs[3]);
		// 该GridBagConstraints控制的GUI组件将横向上不会扩大
		gbc.weightx = 0;
		addButton(bs[4]);
		// 该GridBagConstraints控制的GUI组件将横跨两个网格
		gbc.gridwidth = 2;
		addButton(bs[5]);
		// 该GridBagConstraints控制的GUI组件将横跨一个网格
		gbc.gridwidth = 1;
		// 该GridBagConstraints控制的GUI组件将纵向跨两个网格
		gbc.gridheight = 2;
		// 该GridBagConstraints控制的GUI组件将会成为横向最后一个元素
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addButton(bs[6]);
		// 该GridBagConstraints控制的GUI组件将横向跨越一个网格，纵向跨越2个网格。
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		// 该GridBagConstraints控制的GUI组件纵向扩大的权重是1
		gbc.weighty = 1;
		addButton(bs[7]);
		// 设置下面的按钮在纵向上不会扩大
		gbc.weighty = 0;
		// 该GridBagConstraints控制的GUI组件将会成为横向最后一个元素
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		// 该GridBagConstraints控制的GUI组件将纵向上横跨一个网格
		gbc.gridheight = 1;
		addButton(bs[8]);
		addButton(bs[9]);
		f.pack();
		f.setVisible(true);
	}
	private void addButton(Button button)
	{
		gb.setConstraints(button, gbc);
		f.add(button);
	}
	public static void main(String[] args)
	{
		new GridBagTest().init();
	}
}
