
import java.util.*;
import java.text.*;
import static java.text.DateFormat.*;
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
public class DateFormatTest
{
	public static void main(String[] args)
		throws ParseException
	{
		// 需要被格式化的时间
		Date dt = new Date();
		// 创建两个Locale，分别代表中国、美国
		Locale[] locales = {Locale.CHINA, Locale.US};
		DateFormat[] df = new DateFormat[16];
		// 为上面两个Locale创建16个DateFormat对象
		for (int i = 0 ; i < locales.length ; i++)
		{
			df[i * 8] = DateFormat.getDateInstance(SHORT, locales[i]);
			df[i * 8 + 1] = DateFormat.getDateInstance(MEDIUM, locales[i]);
			df[i * 8 + 2] = DateFormat.getDateInstance(LONG, locales[i]);
			df[i * 8 + 3] = DateFormat.getDateInstance(FULL, locales[i]);
			df[i * 8 + 4] = DateFormat.getTimeInstance(SHORT, locales[i]);
			df[i * 8 + 5] = DateFormat.getTimeInstance(MEDIUM , locales[i]);
			df[i * 8 + 6] = DateFormat.getTimeInstance(LONG , locales[i]);
			df[i * 8 + 7] = DateFormat.getTimeInstance(FULL , locales[i]);
		}
		for (int i = 0 ; i < locales.length ; i++)
		{
			String tip = i == 0 ? "----中国日期格式----":"----美国日期格式----";
			System.out.println(tip);
			System.out.println("SHORT格式的日期格式："
				+ df[i * 8].format(dt));
			System.out.println("MEDIUM格式的日期格式："
				+ df[i * 8 + 1].format(dt));
			System.out.println("LONG格式的日期格式："
				+ df[i * 8 + 2].format(dt));
			System.out.println("FULL格式的日期格式："
				+ df[i * 8 + 3].format(dt));
			System.out.println("SHORT格式的时间格式："
				+ df[i * 8 + 4].format(dt));
			System.out.println("MEDIUM格式的时间格式："
				+ df[i * 8 + 5].format(dt));
			System.out.println("LONG格式的时间格式："
				+ df[i * 8 + 6].format(dt));
			System.out.println("FULL格式的时间格式："
				+ df[i * 8 + 7].format(dt));
		}


		String str1 = "2017/10/07";
		String str2 = "2017年10月07日";
		// 下面输出 Sat Oct 07 00:00:00 CST 2017
		System.out.println(DateFormat.getDateInstance().parse(str2));
		// 下面输出 Sat Oct 07 00:00:00 CST 2017
		System.out.println(DateFormat.getDateInstance(SHORT).parse(str1));
		// 下面抛出 ParseException异常
		System.out.println(DateFormat.getDateInstance().parse(str1));
	}
}
