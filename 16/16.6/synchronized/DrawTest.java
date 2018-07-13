

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
public class DrawTest
{
	public static void main(String[] args)
	{
		// 创建一个账户
		Account acct = new Account("1234567" , 0);
		new DrawThread("取钱者" , acct , 800).start();
		new DepositThread("存款者甲" , acct , 800).start();
		new DepositThread("存款者乙" , acct , 800).start();
		new DepositThread("存款者丙" , acct , 800).start();
	}
}
