

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
public class DrawThread extends Thread
{
	// 模拟用户账户
	private Account account;
	// 当前取钱线程所希望取的钱数
	private double drawAmount;
	public DrawThread(String name , Account account
		, double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	// 当多条线程修改同一个共享数据时，将涉及数据安全问题。
	public void run()
	{
		// 使用account作为同步监视器，任何线程进入下面同步代码块之前，
		// 必须先获得对account账户的锁定——其他线程无法获得锁，也就无法修改它
		// 这种做法符合：“加锁 → 修改 → 释放锁”的逻辑
		synchronized (account)
		{
			// 账户余额大于取钱数目
			if (account.getBalance() >= drawAmount)
			{
				// 吐出钞票
				System.out.println(getName()
					+ "取钱成功！吐出钞票:" + drawAmount);
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				// 修改余额
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("\t余额为: " + account.getBalance());
			}
			else
			{
				System.out.println(getName() + "取钱失败！余额不足！");
			}
		}
		// 同步代码块结束，该线程释放同步锁
	}
}
