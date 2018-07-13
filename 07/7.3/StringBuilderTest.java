

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
public class StringBuilderTest
{
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		// 追加字符串
		sb.append("java");//sb = "java"
		// 插入
		sb.insert(0 , "hello "); // sb="hello java"
		// 替换
		sb.replace(5, 6, ","); // sb="hello,java"
		// 删除
		sb.delete(5, 6); // sb="hellojava"
		System.out.println(sb);
		// 反转
		sb.reverse(); // sb="avajolleh"
		System.out.println(sb);
		System.out.println(sb.length()); // 输出9
		System.out.println(sb.capacity()); // 输出16
		// 改变StringBuilder的长度，将只保留前面部分
		sb.setLength(5); // sb="avajo"
		System.out.println(sb);
	}
}
