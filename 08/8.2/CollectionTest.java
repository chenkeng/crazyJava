
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
public class CollectionTest
{
	public static void main(String[] args)
	{
		Collection c = new ArrayList();
		// 添加元素
		c.add("孙悟空");
		// 虽然集合里不能放基本类型的值，但Java支持自动装箱
		c.add(6);
		System.out.println("c集合的元素个数为:" + c.size()); // 输出2
		// 删除指定元素
		c.remove(6);
		System.out.println("c集合的元素个数为:" + c.size()); // 输出1
		// 判断是否包含指定字符串
		System.out.println("c集合的是否包含\"孙悟空\"字符串:"
			+ c.contains("孙悟空")); // 输出true
		c.add("轻量级Java EE企业应用实战");
		System.out.println("c集合的元素：" + c);
		Collection books = new HashSet();
		books.add("轻量级Java EE企业应用实战");
		books.add("疯狂Java讲义");
		System.out.println("c集合是否完全包含books集合？"
			+ c.containsAll(books)); // 输出false
		// 用c集合减去books集合里的元素
		c.removeAll(books);
		System.out.println("c集合的元素：" + c);
		// 删除c集合里所有元素
		c.clear();
		System.out.println("c集合的元素：" + c);
		// 控制books集合里只剩下c集合里也包含的元素
		books.retainAll(c);
		System.out.println("books集合的元素:" + books);
	}
}