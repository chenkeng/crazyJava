
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
public class CommonComponent
{
	Frame f = new Frame("测试");
	// 定义一个按钮
	Button ok = new Button("确认");
	CheckboxGroup cbg = new CheckboxGroup();
	// 定义一个单选框（处于cbg组），初始处于被选中状态
	Checkbox male = new Checkbox("男" , cbg , true);
	// 定义一个单选框（处于cbg组），初始处于没有选中状态
	Checkbox female = new Checkbox("女" , cbg , false);
	// 定义一个复选框，初始处于没有选中状态
	Checkbox married = new Checkbox("是否已婚？" , false);
	// 定义一个下拉选择框
	Choice colorChooser = new Choice();
	// 定义一个列表选择框
	List colorList = new List(6, true);
	// 定义一个5行、20列的多行文本域
	TextArea ta = new TextArea(5, 20);
	// 定义一个50列的单行文本域
	TextField name = new TextField(50);
	public void init()
	{
		colorChooser.add("红色");
		colorChooser.add("绿色");
		colorChooser.add("蓝色");
		colorList.add("红色");
		colorList.add("绿色");
		colorList.add("蓝色");
		// 创建一个装载了文本框、按钮的Panel
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom , BorderLayout.SOUTH);
		// 创建一个装载了下拉选择框、三个Checkbox的Panel
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		// 创建一个垂直排列组件的Box，盛装多行文本域、Panel
		Box topLeft = Box.createVerticalBox();
		topLeft.add(ta);
		topLeft.add(checkPanel);
		// 创建一个水平排列组件的Box，盛装topLeft、colorList
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		// 将top Box容器添加到窗口的中间
		f.add(top);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new CommonComponent().init();
	}
}
