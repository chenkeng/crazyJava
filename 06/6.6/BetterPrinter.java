
import lee.Output;
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
public class BetterPrinter implements Output
{
	private String[] printData
		= new String[MAX_CACHE_LINE * 2];
	// 用以记录当前需打印的作业数
	private int dataNum = 0;
	public void out()
	{
		// 只要还有作业，继续打印
		while(dataNum > 0)
		{
			System.out.println("高速打印机正在打印：" + printData[0]);
			// 把作业队列整体前移一位，并将剩下的作业数减1
			System.arraycopy(printData , 1, printData, 0, --dataNum);
		}
	}
	public void getData(String msg)
	{
		if (dataNum >= MAX_CACHE_LINE * 2)
		{
			System.out.println("输出队列已满，添加失败");
		}
		else
		{
			// 把打印数据添加到队列里，已保存数据的数量加1。
			printData[dataNum++] = msg;
		}
	}
}
