
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
public class CallableStatementTest
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	public void initParam(String paramFile)throws Exception
	{
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	public void callProcedure()throws Exception
	{
		// 加载驱动
		Class.forName(driver);
		try(
			// 获取数据库连接
			Connection conn = DriverManager.getConnection(url
				, user , pass);
			// 使用Connection来创建一个CallableStatment对象
			CallableStatement cstmt = conn.prepareCall(
				"{call add_pro(?,?,?)}"))
		{
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			// 注册CallableStatement的第三个参数是int类型
			cstmt.registerOutParameter(3, Types.INTEGER);
			// 执行存储过程
			cstmt.execute();
			// 获取，并输出存储过程传出参数的值。
			System.out.println("执行结果是: " + cstmt.getInt(3));
		}
	}
	public static void main(String[] args) throws Exception
	{
		CallableStatementTest ct = new CallableStatementTest();
		ct.initParam("mysql.ini");
		ct.callProcedure();
	}
}

