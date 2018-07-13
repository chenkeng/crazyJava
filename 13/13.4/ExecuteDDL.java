
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
public class ExecuteDDL
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	public void initParam(String paramFile)
		throws Exception
	{
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	public void createTable(String sql)throws Exception
	{
		// 加载驱动
		Class.forName(driver);
		try(
		// 获取数据库连接
		Connection conn = DriverManager.getConnection(url , user , pass);
		// 使用Connection来创建一个Statment对象
		Statement stmt = conn.createStatement())
		{
			// 执行DDL,创建数据表
			stmt.executeUpdate(sql);
		}
	}
	public static void main(String[] args) throws Exception
	{
		ExecuteDDL ed = new ExecuteDDL();
		ed.initParam("mysql.ini");
		ed.createTable("create table jdbc_test "
			+ "( jdbc_id int auto_increment primary key, "
			+ "jdbc_name varchar(255), "
			+ "jdbc_desc text);");
		System.out.println("-----建表成功-----");
	}
}

