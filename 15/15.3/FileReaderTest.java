
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
public class FileReaderTest
{
	public static void main(String[] args)
	{
		try(
			// 创建字符输入流
			FileReader fr = new FileReader("FileReaderTest.java"))
		{
			// 创建一个长度为32的“竹筒”
			char[] cbuf = new char[32];
			// 用于保存实际读取的字符数
			int hasRead = 0;
			// 使用循环来重复“取水”过程
			while ((hasRead = fr.read(cbuf)) > 0 )
			{
				// 取出“竹筒”中水滴（字符），将字符数组转换成字符串输入！
				System.out.print(new String(cbuf , 0 , hasRead));
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
