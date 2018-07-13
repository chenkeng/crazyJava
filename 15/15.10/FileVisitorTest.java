
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
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
public class FileVisitorTest
{
	public static void main(String[] args)
		throws Exception
	{
		// 遍历g:\publish\codes\15目录下的所有文件和子目录
		Files.walkFileTree(Paths.get("g:", "publish" , "codes" , "15")
			, new SimpleFileVisitor<Path>()
		{
			// 访问文件时候触发该方法
			@Override
			public FileVisitResult visitFile(Path file
				, BasicFileAttributes attrs) throws IOException
			{
				System.out.println("正在访问" + file + "文件");
				// 找到了FileInputStreamTest.java文件
				if (file.endsWith("FileInputStreamTest.java"))
				{
					System.out.println("--已经找到目标文件--");
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
			// 开始访问目录时触发该方法
			@Override
			public FileVisitResult preVisitDirectory(Path dir
				, BasicFileAttributes attrs) throws IOException
			{
				System.out.println("正在访问：" + dir + " 路径");
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
