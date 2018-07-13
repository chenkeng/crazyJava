
import java.util.List;
import java.io.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.awt.dnd.*;
import javax.imageio.*;
import java.awt.datatransfer.*;
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
public class DropTargetTest
{
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGHT = 360;
	final int FRAME_DISTANCE = 30;
	JFrame jf = new JFrame("测试拖放目标——把图片文件拖入该窗口");
	// 定义一个虚拟桌面
	private JDesktopPane desktop = new JDesktopPane();
	// 保存下一个内部窗口的坐标点
	private int nextFrameX;
	private int nextFrameY;
	// 定义内部窗口为虚拟桌面的1/2大小
	private int width = DESKTOP_WIDTH / 2;
	private int height = DESKTOP_HEIGHT / 2;
	public void init()
	{
		desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH
			, DESKTOP_HEIGHT));
		// 将当前窗口创建成拖放目标
		new DropTarget(jf, DnDConstants.ACTION_COPY
			, new ImageDropTargetListener());
		jf.add(desktop);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	class ImageDropTargetListener extends DropTargetAdapter
	{
		public void drop(DropTargetDropEvent event)
		{
			// 接受复制操作
			event.acceptDrop(DnDConstants.ACTION_COPY);
			// 获取拖放的内容
			Transferable transferable = event.getTransferable();
			DataFlavor[] flavors = transferable.getTransferDataFlavors();
			// 遍历拖放内容里的所有数据格式
			for (int i = 0; i < flavors.length; i++)
			{
				DataFlavor d = flavors[i];
				try
				{
					// 如果拖放内容的数据格式是文件列表
					if (d.equals(DataFlavor.javaFileListFlavor))
					{
						// 取出拖放操作里的文件列表
						List fileList = (List)transferable
							.getTransferData(d);
						for (Object f : fileList)
						{
							// 显示每个文件
							showImage((File)f , event);
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				// 强制拖放操作结束，停止阻塞拖放目标
				event.dropComplete(true);    // ①
			}
		}
		// 显示每个文件的工具方法
		private void showImage(File f , DropTargetDropEvent event)
			throws IOException
		{
			Image image = ImageIO.read(f);
			if (image == null)
			{
				// 强制拖放操作结束，停止阻塞拖放目标
				event.dropComplete(true);     // ②
				JOptionPane.showInternalMessageDialog(desktop
					, "系统不支持这种类型的文件");
				// 方法返回，不会继续操作
				return;
			}
			ImageIcon icon = new ImageIcon(image);
			// 创建内部窗口显示该图片
			JInternalFrame iframe = new JInternalFrame(f.getName()
				, true , true , true , true);
			JLabel imageLabel = new JLabel(icon);
			iframe.add(new JScrollPane(imageLabel));
			desktop.add(iframe);
			// 设置内部窗口的原始位置（内部窗口默认大小是0X0，放在0,0位置）
			iframe.reshape(nextFrameX, nextFrameY, width, height);
			// 使该窗口可见，并尝试选中它
			iframe.show();
			// 计算下一个内部窗口的位置
			nextFrameX += FRAME_DISTANCE;
			nextFrameY += FRAME_DISTANCE;
			if (nextFrameX + width > desktop.getWidth())
				nextFrameX = 0;
			if (nextFrameY + height > desktop.getHeight())
				nextFrameY = 0;
		}
	}
	public static void main(String[] args)
	{
		new DropTargetTest().init();
	}
}
