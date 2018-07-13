

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
		// 直接调用account对象的draw方法来执行取钱
		// 同步方法的同步监视器是this，this代表调用draw()方法的对象。
		// 也就是说：线程进入draw()方法之前，必须先对account对象的加锁。
		account.draw(drawAmount);
	}
}
