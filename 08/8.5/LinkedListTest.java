
import java.util.*;
/**
 * Description:
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class LinkedListTest
{
	public static void main(String[] args)
	{
		LinkedList books = new LinkedList();
		// ���ַ���Ԫ�ؼ�����е�β��
		books.offer("���Java����");
		// ��һ���ַ���Ԫ�ؼ���ջ�Ķ���
		books.push("������Java EE��ҵӦ��ʵս");
		// ���ַ���Ԫ�����ӵ����е�ͷ�����൱��ջ�Ķ�����
		books.offerFirst("���Android����");
		// ��List�ķ�ʽ�����������ʵķ�ʽ������������Ԫ��
		for (int i = 0; i < books.size() ; i++ )
		{
			System.out.println("�����У�" + books.get(i));
		}
		// ���ʡ�����ɾ��ջ����Ԫ��
		System.out.println(books.peekFirst());
		// ���ʡ�����ɾ�����е����һ��Ԫ��
		System.out.println(books.peekLast());
		// ��ջ����Ԫ�ص�����ջ��
		System.out.println(books.pop());
		// ������������������е�һ��Ԫ�ر�ɾ��
		System.out.println(books);
		// ���ʡ���ɾ�����е����һ��Ԫ��
		System.out.println(books.pollLast());
		// ���������[������Java EE��ҵӦ��ʵս]
		System.out.println(books);
	}
}