
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
public class ListErr
{
	public static void main(String[] args)
	{
		// 创建一个只想保存字符串的List集合
		List strList = new ArrayList();
		strList.add("疯狂Java讲义");
		strList.add("疯狂Android讲义");
		// "不小心"把一个Integer对象"丢进"了集合
		strList.add(5);     // ①
		strList.forEach(str -> System.out.println(((String)str).length())); // ②
	}
}
