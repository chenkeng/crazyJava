

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
public class PriorityTest extends Thread
{
	// 定义一个有参数的构造器，用于创建线程时指定name
	public PriorityTest(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0 ; i < 50 ; i++ )
		{
			System.out.println(getName() +  ",其优先级是："
				+ getPriority() + ",循环变量的值为:" + i);
		}
	}
	public static void main(String[] args)
	{
		// 改变主线程的优先级
		Thread.currentThread().setPriority(6);
		for (int i = 0 ; i < 30 ; i++ )
		{
			if (i == 10)
			{
				PriorityTest low  = new PriorityTest("低级");
				low.start();
				System.out.println("创建之初的优先级:"
					+ low.getPriority());
				// 设置该线程为最低优先级
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20)
			{
				PriorityTest high = new PriorityTest("高级");
				high.start();
				System.out.println("创建之初的优先级:"
					+ high.getPriority());
				// 设置该线程为最高优先级
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
