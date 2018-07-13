

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
public class DivTest
{
	public static void main(String[] args)
	{
		try
		{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("您输入的两个数相除的结果是：" + c );
		}
		catch (IndexOutOfBoundsException ie)
		{
			System.out.println("数组越界：运行程序时输入的参数个数不够");
		}
		catch (NumberFormatException ne)
		{
			System.out.println("数字格式异常：程序只能接受整数参数");
		}
		catch (ArithmeticException ae)
		{
			System.out.println("算术异常");
		}
		catch (Exception e)
		{
			System.out.println("未知异常");
		}
	}
}

