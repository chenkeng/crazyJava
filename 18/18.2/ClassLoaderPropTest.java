
import java.util.*;
import java.net.*;
import java.io.*;
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
public class ClassLoaderPropTest
{
	public static void main(String[] args)
		throws IOException
	{
		// 获取系统类加载器
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器：" + systemLoader);
		/*
		获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定
		如果操作系统没有指定CLASSPATH环境变量，默认以当前路径作为
		系统类加载器的加载路径
		*/
		Enumeration<URL> em1 = systemLoader.getResources("");
		while(em1.hasMoreElements())
		{
			System.out.println(em1.nextElement());
		}
		// 获取系统类加载器的父类加载器：得到扩展类加载器
		ClassLoader extensionLader = systemLoader.getParent();
		System.out.println("扩展类加载器：" + extensionLader);
		System.out.println("扩展类加载器的加载路径："
			+ System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent: "
			+ extensionLader.getParent());
	}
}

