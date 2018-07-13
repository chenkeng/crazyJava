
import java.util.*;
import java.util.function.*;
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
public class PredicateTest2
{
	public static void main(String[] args)
	{
		// 创建books集合、为books集合添加元素的代码与前一个程序相同。
		Collection books = new HashSet();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂iOS讲义"));
		books.add(new String("疯狂Ajax讲义"));
		books.add(new String("疯狂Android讲义"));
		// 统计书名包含“疯狂”子串的图书数量
		System.out.println(calAll(books , ele->((String)ele).contains("疯狂")));
		// 统计书名包含“Java”子串的图书数量
		System.out.println(calAll(books , ele->((String)ele).contains("Java")));
		// 统计书名字符串长度大于10的图书数量
		System.out.println(calAll(books , ele->((String)ele).length() > 10));
	}
	public static int calAll(Collection books , Predicate p)
	{
		int total = 0;
		for (Object obj : books)
		{
			// 使用Predicate的test()方法判断该对象是否满足Predicate指定的条件
			if (p.test(obj))
			{
				total ++;
			}
		}
		return total;
	}
}
