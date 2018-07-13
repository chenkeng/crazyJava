
import java.net.*;
import java.io.*;
import javax.swing.*;
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
public class Client
{
	private static final int SERVER_PORT = 30000;
	private Socket socket;
	private PrintStream ps;
	private BufferedReader brServer;
	private BufferedReader keyIn;
	public void init()
	{
		try
		{
			// 初始化代表键盘的输入流
			keyIn = new BufferedReader(
				new InputStreamReader(System.in));
			// 连接到服务器
			socket = new Socket("127.0.0.1", SERVER_PORT);
			// 获取该Socket对应的输入流和输出流
			ps = new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
			String tip = "";
			// 采用循环不断地弹出对话框要求输入用户名
			while(true)
			{
				String userName = JOptionPane.showInputDialog(tip
					+ "输入用户名");    //①
				// 将用户输入的用户名的前后增加协议字符串后发送
				ps.println(CrazyitProtocol.USER_ROUND + userName
					+ CrazyitProtocol.USER_ROUND);
				// 读取服务器的响应
				String result = brServer.readLine();
				// 如果用户重复，开始下次循环
				if (result.equals(CrazyitProtocol.NAME_REP))
				{
					tip = "用户名重复！请重新";
					continue;
				}
				// 如果服务器返回登录成功，结束循环
				if (result.equals(CrazyitProtocol.LOGIN_SUCCESS))
				{
					break;
				}
			}
		}
		// 捕捉到异常，关闭网络资源，并退出该程序
		catch (UnknownHostException ex)
		{
			System.out.println("找不到远程服务器，请确定服务器已经启动！");
			closeRs();
			System.exit(1);
		}
		catch (IOException ex)
		{
			System.out.println("网络异常！请重新登录！");
			closeRs();
			System.exit(1);
		}
		// 以该Socket对应的输入流启动ClientThread线程
		new ClientThread(brServer).start();
	}
	// 定义一个读取键盘输出，并向网络发送的方法
	private void readAndSend()
	{
		try
		{
			// 不断读取键盘输入
			String line = null;
			while((line = keyIn.readLine()) != null)
			{
				// 如果发送的信息中有冒号，且以//开头，则认为想发送私聊信息
				if (line.indexOf(":") > 0 && line.startsWith("//"))
				{
					line = line.substring(2);
					ps.println(CrazyitProtocol.PRIVATE_ROUND +
					line.split(":")[0] + CrazyitProtocol.SPLIT_SIGN
						+ line.split(":")[1] + CrazyitProtocol.PRIVATE_ROUND);
				}
				else
				{
					ps.println(CrazyitProtocol.MSG_ROUND + line
						+ CrazyitProtocol.MSG_ROUND);
				}
			}
		}
		// 捕捉到异常，关闭网络资源，并退出该程序
		catch (IOException ex)
		{
			System.out.println("网络通信异常！请重新登录！");
			closeRs();
			System.exit(1);
		}
	}
	// 关闭Socket、输入流、输出流的方法
	private void closeRs()
	{
		try
		{
			if (keyIn != null)
			{
				ps.close();
			}
			if (brServer != null)
			{
				ps.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (socket != null)
			{
				keyIn.close();
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		Client client = new Client();
		client.init();
		client.readAndSend();
	}
}
