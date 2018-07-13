
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
public class FilenameFilterTest
{
	public static void main(String[] args)
	{
		File file = new File(".");
		// 使用Lambda表达式（目标类型为FilenameFilter）实现文件过滤器。
		// 如果文件名以.java结尾，或者文件对应一个路径，返回true
		String[] nameList = file.list((dir, name) -> name.endsWith(".java")
			|| new File(name).isDirectory());
		for(String name : nameList)
		{
			System.out.println(name);
		}
	}
}
