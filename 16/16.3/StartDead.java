

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
public class StartDead extends Thread
{
	private int i ;
	// 重写run方法，run方法的方法体就是线程执行体
	public void run()
	{
		for ( ; i < 100 ; i++ )
		{
			System.out.println(getName() +  " " + i);
		}
	}
	public static void main(String[] args)
	{
		// 创建线程对象
		StartDead sd = new StartDead();
		for (int i = 0; i < 300;  i++)
		{
			// 调用Thread的currentThread方法获取当前线程
			System.out.println(Thread.currentThread().getName()
				+  " " + i);
			if (i == 20)
			{
				// 启动线程
				sd.start();
				// 判断启动后线程的isAlive()值，输出true
				System.out.println(sd.isAlive());
			}
			// 只有当线程处于新建、死亡两种状态时isAlive()方法返回false。
			// 当i > 20，则该线程肯定已经启动过了，如果sd.isAlive()为假时，
			// 那只能是死亡状态了。
			if (i > 20 && !sd.isAlive())

			{
				// 试图再次启动该线程
				sd.start();
			}
		}
	}
}

