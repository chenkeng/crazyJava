
import java.awt.*;
import java.awt.dnd.*;
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
public class DragSourceTest
{
	JFrame jf = new JFrame("Swing的拖放支持");
	JLabel srcLabel = new JLabel("Swing的拖放支持.\n"
		+"将该文本域的内容拖入其他程序.\n");
	public void init()
	{
		DragSource dragSource = DragSource.getDefaultDragSource();
		// 将srcLabel转换成拖放源，它能接受复制、移动两种操作
		dragSource.createDefaultDragGestureRecognizer(srcLabel
			, DnDConstants.ACTION_COPY_OR_MOVE
			, event -> {
			// 将JLabel里的文本信息包装成Transferable对象
			String txt = srcLabel.getText();
			Transferable transferable = new StringSelection(txt);
			// 继续拖放操作,拖放过程中使用手状光标
			event.startDrag(Cursor.getPredefinedCursor(Cursor
				.HAND_CURSOR), transferable);
		});
		jf.add(new JScrollPane(srcLabel));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DragSourceTest().init();
	}
}
