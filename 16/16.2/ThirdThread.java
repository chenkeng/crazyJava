
import java.util.concurrent.*;
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

public class ThirdThread
{
	public static void main(String[] args)
	{
		// 创建Callable对象
		ThirdThread rt = new ThirdThread();
		// 先使用Lambda表达式创建Callable<Integer>对象
		// 使用FutureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			int i = 0;
			for ( ; i < 100 ; i++ )
			{
				System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值：" + i);
			}
			// call()方法可以有返回值
			return i;
		});
		for (int i = 0 ; i < 100 ; i++)
		{
			System.out.println(Thread.currentThread().getName()
				+ " 的循环变量i的值：" + i);
			if (i == 20)
			{
				// 实质还是以Callable对象来创建、并启动线程
				new Thread(task , "有返回值的线程").start();
			}
		}
		try
		{
			// 获取线程返回值
			System.out.println("子线程的返回值：" + task.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

