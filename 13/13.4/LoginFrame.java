
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;
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
public class LoginFrame
{
	private final String PROP_FILE = "mysql.ini";
	private String driver;
	// url是数据库的服务地址
	private String url;
	private String user;
	private String pass;
	// 登录界面的GUI组件
	private JFrame jf = new JFrame("登录");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("登录");
	public void init()throws Exception
	{
		Properties connProp = new Properties();
		connProp.load(new FileInputStream(PROP_FILE));
		driver = connProp.getProperty("driver");
		url = connProp.getProperty("url");
		user = connProp.getProperty("user");
		pass = connProp.getProperty("pass");
		// 加载驱动
		Class.forName(driver);
		// 为登录按钮添加事件监听器
		loginButton.addActionListener(e -> {
			// 登录成功则显示“登录成功”
			if (validate(userField.getText(), passField.getText()))
			{
				JOptionPane.showMessageDialog(jf, "登录成功");
			}
			// 否则显示“登录失败”
			else
			{
				JOptionPane.showMessageDialog(jf, "登录失败");
			}
		});
		jf.add(userField , BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginButton , BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
//	private boolean validate(String userName, String userPass)
//	{
//		// 执行查询的SQL语句
//		String sql = "select * from jdbc_test "
//			+ "where jdbc_name='" + userName
//			+ "' and jdbc_desc='" + userPass + "'";
//		System.out.println(sql);
//		try(
//			Connection conn = DriverManager.getConnection(url , user ,pass);
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql))
//		{
//			// 如果查询的ResultSet里有超过一条的记录，则登录成功
//			if (rs.next())
//			{
//				return true;
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return false;
//	}

	private boolean validate(String userName, String userPass)
	{
		try(
			Connection conn = DriverManager.getConnection(url
				, user ,pass);
			PreparedStatement pstmt = conn.prepareStatement(
				"select * from jdbc_test where jdbc_name=? and jdbc_desc=?"))
		{
			pstmt.setString(1, userName);
			pstmt.setString(2, userPass);
			try(
				ResultSet rs = pstmt.executeQuery())
			{
				//如果查询的ResultSet里有超过一条的记录，则登录成功
				if (rs.next())
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception
	{
		new LoginFrame().init();
	}
}
