

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
class Creature
{
	public Creature()
	{
		System.out.println("Creature无参数的构造器");
	}
}
class Animal extends Creature
{
	public Animal(String name)
	{
		System.out.println("Animal带一个参数的构造器，"
			+ "该动物的name为" + name);
	}
	public Animal(String name , int age)
	{
		// 使用this调用同一个重载的构造器
		this(name);
		System.out.println("Animal带两个参数的构造器，"
			+ "其age为" + age);
	}
}
public class Wolf extends Animal
{
	public Wolf()
	{
		// 显式调用父类有两个参数的构造器
		super("灰太狼", 3);
		System.out.println("Wolf无参数的构造器");
	}
	public static void main(String[] args)
	{
		new Wolf();
	}
}

