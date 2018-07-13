

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
public class RuntimeTest
{
	public static void main(String[] args)
	{
		// 获取Java程序关联的运行时对象
		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器数量："
			+ rt.availableProcessors());
		System.out.println("空闲内存数："
			+ rt.freeMemory());
		System.out.println("总内存数："
			+ rt.totalMemory());
		System.out.println("可用最大内存数："
			+ rt.maxMemory());
	}
}
