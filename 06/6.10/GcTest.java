

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
public class GcTest
{
	public static void main(String[] args)
	{
		for (int i = 0 ; i < 4; i++)
		{
			new GcTest();
			// 下面两行代码的作用完全相同，强制系统进行垃圾回收
			// System.gc();
			Runtime.getRuntime().gc();
		}
	}
	public void finalize()
	{
		System.out.println("系统正在清理GcTest对象的资源...");
	}
}
