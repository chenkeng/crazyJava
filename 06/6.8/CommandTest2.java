

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
public class CommandTest2
{
	public static void main(String[] args)
	{
		ProcessArray pa = new ProcessArray();
		int[] array = {3, -4, 6, 4};
		// 处理数组，具体处理行为取决于匿名内部类
		pa.process(array , (int[] target)->{
				int sum = 0;
				for (int tmp : target )
				{
					sum += tmp;
				}
				System.out.println("数组元素的总和是:" + sum);
			});
	}
}

