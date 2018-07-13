

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
// 使用@Inheritable修饰的Base类
@Inheritable
class Base
{
}
// TestInheritable类只是继承了Base类，
// 并未直接使用@Inheritable Annotiation修饰
public class InheritableTest extends Base
{
	public static void main(String[] args)
	{
		// 打印TestInheritable类是否具有@Inheritable修饰
		System.out.println(InheritableTest.class
			.isAnnotationPresent(Inheritable.class));
	}
}

