
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.InetSocketAddress;
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
// 定义交谈的对话框
public class ChatFrame extends JDialog
{
	// 聊天信息区
	JTextArea msgArea = new JTextArea(12 , 45);
	// 聊天输入区
	JTextField chatField = new JTextField(30);
	// 发送聊天信息的按钮
	JButton sendBn = new JButton("发送");
	// 该交谈窗口对应的用户
	UserInfo user;
	// 构造器，用于初始化交谈对话框的界面
	public ChatFrame(LanTalk parent , final UserInfo user)
	{
		super(parent , "和" + user.getName() + "聊天中" , false);
		this.user = user;
		msgArea.setEditable(false);
		add(new JScrollPane(msgArea));
		JPanel buttom = new JPanel();
		buttom.add(new JLabel("输入信息："));
		buttom.add(chatField);
		buttom.add(sendBn);
		add(buttom , BorderLayout.SOUTH);
		// 发送消息的Action，Action是ActionListener的子接口
		Action sendAction = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				InetSocketAddress dest = (InetSocketAddress)user.getAddress();
				// 在聊友列表中，所有人项的SocketAddress是null
				// 这表明是向所有人发送消息
				if (dest == null)
				{
					LoginFrame.comUtil.broadCast(chatField.getText());
					msgArea.setText("您对大家说："
						+ chatField.getText() + "\n" + msgArea.getText());
				}
				// 向私人发送信息
				else
				{
					// 获取发送消息的目的
					dest = new InetSocketAddress(dest.getHostName(),
						dest.getPort() + 1);
					LoginFrame.comUtil.sendSingle(chatField.getText(), dest);
					msgArea.setText("您对" + user.getName() +  "说："
						+ chatField.getText() + "\n" + msgArea.getText());

				}
				chatField.setText("");
			}
		};
		sendBn.addActionListener(sendAction);
		// 将Ctrl+Enter键和"send"关联
		chatField.getInputMap().put(KeyStroke.getKeyStroke('\n'
			, java.awt.event.InputEvent.CTRL_DOWN_MASK) , "send");
		// 将"send"与sendAction关联
		chatField.getActionMap().put("send", sendAction);
		pack();
	}
	// 定义向聊天区域添加消息的方法
	public void addString(String msg)
	{
		msgArea.setText(msg + "\n" + msgArea.getText());
	}
}
