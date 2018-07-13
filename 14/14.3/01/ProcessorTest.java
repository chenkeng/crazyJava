
import java.lang.reflect.*;
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
public class ProcessorTest
{
	public static void process(String clazz)
		throws ClassNotFoundException
	{
		int passed = 0;
		int failed = 0;
		// 遍历clazz对应的类里的所有方法
		for (Method m : Class.forName(clazz).getMethods())
		{
			// 如果该方法使用了@Testable修饰
			if (m.isAnnotationPresent(Testable.class))
			{
				try
				{
					// 调用m方法
					m.invoke(null);
					// 测试成功，passed计数器加1
					passed++;
				}
				catch (Exception ex)
				{
					System.out.println("方法" + m + "运行失败，异常："
						+ ex.getCause());
					// 测试出现异常，failed计数器加1
					failed++;
				}
			}
		}
		// 统计测试结果
		System.out.println("共运行了:" + (passed + failed)
			+ "个方法，其中：\n" + "失败了:" + failed + "个，\n"
			+ "成功了:" + passed + "个！");
	}
}

