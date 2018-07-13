
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
public class KeyboardInTest
{
	public static void main(String[] args)
		throws Exception
	{
		// 以System.in节点流为基础，创建一个BufferedReader对象
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		String line = null;
		// 逐行读取键盘输入
		while ((line = br.readLine()) != null)
		{
			System.out.println("用户键盘输入是:" + line);
		}
	}
}
