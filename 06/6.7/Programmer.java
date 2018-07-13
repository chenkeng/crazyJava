

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
interface Teachable
{
	void work();
}
public class Programmer
{
	private String name;
	//Programmer类的两个构造器
	public Programmer(){}
	public Programmer(String name)
	{
		this.name = name;
	}
	//此处省略了name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void work()
	{
		System.out.println(name + "在灯下认真敲键盘...");
	}
}