

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
public class GenderTest
{
	public static void main(String[] args)
	{
		Gender g = Gender.valueOf("FEMALE");
		g.setName("女");
		System.out.println(g + "代表:" + g.getName());
		// 此时设置name值时将会提示参数错误。
		g.setName("男");
		System.out.println(g + "代表:" + g.getName());
	}
}
