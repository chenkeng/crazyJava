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
public class AutoCloseTest2
{
	public static void main(String[] args)
		throws IOException
	{
		// 有final修饰的资源
		final BufferedReader br = new BufferedReader(
			new FileReader("AutoCloseTest.java"));
		// 没有显式使用final修饰，但只要不对该变量重新赋值，按该变量就是有效的final
		PrintStream ps = new PrintStream(new
			FileOutputStream("a.txt"));
		// 只要将两个资源放在try后的圆括号内即可
		try (br;ps)
		{
			// 使用两个资源
			System.out.println(br.readLine());
			ps.println("庄生晓梦迷蝴蝶");
		}
	}
}
