
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
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
public class CachedRowSetPage
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

	public CachedRowSet query(String sql , int pageSize
		, int page)throws Exception
	{
		// 加载驱动
		Class.forName(driver);
		try(
			// 获取数据库连接
			Connection conn = DriverManager.getConnection(url , user , pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql))
		{
			// 使用RowSetProvider创建RowSetFactory
			RowSetFactory factory = RowSetProvider.newFactory();
			// 创建默认的CachedRowSet实例
			CachedRowSet cachedRs = factory.createCachedRowSet();
			// 设置每页显示pageSize条记录
			cachedRs.setPageSize(pageSize);
			// 使用ResultSet装填RowSet，设置从第几条记录开始
			cachedRs.populate(rs , (page - 1) * pageSize + 1);
			return cachedRs;
		}
	}
	public static void main(String[] args)throws Exception
	{
		CachedRowSetPage cp = new CachedRowSetPage();
		cp.initParam("mysql.ini");
		CachedRowSet rs = cp.query("select * from student_table" , 3 , 2);   // ①
		// 向后滚动结果集
		while (rs.next())
		{
			System.out.println(rs.getString(1)
				+ "\t" + rs.getString(2)
				+ "\t" + rs.getString(3));
		}
	}
}