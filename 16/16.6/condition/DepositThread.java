

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
public class DepositThread extends Thread
{
	// 模拟用户账户
	private Account account;
	// 当前取钱线程所希望存款的钱数
	private double depositAmount;
	public DepositThread(String name , Account account
		, double depositAmount)
	{
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}
	// 重复100次执行存款操作
	public void run()
	{
		for (int i = 0 ; i < 100 ; i++ )
		{
			account.deposit(depositAmount);
		}
	}
}
