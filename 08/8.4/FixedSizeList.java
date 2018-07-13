
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
public class FixedSizeList
{
	public static void main(String[] args)
	{
		List fixedList = Arrays.asList("疯狂Java讲义"
			, "轻量级Java EE企业应用实战");
		// 获取fixedList的实现类，将输出Arrays$ArrayList
		System.out.println(fixedList.getClass());
		// 使用方法引用遍历集合元素
		fixedList.forEach(System.out::println);
		// 试图增加、删除元素都会引发UnsupportedOperationException异常
		fixedList.add("疯狂Android讲义");
		fixedList.remove("疯狂Java讲义");
	}
}
