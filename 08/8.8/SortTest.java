
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
public class SortTest
{
	public static void main(String[] args)
	{
		ArrayList nums = new ArrayList();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		System.out.println(nums); // 输出:[2, -5, 3, 0]
		Collections.reverse(nums); // 将List集合元素的次序反转
		System.out.println(nums); // 输出:[0, 3, -5, 2]
		Collections.sort(nums); // 将List集合元素的按自然顺序排序
		System.out.println(nums); // 输出:[-5, 0, 2, 3]
		Collections.shuffle(nums); // 将List集合元素的按随机顺序排序
		System.out.println(nums); // 每次输出的次序不固定
	}
}
