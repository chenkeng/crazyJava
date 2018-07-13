
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
public class CollectionStream
{
	public static void main(String[] args)
	{
		// 创建books集合、为books集合添加元素的代码与8.2.5小节的程序相同。
		Collection books = new HashSet();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂iOS讲义"));
		books.add(new String("疯狂Ajax讲义"));
		books.add(new String("疯狂Android讲义"));
		// 统计书名包含“疯狂”子串的图书数量
		System.out.println(books.stream()
			.filter(ele->((String)ele).contains("疯狂"))
			.count()); // 输出4
		// 统计书名包含“Java”子串的图书数量
		System.out.println(books.stream()
			.filter(ele->((String)ele).contains("Java") )
			.count()); // 输出2
		// 统计书名字符串长度大于10的图书数量
		System.out.println(books.stream()
			.filter(ele->((String)ele).length() > 10)
			.count()); // 输出2
		// 先调用Collection对象的stream()方法将集合转换为Stream,
		// 再调用Stream的mapToInt()方法获取原有的Stream对应的IntStream
		books.stream().mapToInt(ele -> ((String)ele).length())
			// 调用forEach()方法遍历IntStream中每个元素
			.forEach(System.out::println);// 输出8  11  16  7  8
	}
}
