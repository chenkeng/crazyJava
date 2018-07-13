

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
class MyTest
{
	static
	{
		System.out.println("静态初始化块...");
	}
	// 使用一个字符串直接量为static final的类变量赋值
	static final String compileConstant = "疯狂Java讲义";
}
public class CompileConstantTest
{
	public static void main(String[] args)
	{
		// 访问、输出MyTest中的compileConstant类变量
		System.out.println(MyTest.compileConstant);   // ①
	}
}
