
import java.util.regex.*;
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
public class StartEnd
{
	public static void main(String[] args)
	{
		// 创建一个Pattern对象，并用它建立一个Matcher对象
		String regStr = "Java is very easy!";
		System.out.println("目标字符串是：" + regStr);
		Matcher m = Pattern.compile("\\w+")
			.matcher(regStr);
		while(m.find())
		{
			System.out.println(m.group() + "子串的起始位置："
				+ m.start() + "，其结束位置：" + m.end());
		}
	}
}
