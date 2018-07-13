
import java.awt.*;
import java.awt.event.*;
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
public class BindKeyTest
{
	JFrame jf = new JFrame("测试键盘绑定");
	JTextArea jta = new JTextArea(5, 30);
	JButton jb = new JButton("发送");
	JTextField jtf = new JTextField(15);
	public void init()
	{
		jf.add(jta);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jf.add(jp , BorderLayout.SOUTH);
		// 发送消息的Action,Action是ActionListener的子接口
		Action sendMsg = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				jta.append(jtf.getText() + "\n");
				jtf.setText("");
			}
		};
		// 添加事件监听器
		jb.addActionListener(sendMsg);
		// 将Ctrl+Enter键和"send"关联
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n'
			, java.awt.event.InputEvent.CTRL_MASK) , "send");
		// 将"send"和sendMsg Action关联
		jtf.getActionMap().put("send", sendMsg);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BindKeyTest().init();
	}
}
