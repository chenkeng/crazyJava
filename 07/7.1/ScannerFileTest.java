
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
public class ScannerFileTest
{
	public static void main(String[] args)
		throws Exception
	{
		// 将一个File对象作为Scanner的构造器参数，Scanner读取文件内容
		Scanner sc = new Scanner(new File("ScannerFileTest.java"));
		System.out.println("ScannerFileTest.java文件内容如下：");
		// 判断是否还有下一行
		while(sc.hasNextLine())
		{
			// 输出文件中的下一行
			System.out.println(sc.nextLine());
		}
	}
}

