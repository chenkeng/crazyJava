
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
// 登录用的对话框
public class LoginFrame extends JDialog
{
	public JLabel tip;
	public JTextField userField = new JTextField("李刚" , 20);
	public JComboBox<Integer> iconList = new JComboBox<>(
		new Integer[]{1, 2, 3, 4, 5 , 6, 7, 8 ,9 ,10});
	private JButton loginBn = new JButton("登录");
	// 聊天的主界面
	private LanTalk chatFrame;
	// 聊天通信的工具实例
	public static ComUtil comUtil;
	// 构造器，用于初始化的登录对话框
	public LoginFrame(LanTalk parent , String msg)
	{
		super(parent , "输入名字后登录" , true);
		this.chatFrame = parent;
		setLayout(new GridLayout(5, 1));
		JPanel jp = new JPanel();
		tip = new JLabel(msg);
		tip.setFont(new Font("Serif" , Font.BOLD , 16));
		jp.add(tip);
		add(jp);
		add(getPanel("用户名" , userField));
		iconList.setPreferredSize(new Dimension(224, 20));
		add(getPanel("图    标" , iconList));
		JPanel bp = new JPanel();
		loginBn.addActionListener(new MyActionListener(this));
		bp.add(loginBn);
		add(bp);
		pack();
		setVisible(true);
	}
	// 工具方法，该方法将一个字符串和组件组合成JPanel对象
	private JPanel getPanel(String name , JComponent jf)
	{
		JPanel jp = new JPanel();
		jp.add(new JLabel(name + "："));
		jp.add(jf);
		return jp;
	}
	// 该方法用于改变登录窗口最上面的提示信息
	public void setTipMsg(String tip)
	{
		this.tip.setText(tip);
	}
	// 定义一个事件监听器
	class MyActionListener implements ActionListener
	{
		private LoginFrame loginFrame;
		public MyActionListener(LoginFrame loginFrame)
		{
			this.loginFrame = loginFrame;
		}
		// 当鼠标单击事件发生时
		public void actionPerformed(ActionEvent evt)
		{
			try
			{
				// 初始化聊天通信类
				comUtil = new ComUtil(chatFrame);
				final String loginMsg = YeekuProtocol.PRESENCE + userField.getText()
					+ YeekuProtocol.SPLITTER + iconList.getSelectedObjects()[0]
					+ YeekuProtocol.PRESENCE;
				comUtil.broadCast(loginMsg);
				// 启动定时器每20秒广播一次在线信息
				javax.swing.Timer timer = new javax.swing.Timer(1000 * 10
					, event-> comUtil.broadCast(loginMsg));
				timer.start();
				loginFrame.setVisible(false);
				chatFrame.setVisible(true);
			}
			catch (Exception ex)
			{
				loginFrame.setTipMsg("确认30001端口空闲，且网络正常！");
			}
		}
	}
}