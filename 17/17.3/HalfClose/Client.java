
import java.io.*;
import java.net.*;
import java.util.*;
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
public class Client
{
	public static void main(String[] args)
		throws Exception
	{
		Socket s = new Socket("localhost" , 30000);
		Scanner scan = new Scanner(s.getInputStream());
		while (scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("客户端的第一行数据");
		ps.println("客户端的第二行数据");
		ps.close();
		scan.close();
		s.close();
	}
}

