
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
public class OverrideThrows
{
	public void test()throws IOException
	{
		FileInputStream fis = new FileInputStream("a.txt");
	}
}
class Sub extends OverrideThrows
{
	// 子类方法声明抛出了比父类方法更大的异常
	// 所以下面方法出错
	public void test()throws Exception
	{
	}
}

