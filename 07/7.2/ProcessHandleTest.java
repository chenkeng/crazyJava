
import java.util.concurrent.*;
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
public class ProcessHandleTest
{
	public static void main(String[] args)
		throws Exception
	{
		Runtime rt = Runtime.getRuntime();
		// 运行记事本程序
		Process p = rt.exec("notepad.exe");
		ProcessHandle ph = p.toHandle();
		System.out.println("进程是否运行: " + ph.isAlive());
		System.out.println("进程ID: " + ph.pid());
		System.out.println("父进程: " + ph.parent());
		// 获取ProcessHandle.Info信息
		ProcessHandle.Info info = ph.info();
		// 通过ProcessHandle.Info信息获取进程相关信息
		System.out.println("进程命令: " + info.command());
		System.out.println("进程参数: " + info.arguments());
		System.out.println("进程启动时间: " + info.startInstant());
		System.out.println("进程累计运行时间: " + info.totalCpuDuration());
		// 通过CompletableFuture在进程结束时运行某个任务
		CompletableFuture<ProcessHandle> cf = ph.onExit();
		cf.thenRunAsync(()->{
			System.out.println("程序退出");
		});
		Thread.sleep(5000);
	}
}
