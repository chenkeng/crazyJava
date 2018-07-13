

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
public class IfErrorTest
{
	public static void main(String[] args)
	{
		int age = 45;
		if (age > 20)
		{
			System.out.println("青年人");
		}
		else if (age > 40)
		{
			System.out.println("中年人");
		}
		else if (age > 60)
		{
			System.out.println("老年人");
		}
	}
}
