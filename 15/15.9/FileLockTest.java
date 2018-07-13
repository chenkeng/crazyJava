
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
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
public class FileLockTest
{
	public static void main(String[] args)
		throws Exception
	{

		try(
			// 使用FileOutputStream获取FileChannel
			FileChannel channel = new FileOutputStream("a.txt")
				.getChannel())
		{
			// 使用非阻塞式方式对指定文件加锁
			FileLock lock = channel.tryLock();
			// 程序暂停10s
			Thread.sleep(10000);
			// 释放锁
			lock.release();
		}
	}
}
