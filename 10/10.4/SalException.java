

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
public class SalException extends Exception
{
	public SalException(){}
	public SalException(String msg)
	{
		super(msg);
	}
	// 创建一个可以接受Throwable参数的构造器
	public SalException(Throwable t)
	{
		super(t);
	}
}

