
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
public class Hello
{
	public static void main(String[] args)
	{
		// 取得系统默认的国家/语言环境
		Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
		// 根据指定国家/语言环境加载资源文件
		ResourceBundle bundle = ResourceBundle
			.getBundle("mess" , myLocale);
		// 打印从资源文件中取得的消息
		System.out.println(bundle.getString("hello"));
	}
}
