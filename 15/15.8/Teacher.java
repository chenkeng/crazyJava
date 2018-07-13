

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
public class Teacher
	implements java.io.Serializable
{
	private String name;
	private Person student;
	public Teacher(String name , Person student)
	{
		this.name = name;
		this.student = student;
	}
	// 此处省略了name和student的setter和getter方法

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// student的setter和getter方法
	public void setStudent(Person student)
	{
		this.student = student;
	}
	public Person getStudent()
	{
		return this.student;
	}
}