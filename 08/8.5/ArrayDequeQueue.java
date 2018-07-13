
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
public class ArrayDequeQueue
{
	public static void main(String[] args)
	{
		ArrayDeque queue = new ArrayDeque();
		// 依次将三个元素加入队列
		queue.offer("疯狂Java讲义");
		queue.offer("轻量级Java EE企业应用实战");
		queue.offer("疯狂Android讲义");
		// 输出：[疯狂Java讲义, 轻量级Java EE企业应用实战, 疯狂Android讲义]
		System.out.println(queue);
		// 访问队列头部的元素，但并不将其poll出队列"栈"，输出：疯狂Java讲义
		System.out.println(queue.peek());
		// 依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战, 疯狂Android讲义]
		System.out.println(queue);
		// poll出第一个元素，输出：疯狂Java讲义
		System.out.println(queue.poll());
		// 输出：[轻量级Java EE企业应用实战, 疯狂Android讲义]
		System.out.println(queue);
	}
}
