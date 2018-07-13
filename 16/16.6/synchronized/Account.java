

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
public class Account
{
	// 封装账户编号、账户余额的两个成员变量
	private String accountNo;
	private double balance;
	// 标识账户中是否已有存款的旗标
	private boolean flag = false;

	public Account(){}
	// 构造器
	public Account(String accountNo , double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	// accountNo的setter和getter方法
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getAccountNo()
	{
		return this.accountNo;
	}
	// 因此账户余额不允许随便修改，所以只为balance提供getter方法，
	public double getBalance()
	{
		return this.balance;
	}

	public synchronized void draw(double drawAmount)
	{
		try
		{
			// 如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
			if (!flag)
			{
				wait();
			}
			else
			{
				// 执行取钱
				System.out.println(Thread.currentThread().getName()
					+ " 取钱:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				// 将标识账户是否已有存款的旗标设为false。
				flag = false;
				// 唤醒其他线程
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount)
	{
		try
		{
			// 如果flag为真，表明账户中已有人存钱进去，则存钱方法阻塞
			if (flag)             //①
			{
				wait();
			}
			else
			{
				// 执行存款
				System.out.println(Thread.currentThread().getName()
					+ " 存款:" +  depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为：" + balance);
				// 将表示账户是否已有存款的旗标设为true
				flag = true;
				// 唤醒其他线程
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}

	// 下面两个方法根据accountNo来重写hashCode()和equals()方法
	public int hashCode()
	{
		return accountNo.hashCode();
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if (obj !=null
			&& obj.getClass() == Account.class)
		{
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}