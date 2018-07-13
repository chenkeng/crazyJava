
import java.util.LinkedList;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import javax.swing.event.*;
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
public class MonitorText
{
	JFrame mainWin = new JFrame("监听Document对象");
	JTextArea target = new JTextArea(4, 35);
	JTextArea msg = new JTextArea(5, 35);
	JLabel label = new JLabel("文本域的修改信息");
	Document doc = target.getDocument();
	// 保存撤销操作的List对象
	LinkedList<UndoableEdit> undoList = new LinkedList<>();
	// 最多允许撤销多少次
	final int UNDO_COUNT = 20;
	public void init()
	{
		msg.setEditable(false);
		// 添加DocumentListener
		doc.addDocumentListener(new DocumentListener()
		{
			// 当Document的属性或属性集发生了改变时触发该方法
			public void changedUpdate(DocumentEvent e){}
			// 当向Document中插入文本时触发该方法
			public void insertUpdate(DocumentEvent e)
			{
				int offset = e.getOffset();
				int len = e.getLength();
				// 取得插入事件的位置
				msg.append("插入文本的长度：" + len + "\n");
				msg.append("插入文本的起始位置：" + offset + "\n");
				try
				{
					msg.append("插入文本内容："
						+ doc.getText(offset, len) + "\n");
				}
				catch (BadLocationException evt)
				{
					evt.printStackTrace();
				}
			}
			// 当从Document中删除文本时触发该方法
			public void removeUpdate(DocumentEvent e)
			{
				int offset = e.getOffset();
				int len = e.getLength();
				// 取得插入事件的位置
				msg.append("删除文本的长度：" + len + "\n");
				msg.append("删除文本的起始位置：" + offset + "\n");
			}
		});
		// 添加可撤销操作的监听器
		doc.addUndoableEditListener(e -> {
			// 每次发生可撤销操作都会触发该代码块      // ①
			UndoableEdit edit = e.getEdit();
			if (edit.canUndo() && undoList.size() < UNDO_COUNT)
			{
				// 将撤销操作装入List内
				undoList.add(edit);
			}
			// 已经达到了最大撤销次数
			else if (edit.canUndo() && undoList.size() >= UNDO_COUNT)
			{
				// 弹出第一个撤销操作
				undoList.pop();
				// 将撤销操作装入List内
				undoList.add(edit);
			}
		});
		// 为Ctrl+Z添加监听器
		target.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)    // ②
			{
				System.out.println(e.getKeyChar() + 0);
				// 如果按键是Ctrl + Z或Ctrl + z
				if (e.getKeyChar() == 26)
				{
					if (undoList.size() > 0)
					{
						// 移出最后一个可撤销操作，并取消该操作
						undoList.removeLast().undo();
					}
				}
			}
		});
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(new JScrollPane(target));
		JPanel panel = new JPanel();
		panel.add(label);
		box.add(panel);
		box.add(new JScrollPane(msg));
		mainWin.add(box);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	public static void main(String[] args) throws Exception
	{
		new MonitorText().init();
	}
}
