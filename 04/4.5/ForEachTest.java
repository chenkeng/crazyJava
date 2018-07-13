

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
public class ForEachTest
{
	public static void main(String[] args)
	{
		String[] books = {"轻量级Java EE企业应用实战" ,
		"疯狂Java讲义",
		"疯狂Android讲义"};
		// 使用foreach循环来遍历数组元素，
		// 其中book将会自动迭代每个数组元素
		for (String book : books)
		{
			System.out.println(book);
		}
	}
}
