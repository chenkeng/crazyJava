
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
public class ClientThread extends Thread
{
	// 该客户端线程负责处理的输入流
	BufferedReader br = null;
	// 使用一个网络输入流来创建客户端线程
	public ClientThread(BufferedReader br)
	{
		this.br = br;
	}
	public void run()
	{
		try
		{
			String line = null;
			// 不断从输入流中读取数据，并将这些数据打印输出
			while((line = br.readLine())!= null)
			{
				System.out.println(line);
				/*
				本例仅打印了从服务器端读到的内容。实际上，此处的情况可以更复杂：
				如果希望客户端能看到聊天室的用户列表，则可以让服务器在
				每次有用户登录、用户退出时，将所有用户列表信息都向客户端发送一遍。
				为了区分服务器发送的是聊天信息，还是用户列表，服务器也应该
				在要发送的信息前、后都添加一定的协议字符串，客户端此处则根据协议
				字符串的不同而进行不同的处理！
				更复杂的情况：
				如果两端进行游戏，则还有可能发送游戏信息，例如两端进行五子棋游戏，
				则还需要发送下棋坐标信息等，服务器同样在这些下棋坐标信息前、后
				添加协议字符串后再发送，客户端就可以根据该信息知道对手的下棋坐标。
				*/
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		// 使用finally块来关闭该线程对应的输入流
		finally
		{
			try
			{
				if (br != null)
				{
					br.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
