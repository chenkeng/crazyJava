
import java.awt.*;
import java.awt.event.*;
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
public class MailerListener implements ActionListener
{
	// 该TextField文本框用于输入发送邮件的地址
	private TextField mailAddress;
	public MailerListener(){}
	public MailerListener(TextField mailAddress)
	{
		this.mailAddress = mailAddress;
	}
	public void setMailAddress(TextField mailAddress)
	{
		this.mailAddress = mailAddress;
	}
	// 实现发送邮件
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("程序向“"
			+ mailAddress.getText() + "”发送邮件...");
		// 发送邮件的真实实现
	}
}

