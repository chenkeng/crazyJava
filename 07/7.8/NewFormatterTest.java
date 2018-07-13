
import java.time.*;
import java.time.format.*;
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
public class NewFormatterTest
{
	public static void main(String[] args)
	{
		DateTimeFormatter[] formatters = new DateTimeFormatter[]{
			// 直接使用常量创建DateTimeFormatter格式器
			DateTimeFormatter.ISO_LOCAL_DATE,
			DateTimeFormatter.ISO_LOCAL_TIME,
			DateTimeFormatter.ISO_LOCAL_DATE_TIME,
			// 使用本地化的不同风格来创建DateTimeFormatter格式器
			DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
			DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
			// 根据模式字符串来创建DateTimeFormatter格式器
			DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss")
		};
		LocalDateTime date = LocalDateTime.now();
		// 依次使用不同的格式器对LocalDateTime进行格式化
		for(int i = 0 ; i < formatters.length ; i++)
		{
			// 下面两行代码的作用相同
			System.out.println(date.format(formatters[i]));
			System.out.println(formatters[i].format(date));
		}
	}
}
