
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
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
public class JOptionPaneTest
{
	JFrame jf = new JFrame("测试JOptionPane");
	// 分别定义6个面板用于定义对话框的几种选项
	private ButtonPanel messagePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel msgPanel;
	private ButtonPanel confirmPanel;
	private ButtonPanel optionsPanel;
	private ButtonPanel inputPanel;
	private String messageString = "消息区内容";
	private Icon messageIcon = new ImageIcon("ico/heart.png");
	private Object messageObject = new Date();
	private Component messageComponent = new JButton("组件消息");
	private JButton msgBn = new JButton("消息对话框");
	private JButton confrimBn = new JButton("确认对话框");
	private JButton inputBn = new JButton("输入对话框");
	private JButton optionBn = new JButton("选项对话框");
	public void init()
	{
		JPanel top = new JPanel();
		top.setBorder(new TitledBorder(new EtchedBorder()
			, "对话框的通用选项" , TitledBorder.CENTER ,TitledBorder.TOP));
		top.setLayout(new GridLayout(1 , 2));
		// 消息类型Panel，该Panel中的选项决定对话框的图标
		messageTypePanel = new ButtonPanel("选择消息的类型",
		new String[]{"ERROR_MESSAGE", "INFORMATION_MESSAGE"
			, "WARNING_MESSAGE", "QUESTION_MESSAGE",	"PLAIN_MESSAGE" });
		// 消息内容类型的Panel，该Panel中的选项决定对话框的消息区的内容
		messagePanel = new ButtonPanel("选择消息内容的类型",
			new String[]{"字符串消息", "图标消息", "组件消息"
				, "普通对象消息" , "Object[]消息"});
		top.add(messageTypePanel);
		top.add(messagePanel);
		JPanel bottom = new JPanel();
		bottom.setBorder(new TitledBorder(new EtchedBorder()
			, "弹出不同的对话框" , TitledBorder.CENTER ,TitledBorder.TOP));
		bottom.setLayout(new GridLayout(1 , 4));
		// 创建用于弹出消息对话框的Panel
		msgPanel = new ButtonPanel("消息对话框", null);
		msgBn.addActionListener(new ShowAction());
		msgPanel.add(msgBn);
		// 创建用于弹出确认对话框的Panel
		confirmPanel = new ButtonPanel("确认对话框",
			new String[]{"DEFAULT_OPTION", "YES_NO_OPTION"
				, "YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"});
		confrimBn.addActionListener(new ShowAction());
		confirmPanel.add(confrimBn);
		// 创建用于弹出输入对话框的Panel
		inputPanel = new ButtonPanel("输入对话框"
			, new String[]{"单行文本框","下拉列表选择框"});
		inputBn.addActionListener(new ShowAction());
		inputPanel.add(inputBn);
		// 创建用于弹出选项对话框的Panel
		optionsPanel = new ButtonPanel("选项对话框"
			, new String[]{"字符串选项", "图标选项", "对象选项"});
		optionBn.addActionListener(new ShowAction());
		optionsPanel.add(optionBn);
		bottom.add(msgPanel);
		bottom.add(confirmPanel);
		bottom.add(inputPanel);
		bottom.add(optionsPanel);
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(top);
		box.add(bottom);
		jf.add(box);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	// 根据用户选择返回选项类型
	private int getOptionType()
	{
		switch(confirmPanel.getSelection())
		{
			case "DEFAULT_OPTION":
				return JOptionPane.DEFAULT_OPTION;
			case "YES_NO_OPTION":
				return JOptionPane.YES_NO_OPTION;
			case "YES_NO_CANCEL_OPTION":
				return JOptionPane.YES_NO_CANCEL_OPTION;
			default:
				return JOptionPane.OK_CANCEL_OPTION;
		}
	}
	// 根据用户选择返回消息
	private Object getMessage()
	{
		switch(messagePanel.getSelection())
		{
			case "字符串消息":
				return messageString;
			case "图标消息":
				return messageIcon;
			case "组件消息":
				return messageComponent;
			case "普通对象消息":
				return messageObject;
			default:
				return new Object[]{messageString , messageIcon
					, messageObject , messageComponent};
		}
	}
	// 根据用户选择返回消息类型（决定图标区的图标）
	private int getDialogType()
	{
		switch(messageTypePanel.getSelection())
		{
			case "ERROR_MESSAGE":
				return JOptionPane.ERROR_MESSAGE;
			case "INFORMATION_MESSAGE":
				return JOptionPane.INFORMATION_MESSAGE;
			case "WARNING_MESSAGE":
				return JOptionPane.WARNING_MESSAGE;
			case "QUESTION_MESSAGE":
				return JOptionPane.QUESTION_MESSAGE;
			default:
				return JOptionPane.PLAIN_MESSAGE;
		}
	}
	private Object[] getOptions()
	{
		switch(optionsPanel.getSelection())
		{
			case "字符串选项":
				return new String[]{"a" , "b" , "c" , "d"};
			case "图标选项":
				return new Icon[]{new ImageIcon("ico/1.gif")
					, new ImageIcon("ico/2.gif")
					, new ImageIcon("ico/3.gif")
					, new ImageIcon("ico/4.gif")};
			default:
				return new Object[]{new Date() ,new Date() , new Date()};
		}
	}
	// 为各按钮定义事件监听器
	private class ShowAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			switch(event.getActionCommand())
			{
				case "确认对话框":
					JOptionPane.showConfirmDialog(jf , getMessage()
						,"确认对话框", getOptionType(), getDialogType());
					break;
				case "输入对话框":
					if (inputPanel.getSelection().equals("单行文本框"))
					{
						JOptionPane.showInputDialog(jf, getMessage()
							, "输入对话框", getDialogType());
					}
					else
					{
						JOptionPane.showInputDialog(jf, getMessage()
							, "输入对话框", getDialogType() , null
							, new String[]{"轻量级Java EE企业应用实战"
							, "疯狂Java讲义"}, "疯狂Java讲义");
					}
					break;
				case "消息对话框":
					JOptionPane.showMessageDialog(jf,getMessage()
						,"消息对话框", getDialogType());
					break;
				case "选项对话框":
					JOptionPane.showOptionDialog(jf , getMessage()
						, "选项对话框", getOptionType() , getDialogType()
						, null,getOptions(), "a");
					break;
			}
		}
	}
	public static void main(String[] args)
	{
		new JOptionPaneTest().init();
	}
}

// 定义一个JPanel类扩展类，该类的对象包含多个纵向排列的
// JRadioButton控件,且Panel扩展类可以指定一个字符串作为TitledBorder
class ButtonPanel extends JPanel
{
	private ButtonGroup group;
	public ButtonPanel(String title, String[] options)
	{
		setBorder(BorderFactory.createTitledBorder(BorderFactory
			.createEtchedBorder(), title));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		group = new ButtonGroup();
		for (int i = 0; options!= null && i < options.length; i++)
		{
			JRadioButton b = new JRadioButton(options[i]);
			b.setActionCommand(options[i]);
			add(b);
			group.add(b);
			b.setSelected(i == 0);
		}
	}
	// 定义一个方法，用于返回用户选择的选项
	public String getSelection()
	{
		return group.getSelection().getActionCommand();
	}
}
