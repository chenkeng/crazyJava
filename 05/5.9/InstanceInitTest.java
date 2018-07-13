

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
public class InstanceInitTest
{
	// 先执行初始化块将a实例变量赋值为6
	{
		a = 6;
	}
	// 再执行将a实例变量赋值为9
	int a = 9;
	public static void main(String[] args)
	{
		// 下面代码将输出9。
		System.out.println(new InstanceInitTest().a);
	}
}
