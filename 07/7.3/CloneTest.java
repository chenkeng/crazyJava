

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

class Address
{
	String detail;
	public Address(String detail)
	{
		this.detail = detail;
	}
}
// 实现Cloneable接口
class User implements Cloneable
{
	int age;
	Address address;
	public User(int age)
	{
		this.age = age;
		address = new Address("广州天河");
	}
	// 通过调用super.clone()来实现clone()方法
	public User clone()
		throws CloneNotSupportedException
	{
		return (User)super.clone();
	}
}
public class CloneTest
{
	public static void main(String[] args)
		throws CloneNotSupportedException
	{
		User u1 = new User(29);
		// clone得到u1对象的副本。
		User u2 = u1.clone();
		// 判断u1、u2是否相同
		System.out.println(u1 == u2);      //①
		// 判断u1、u2的address是否相同
		System.out.println(u1.address == u2.address);     //②
	}
}
