

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
public class ReturnThis
{
	public int age;
	public ReturnThis grow()
	{
		age++;
		// return this返回调用该方法的对象
		return this;
	}
	public static void main(String[] args)
	{
		ReturnThis rt = new ReturnThis();
		// 可以连续调用同一个方法
		rt.grow()
			.grow()
			.grow();
		System.out.println("rt的age成员变量值是:" + rt.age);
	}
}

