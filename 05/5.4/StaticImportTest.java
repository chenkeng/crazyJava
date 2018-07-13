
import static java.lang.System.*;
import static java.lang.Math.*;
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

public class StaticImportTest
{
	public static void main(String[] args)
	{
		// out是java.lang.System类的静态成员变量，代表标准输出
		// PI是java.lang.Math类的静态成员变量，表示π常量
		out.println(PI);
		// 直接调用Math类的sqrt静态方法
		out.println(sqrt(256));
	}
}
