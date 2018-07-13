
import java.util.concurrent.*;
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

// 继承RecursiveTask来实现"可分解"的任务
class CalTask extends RecursiveTask<Integer>
{
	// 每个“小任务”只最多只累加20个数
	private static final int THRESHOLD = 20;
	private int arr[];
	private int start;
	private int end;
	// 累加从start到end的数组元素
	public CalTask(int[] arr , int start, int end)
	{
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	@Override
	protected Integer compute()
	{
		int sum = 0;
		// 当end与start之间的差小于THRESHOLD时，开始进行实际累加
		if(end - start < THRESHOLD)
		{
			for (int i = start ; i < end ; i++ )
			{
				sum += arr[i];
			}
			return sum;
		}
		else
		{
			// 如果当end与start之间的差大于THRESHOLD时，即要累加的数超过20个时
			// 将大任务分解成两个小任务。
			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr , start, middle);
			CalTask right = new CalTask(arr , middle, end);
			// 并行执行两个“小任务”
			left.fork();
			right.fork();
			// 把两个“小任务”累加的结果合并起来
			return left.join() + right.join();    // ①
		}
	}
}
public class Sum
{
	public static void main(String[] args)
		throws Exception
	{
		int[] arr = new int[100];
		Random rand = new Random();
		int total = 0;
		// 初始化100个数字元素
		for (int i = 0 , len = arr.length; i < len ; i++ )
		{
			int tmp = rand.nextInt(20);
			// 对数组元素赋值，并将数组元素的值添加到sum总和中。
			total += (arr[i] = tmp);
		}
		System.out.println(total);
		// 创建一个通用池
		ForkJoinPool pool = ForkJoinPool.commonPool();
		// 提交可分解的CalTask任务
		Future<Integer> future = pool.submit(new CalTask(arr , 0 , arr.length));
		System.out.println(future.get());
		// 关闭线程池
		pool.shutdown();
	}
}

