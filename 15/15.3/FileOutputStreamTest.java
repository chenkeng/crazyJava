
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
public class FileOutputStreamTest
{
	public static void main(String[] args)
	{
		try(
			// 创建字节输入流
			FileInputStream fis = new FileInputStream(
				"FileOutputStreamTest.java");
			// 创建字节输出流
			FileOutputStream fos = new FileOutputStream("newFile.txt"))
		{
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			// 循环从输入流中取出数据
			while ((hasRead = fis.read(bbuf)) > 0 )
			{
				// 每读取一次，即写入文件输出流，读了多少，就写多少。
				fos.write(bbuf , 0 , hasRead);
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
