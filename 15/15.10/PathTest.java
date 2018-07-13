
import java.io.*;
import java.net.*;
import java.nio.file.*;
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
public class PathTest
{
	public static void main(String[] args)
		throws Exception
	{
		// 以当前路径来创建Path对象
		Path path = Paths.get(".");
		System.out.println("path里包含的路径数量："
			+ path.getNameCount());
		System.out.println("path的根路径：" + path.getRoot());
		// 获取path对应的绝对路径。
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);
		// 获取绝对路径的根路径
		System.out.println("absolutePath的根路径："
			+ absolutePath.getRoot());
		// 获取绝对路径所包含的路径数量
		System.out.println("absolutePath里包含的路径数量："
			+ absolutePath.getNameCount());
		System.out.println(absolutePath.getName(3));
		// 以多个String来构建Path对象
		Path path2 = Paths.get("g:" , "publish" , "codes");
		System.out.println(path2);
	}
}
