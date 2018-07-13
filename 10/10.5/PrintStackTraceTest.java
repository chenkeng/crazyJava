

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
class SelfException extends RuntimeException
{
	SelfException(){}
	SelfException(String msg)
	{
		super(msg);
	}
}
public class PrintStackTraceTest
{
	public static void main(String[] args)
	{
		firstMethod();
	}
	public static void firstMethod()
	{
		secondMethod();
	}
	public static void secondMethod()
	{
		thirdMethod();
	}
	public static void thirdMethod()
	{
		throw new SelfException("自定义异常信息");
	}
}
