

/**
 * Description:
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class SeasonTest
{
	public SeasonTest(Season s)
	{
		System.out.println(s.getName() +
			"��������һ��"+ s.getDesc() + "�ļ���");
	}
	public static void main(String[] args)
	{
		// ֱ��ʹ��Season��FALL��������һ��Season����
		new SeasonTest(Season.FALL);
	}
}