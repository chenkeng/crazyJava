
import java.beans.*;

import java.awt.*;
import java.awt.event.*;
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
public class JInternalFrameTest
{
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGHT = 360;
	final int FRAME_DISTANCE = 30;
	JFrame jf = new JFrame("MDI界面");
	// 定义一个虚拟桌面
	private MyJDesktopPane desktop = new MyJDesktopPane();
	// 保存下一个内部窗口的坐标点
	private int nextFrameX;
	private int nextFrameY;
	// 定义内部窗口为虚拟桌面的1/2大小
	private int width = DESKTOP_WIDTH / 2;
	private int height = DESKTOP_HEIGHT / 2;
	// 为主窗口定义两个菜单
	JMenu fileMenu = new JMenu("文件");
	JMenu windowMenu = new JMenu("窗口");
	// 定义newAction用于创建菜单和工具按钮
	Action newAction = new AbstractAction("新建"
		, new ImageIcon("ico/new.png"))
	{
		public void actionPerformed(ActionEvent event)
		{
			// 创建内部窗口
			final JInternalFrame iframe = new JInternalFrame("新文档",
				true, // 可改变大小
				true, // 可关闭
				true, // 可最大化
				true); // 可最小化
			iframe.add(new JScrollPane(new JTextArea(8, 40)));
			// 将内部窗口添加到虚拟桌面中
			desktop.add(iframe);
			// 设置内部窗口的原始位置（内部窗口默认大小是0X0，放在0,0位置）
			iframe.reshape(nextFrameX, nextFrameY, width, height);
			// 使该窗口可见，并尝试选中它
			iframe.show();
			// 计算下一个内部窗口的位置
			nextFrameX += FRAME_DISTANCE;
			nextFrameY += FRAME_DISTANCE;
			if (nextFrameX + width > desktop.getWidth()) nextFrameX = 0;
			if (nextFrameY + height > desktop.getHeight()) nextFrameY = 0;
		}
	};
	// 定义exitAction用于创建菜单和工具按钮
	Action exitAction = new AbstractAction("退出"
		, new ImageIcon("ico/exit.png"))
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	};
	public void init()
	{
		// 为窗口安装菜单条和工具条
		JMenuBar menuBar = new JMenuBar();
		JToolBar toolBar = new JToolBar();
		jf.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newAction);
		fileMenu.add(exitAction);
		toolBar.add(newAction);
		toolBar.add(exitAction);
		menuBar.add(windowMenu);
		JMenuItem nextItem = new JMenuItem("下一个");
		nextItem.addActionListener(event -> desktop.selectNextWindow());
		windowMenu.add(nextItem);
		JMenuItem cascadeItem = new JMenuItem("级联");
		cascadeItem.addActionListener(event ->
			// 级联显示窗口，内部窗口的大小是外部窗口的0.75
			desktop.cascadeWindows(FRAME_DISTANCE , 0.75));
		windowMenu.add(cascadeItem);
		JMenuItem tileItem = new JMenuItem("平铺");
		// 平铺显示所有内部窗口
		tileItem.addActionListener(event -> desktop.tileWindows());
		windowMenu.add(tileItem);
		final JCheckBoxMenuItem dragOutlineItem = new
			JCheckBoxMenuItem("仅显示拖动窗口的轮廓");
		dragOutlineItem.addActionListener(event ->
			// 根据该菜单项是否选择来决定采用哪种拖动模式
			desktop.setDragMode(dragOutlineItem.isSelected()
				? JDesktopPane.OUTLINE_DRAG_MODE
				: JDesktopPane.LIVE_DRAG_MODE));    // ①
		windowMenu.add(dragOutlineItem);
		desktop.setPreferredSize(new Dimension(480, 360));
		// 将虚拟桌面添加到顶级JFrame容器中
		jf.add(desktop);
		jf.add(toolBar , BorderLayout.NORTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JInternalFrameTest().init();
	}
}
class MyJDesktopPane extends JDesktopPane
{
	// 将所有窗口以级联方式显示,
	// 其中offset是两个窗口的位移距离, s
	// cale是内部窗口与JDesktopPane的大小比例
	public void cascadeWindows(int offset , double scale)
	{
		// 定义级联显示窗口时内部窗口的大小
		int width = (int)(getWidth() * scale);
		int height = (int)(getHeight() * scale);
		// 用于保存级联窗口时每个窗口的位置
		int x = 0;
		int y = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			try
			{
				// 取消内部窗口的最大化,最小化
				frame.setMaximum(false);
				frame.setIcon(false);
				// 把窗口重新放置在指定位置
				frame.reshape(x, y, width, height);
				x += offset;
				y += offset;
				// 如果到了虚拟桌面边界
				if (x + width > getWidth()) x = 0;
				if (y + height > getHeight()) y = 0;
			}
			catch (PropertyVetoException e)
			{}
		}
	}
	// 将所有窗口以平铺方式显示
	public void tileWindows()
	{
		// 统计所有窗口
		int frameCount = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			frameCount++;
		}
		// 计算需要多少行、多少列才可以平铺所有窗口
		int rows = (int) Math.sqrt(frameCount);
		int cols = frameCount / rows;
		// 需要额外增加到其他列中的窗口
		int extra = frameCount % rows;
		// 计算平铺时内部窗口的大小
		int width = getWidth() / cols;
		int height = getHeight() / rows;
		// 用于保存平铺窗口时每个窗口在横向、纵向上的索引
		int x = 0;
		int y = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			try
			{
				// 取消内部窗口的最大化,最小化
				frame.setMaximum(false);
				frame.setIcon(false);
				// 将窗口放在指定位置
				frame.reshape(x * width, y * height, width, height);
				y++;
				// 每排完一列窗口
				if (y == rows)
				{
					// 开始排放下一列窗口
					y = 0;
					x++;
					// 如果额外多出的窗口与剩下的列数相等，
					// 则后面所有列都需要多排列一个窗口
					if (extra == cols - x)
					{
						rows++;
						height = getHeight() / rows;
					}
				}
			}
			catch (PropertyVetoException e)
			{}
		}
	}
	// 选中下一个非图标窗口
	public void selectNextWindow()
	{
		JInternalFrame[] frames = getAllFrames();
		for (int i = 0; i < frames.length; i++)
		{
			if (frames[i].isSelected())
			{
				//  找出下一个非最小化的窗口，尝试选中它，
				// 如果选中失败，则继续尝试选中下一个窗口
				int next = (i + 1) % frames.length;
				while (next != i)
				{
					// 如果该窗口不是处于最小化状态
					if (!frames[next].isIcon())
					{
						try
						{
							frames[next].setSelected(true);
							frames[next].toFront();
							frames[i].toBack();
							return;
						}
						catch (PropertyVetoException e)
						{}
					}
					next = (next + 1) % frames.length;
				}
			}
		}
	}
}