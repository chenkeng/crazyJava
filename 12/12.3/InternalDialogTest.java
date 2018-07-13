
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
public class InternalDialogTest
{
	private JFrame jf = new JFrame("测试内部对话框");
	private JDesktopPane desktop = new JDesktopPane();
	private JButton internalBn = new JButton("内部窗口的对话框");
	private JButton deskBn = new JButton("虚拟桌面的对话框");
	// 定义一个内部窗口，该窗口可拖动，但不可最大化、最小化、关闭
	private JInternalFrame iframe = new JInternalFrame("内部窗口");
	public void init()
	{
		// 向内部窗口中添加组件
		iframe.add(new JScrollPane(new JTextArea(8, 40)));
		desktop.setPreferredSize(new Dimension(400, 300));
		// 把虚拟桌面添加到JFrame窗口中
		jf.add(desktop);
		// 设置内部窗口的大小、位置
		iframe.reshape(0 , 0 , 300 , 200);
		// 显示并选中内部窗口
		iframe.show();
		desktop.add(iframe);
		JPanel jp = new JPanel();
		deskBn.addActionListener(event ->
			// 弹出内部对话框，以虚拟桌面作为父组件
			JOptionPane.showInternalMessageDialog(desktop
				, "属于虚拟桌面的对话框"));
		internalBn.addActionListener(event ->
			// 弹出内部对话框，以内部窗口作为父组件
			JOptionPane.showInternalMessageDialog(iframe
				, "属于内部窗口的对话框"));
		jp.add(deskBn);
		jp.add(internalBn);
		jf.add(jp , BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new InternalDialogTest().init();
	}
}
