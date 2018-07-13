

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
interface Eatable
{
	void taste();
}
interface Flyable
{
	void fly(String weather);
}
interface Addable
{
	int add(int a , int b);
}
public class LambdaQs
{
	// 调用该方法需要Eatable对象
	public void eat(Eatable e)
	{
		System.out.println(e);
		e.taste();
	}
	// 调用该方法需要Flyable对象
	public void drive(Flyable f)
	{
		System.out.println("我正在驾驶：" + f);
		f.fly("【碧空如洗的晴日】");
	}
	// 调用该方法需要Addable对象
	public void test(Addable add)
	{
		System.out.println("5与3的和为：" + add.add(5, 3));
	}
	public static void main(String[] args)
	{
		LambdaQs lq = new LambdaQs();
		// Lambda表达式的代码块只有一条语句，可以省略花括号。
		lq.eat(()-> System.out.println("苹果的味道不错！"));
		// Lambda表达式的形参列表只有一个形参，省略圆括号
		lq.drive(weather ->
		{
			System.out.println("今天天气是：" + weather);
			System.out.println("直升机飞行平稳");
		});
		// Lambda表达式的代码块只有一条语句，省略花括号
		// 代码块中只有一条语句，即使该表达式需要返回值，也可以省略return关键字。
		lq.test((a , b)->a + b);
	}
}
