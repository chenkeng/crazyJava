
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
public class ResultSetTest
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
	public void query(String sql)throws Exception
	{
		// 加载驱动
		Class.forName(driver);
		try(
			// 获取数据库连接
			Connection conn = DriverManager.getConnection(url , user , pass);
			// 使用Connection来创建一个PreparedStatement对象
			// 传入控制结果集可滚动，可更新的参数。
			PreparedStatement pstmt = conn.prepareStatement(sql
				, ResultSet.TYPE_SCROLL_INSENSITIVE
				, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery())
		{
			rs.last();
			int rowCount = rs.getRow();
			for (int i = rowCount; i > 0 ; i-- )
			{
				rs.absolute(i);
				System.out.println(rs.getString(1) + "\t"
					+ rs.getString(2) + "\t" + rs.getString(3));
				// 修改记录指针所有记录、第2列的值
				rs.updateString(2 , "学生名" + i);
				// 提交修改
				rs.updateRow();
			}
		}
	}
	public static void main(String[] args) throws Exception
	{
		ResultSetTest rt = new ResultSetTest();
		rt.initParam("mysql.ini");
		rt.query("select * from student_table");
	}
}
