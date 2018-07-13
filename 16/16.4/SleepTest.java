
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
public class SleepTest
{
	public static void main(String[] args)
		throws Exception
	{
		for (int i = 0; i < 10 ; i++ )
		{
			System.out.println("当前时间: " + new Date());
			// 调用sleep方法让当前线程暂停1s。
			Thread.sleep(1000);
		}
	}
}

