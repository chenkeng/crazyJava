
import java.util.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
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
public class ListTest
{
	private JFrame mainWin = new JFrame("测试列表框");
	String[] books = new String[]
	{
		"疯狂Java讲义"
		, "轻量级Java EE企业应用实战"
		, "疯狂Android讲义"
		, "疯狂Ajax讲义"
		, "经典Java EE企业应用实战"
	};
	// 用一个字符串数组来创建一个JList对象
	JList<String> bookList = new JList<>(books);
	JComboBox<String> bookSelector;
	// 定义布局选择按钮所在的面板
	JPanel layoutPanel = new JPanel();
	ButtonGroup layoutGroup = new ButtonGroup();
	// 定义选择模式按钮所在的面板
	JPanel selectModePanel = new JPanel();
	ButtonGroup selectModeGroup = new ButtonGroup();
	JTextArea favoriate = new JTextArea(4 , 40);
	public void init()
	{
		// 设置JList的可视高度可同时显示三个列表项
		bookList.setVisibleRowCount(3);
		// 默认选中第三项到第五项（第一项的索引是0）
		bookList.setSelectionInterval(2, 4);
		addLayoutButton("纵向滚动", JList.VERTICAL);
		addLayoutButton("纵向换行", JList.VERTICAL_WRAP);
		addLayoutButton("横向换行", JList.HORIZONTAL_WRAP);
		addSelectModelButton("无限制", ListSelectionModel
			.MULTIPLE_INTERVAL_SELECTION);
		addSelectModelButton("单选", ListSelectionModel
			.SINGLE_SELECTION);
		addSelectModelButton("单范围", ListSelectionModel
			.SINGLE_INTERVAL_SELECTION);
		Box listBox = new Box(BoxLayout.Y_AXIS);
		// 将JList组件放在JScrollPane中，再将该JScrollPane添加到listBox容器中
		listBox.add(new JScrollPane(bookList));
		// 添加布局选择按钮面板、选择模式按钮面板
		listBox.add(layoutPanel);
		listBox.add(selectModePanel);
		// 为JList添加事件监听器
		bookList.addListSelectionListener(e -> {  // ①
			// 获取用户所选择的所有图书
			List<String> books = bookList.getSelectedValuesList();
			favoriate.setText("");
			for (String book : books )
			{
				favoriate.append(book + "\n");
			}
		});
		Vector<String> bookCollection = new Vector<>();
		bookCollection.add("疯狂Java讲义");
		bookCollection.add("轻量级Java EE企业应用实战");
		bookCollection.add("疯狂Android讲义");
		bookCollection.add("疯狂Ajax讲义");
		bookCollection.add("经典Java EE企业应用实战");
		// 用一个Vector对象来创建一个JComboBox对象
		bookSelector = new JComboBox<>(bookCollection);
		// 为JComboBox添加事件监听器
		bookSelector.addItemListener(e -> {  // ②
			// 获取JComboBox所选中的项
			Object book = bookSelector.getSelectedItem();
			favoriate.setText(book.toString());
		});
		// 设置可以直接编辑
		bookSelector.setEditable(true);
		// 设置下拉列表框的可视高度可同时显示4个列表项
		bookSelector.setMaximumRowCount(4);
		JPanel p = new JPanel();
		p.add(bookSelector);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(listBox);
		box.add(p);
		mainWin.add(box);
		JPanel favoriatePanel = new JPanel();
		favoriatePanel.setLayout(new BorderLayout());
		favoriatePanel.add(new JScrollPane(favoriate));
		favoriatePanel.add(new JLabel("您喜欢的图书：")
			, BorderLayout.NORTH);
		mainWin.add(favoriatePanel , BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	private void addLayoutButton(String label, final int orientation)
	{
		layoutPanel.setBorder(new TitledBorder(new EtchedBorder()
			, "确定选项布局"));
		JRadioButton button = new JRadioButton(label);
		// 把该单选按钮添加到layoutPanel面板中
		layoutPanel.add(button);
		// 默认选中第一个按钮
		if (layoutGroup.getButtonCount() == 0)
		button.setSelected(true);
		layoutGroup.add(button);
		button.addActionListener(event ->
			// 改变列表框里列表项的布局方向
			bookList.setLayoutOrientation(orientation));
	}
	private void addSelectModelButton(String label, final int selectModel)
	{
		selectModePanel.setBorder(new TitledBorder(new EtchedBorder()
			, "确定选择模式"));
		JRadioButton button = new JRadioButton(label);
		// 把该单选按钮添加到selectModePanel面板中
		selectModePanel.add(button);
		// 默认选中第一个按钮
		if(selectModeGroup.getButtonCount() == 0)
			button.setSelected(true);
		selectModeGroup.add(button);
		button.addActionListener(event ->
			// 改变列表框里的选择模式
			bookList.setSelectionMode(selectModel));
	}
	public static void main(String[] args)
	{
		new ListTest().init();
	}
}
