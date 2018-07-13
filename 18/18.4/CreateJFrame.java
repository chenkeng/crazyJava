
import java.lang.reflect.*;
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
public class CreateJFrame
{
	public static void main(String[] args)
		throws Exception
	{
		// 获取JFrame对应的Class对象
		Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
		// 获取JFrame中带一个字符串参数的构造器
		Constructor ctor = jframeClazz
			.getConstructor(String.class);
		// 调用Constructor的newInstance方法创建对象
		Object obj = ctor.newInstance("测试窗口");
		// 输出JFrame对象
		System.out.println(obj);
	}
}
