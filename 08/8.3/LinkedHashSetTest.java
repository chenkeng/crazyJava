
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
public class LinkedHashSetTest
{
	public static void main(String[] args)
	{
		LinkedHashSet books = new LinkedHashSet();
		books.add("疯狂Java讲义");
		books.add("轻量级Java EE企业应用实战");
		System.out.println(books);
		// 删除 疯狂Java讲义
		books.remove("疯狂Java讲义");
		// 重新添加 疯狂Java讲义
		books.add("疯狂Java讲义");
		System.out.println(books);
	}
}
