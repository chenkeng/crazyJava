
import java.sql.*;
import java.util.*;
import java.io.*;
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
public class DatabaseMetaDataTest
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
	public void info() throws Exception
	{
		// 加载驱动
		Class.forName(driver);
		try(
			// 获取数据库连接
			Connection conn = DriverManager.getConnection(url
				, user , pass))
		{
			// 获取的DatabaseMetaData对象
			DatabaseMetaData dbmd = conn.getMetaData();
			// 获取MySQL支持的所有表类型
			ResultSet rs = dbmd.getTableTypes();
			System.out.println("--MySQL支持的表类型信息--");
			printResultSet(rs);
			// 获取当前数据库的全部数据表
			rs = dbmd.getTables(null,null, "%" , new String[]{"TABLE"});
			System.out.println("--当前数据库里的数据表信息--");
			printResultSet(rs);
			// 获取student_table表的主键
			rs = dbmd.getPrimaryKeys(null , null, "student_table");
			System.out.println("--student_table表的主键信息--");
			printResultSet(rs);
			// 获取当前数据库的全部存储过程
			rs = dbmd.getProcedures(null , null, "%");
			System.out.println("--当前数据库里的存储过程信息--");
			printResultSet(rs);
			// 获取teacher_table表和student_table之间的外键约束
			rs = dbmd.getCrossReference(null,null, "teacher_table"
				, null, null, "student_table");
			System.out.println("--teacher_table表和student_table之间"
				+ "的外键约束--");
			printResultSet(rs);
			// 获取student_table表的全部数据列
			rs = dbmd.getColumns(null, null, "student_table", "%");
			System.out.println("--student_table表的全部数据列--");
			printResultSet(rs);
		}
	}
	public void printResultSet(ResultSet rs)throws SQLException
	{
		ResultSetMetaData rsmd = rs.getMetaData();
		// 打印ResultSet的所有列标题
		for (int i = 0 ; i < rsmd.getColumnCount() ; i++ )
		{
			System.out.print(rsmd.getColumnName(i + 1) + "\t");
		}
		System.out.print("\n");
		// 打印ResultSet里的全部数据
		while (rs.next())
		{
			for (int i = 0; i < rsmd.getColumnCount() ; i++ )
			{
				System.out.print(rs.getString(i + 1) + "\t");
			}
			System.out.print("\n");
		}
		rs.close();
	}
	public static void main(String[] args)
		throws Exception
	{
		DatabaseMetaDataTest dt = new DatabaseMetaDataTest();
		dt.initParam("mysql.ini");
		dt.info();
	}
}
