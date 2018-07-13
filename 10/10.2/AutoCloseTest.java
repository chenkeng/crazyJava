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
public class AutoCloseTest
{
	public static void main(String[] args)
		throws IOException
	{
		try (
			// 声明、初始化两个可关闭的资源
			// try语句会自动关闭这两个资源。
			BufferedReader br = new BufferedReader(
				new FileReader("AutoCloseTest.java"));
			PrintStream ps = new PrintStream(new
				FileOutputStream("a.txt")))
		{
			// 使用两个资源
			System.out.println(br.readLine());
			ps.println("庄生晓梦迷蝴蝶");
		}
	}
}
