
import java.io.*;
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
public class SerializeMutable
{
	public static void main(String[] args)
	{

		try(
			// 创建一个ObjectOutputStream输入流
			ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("mutable.txt"));
			// 创建一个ObjectInputStream输入流
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("mutable.txt")))
		{
			Person per = new Person("孙悟空", 500);
			// 系统会per对象转换字节序列并输出
			oos.writeObject(per);
			// 改变per对象的name实例变量
			per.setName("猪八戒");
			// 系统只是输出序列化编号，所以改变后的name不会被序列化
			oos.writeObject(per);
			Person p1 = (Person)ois.readObject();    //①
			Person p2 = (Person)ois.readObject();    //②
			// 下面输出true，即反序列化后p1等于p2
			System.out.println(p1 == p2);
			// 下面依然看到输出"孙悟空"，即改变后的实例变量没有被序列化
			System.out.println(p2.getName());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}