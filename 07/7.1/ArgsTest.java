

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
public class ArgsTest
{
	public static void main(String[] args)
	{
		// 输出args数组的长度
		System.out.println(args.length);
		// 遍历args数组的每个元素
		for (String arg : args)
		{
			System.out.println(arg);
		}
	}
}

