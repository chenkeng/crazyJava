
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
public class myMess_zh_CN extends ListResourceBundle
{
	// 定义资源
	private final Object myData[][]=
	{
		{"msg","{0}，你好！今天的日期是{1}"}
	};
	// 重写方法getContents()
	public Object[][] getContents()
	{
		// 该方法返回资源的key-value对
		return myData;
	}
}
