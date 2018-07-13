
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
public class FilterTest
{
	public static void main(String[] args)
	{
		try(
			// 创建一个ObjectInputStream输入流
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("object.txt")))
		{
			ois.setObjectInputFilter((info) -> {
				System.out.println("===执行数据过滤===");
				ObjectInputFilter serialFilter = ObjectInputFilter.Config.getSerialFilter();
					if (serialFilter != null) {
						// 首先使用ObjectInputFilter执行默认的检查
						ObjectInputFilter.Status status = serialFilter.checkInput(info);
						// 如果默认检查的结果不是Status.UNDECIDED
						if (status != ObjectInputFilter.Status.UNDECIDED) {
							// 直接返回检查结果
							return status;
						}
					}
					// 如果要恢复的对象不是1个
					if(info.references() != 1)
					{
						// 不允许恢复对象
						return ObjectInputFilter.Status.REJECTED;
					}
					if (info.serialClass() != null &&
						// 如果恢复的不是Person类
						info.serialClass() != Person.class)
					{
						// 不允许恢复对象
						return ObjectInputFilter.Status.REJECTED;
					}
					return ObjectInputFilter.Status.UNDECIDED;
				});
			// 从输入流中读取一个Java对象，并将其强制类型转换为Person类
			Person p = (Person)ois.readObject();
			System.out.println("名字为：" + p.getName()
				+ "\n年龄为：" + p.getAge());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
