

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
public class ThrowTest
{
	public static void main(String[] args)
	{
		try
		{
			// 调用声明抛出Checked异常的方法，要么显式捕获该异常
			// 要么在main方法中再次声明抛出
			throwChecked(-3);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		// 调用声明抛出Runtime异常的方法既可以显式捕获该异常，
		// 也可不理会该异常
		throwRuntime(3);
	}
	public static void throwChecked(int a)throws Exception
	{
		if (a > 0)
		{
			// 自行抛出Exception异常
			// 该代码必须处于try块里，或处于带throws声明的方法中
			throw new Exception("a的值大于0，不符合要求");
		}
	}
	public static void throwRuntime(int a)
	{
		if (a > 0)
		{
			// 自行抛出RuntimeException异常，既可以显式捕获该异常
			// 也可完全不理会该异常，把该异常交给该方法调用者处理
			throw new RuntimeException("a的值大于0，不符合要求");
		}
	}
}

