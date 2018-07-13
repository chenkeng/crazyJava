
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
public class Gobang
{
	// 定义棋盘的大小
	private static int BOARD_SIZE = 15;
	// 定义一个二维数组来充当棋盘
	private String[][] board;
	public void initBoard()
	{
		// 初始化棋盘数组
		board = new String[BOARD_SIZE][BOARD_SIZE];
		// 把每个元素赋为"╋"，用于在控制台画出棋盘
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				board[i][j] = "╋";
			}
		}
	}
	// 在控制台输出棋盘的方法
	public void printBoard()
	{
		// 打印每个数组元素
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				// 打印数组元素后不换行
				System.out.print(board[i][j]);
			}
			// 每打印完一行数组元素后输出一个换行符
			System.out.print("\n");
		}
	}
    public static void main(String[] args) throws Exception
    {
        Gobang gb = new Gobang();
		gb.initBoard();
		gb.printBoard();
		// 这是用于获取键盘输入的方法
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine()：每当在键盘上输入一行内容按回车，用户刚输入的内容将被br读取到。
		while ((inputStr = br.readLine()) != null)
		{
			// 将用户输入的字符串以逗号（,）作为分隔符，分隔成2个字符串
			String[] posStrArr = inputStr.split(",");
			// 将2个字符串转换成用户下棋的座标
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			// 把对应的数组元素赋为"●"。
			gb.board[yPos - 1][xPos - 1] = "●";
			/*
			 电脑随机生成2个整数，作为电脑下棋的座标，赋给board数组。
			 还涉及
				1.座标的有效性，只能是数字，不能超出棋盘范围
				2.如果下的棋的点，不能重复下棋。
				3.每次下棋后，需要扫描谁赢了
			 */
			gb.printBoard();
			System.out.println("请输入您下棋的座标，应以x,y的格式：");
		}
    }
}
