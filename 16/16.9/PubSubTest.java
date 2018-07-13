
import java.util.concurrent.Flow.*;
import java.util.*;
import java.util.concurrent.*;
/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0
 */
public class PubSubTest
{
	public static void main(String[] args)
	{
		// 创建一个SubmissionPublisher作为发布者
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
		// 创建订阅者
		MySubscriber<String> subscriber = new MySubscriber<>();
		// 注册订阅者
		publisher.subscribe(subscriber);
		// 发布几个数据项
		System.out.println("开发发布数据...");
		List.of("Java", "Kotlin", "Go", "Erlang", "Swift", "Lua")
			.forEach(im -> {
			// 提交数据
			publisher.submit(im);
			try
			{
				Thread.sleep(500);
			}
			catch (Exception ex){}
		});
		// 发布结束
		publisher.close();
		// 发布结束后，为了让发布者线程不会死亡，暂停线程
		synchronized("fkjava")
		{
			try
			{
				"fkjava".wait();
			}
			catch (Exception ex){}
		}
	}
}
// 创建订阅者
class MySubscriber<T> implements Subscriber<T>
{
	// 发布者与订阅者之间的纽带
	private Subscription subscription;
	@Override  // 订阅时触发该方法
	public void onSubscribe(Subscription subscription)
	{
		this.subscription = subscription;
		// 开始请求数据
		subscription.request(1);
	}
	@Override  // 接收到数据时触发该方法
	public void onNext(T item)
	{
		System.out.println("获取到数据: " + item);
		// 请求下一条数据
		subscription.request(1);
	}
	@Override // 订阅出错时触发该方法
	public void onError(Throwable t)
	{
		t.printStackTrace();
		synchronized("fkjava")
		{
			"fkjava".notifyAll();
		}
	}
	@Override  // 订阅结束时触发该方法
	public void onComplete()
	{
		System.out.println("订阅结束");
		synchronized("fkjava")
		{
			"fkjava".notifyAll();
		}
	}
}