
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
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
public class JEditorPaneTest
{
	JFrame mainWin = new JFrame("测试JEditorPane");
	LinkedList<String> urls = new LinkedList<String>();
	JEditorPane editorPane = new JEditorPane();
	JTextField url = new JTextField(30);
	JCheckBox editable = new JCheckBox();
	JButton backButton = new JButton("后退");

	public void init()
	{
		// 默认设置不允许编辑
		editorPane.setEditable(false);
		editorPane.addHyperlinkListener(event -> {
			if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
			{
				try
				{
					// 将用户浏览过的URL
					urls.push(event.getURL().toString());
					// 在文本框内输入URL字符串
					url.setText(event.getURL().toString());
					// 让JEditorPane装载新的页面
					editorPane.setPage(event.getURL());
				}
				catch (IOException e)
				{
					editorPane.setText("出现异常: " + e);
				}
			}
		});

		// 为可编辑的复选框添加事件监听器。
		// 如果该复选框处于选中状态，则该编辑器可编辑
		editable.addActionListener(event ->
			editorPane.setEditable(editable.isSelected()));

		// 加载URL指定页面的监听器
		ActionListener listener = event -> {
			try
			{
				// 将用户浏览后的URL添加到URL栈中
				urls.push(url.getText());
				editorPane.setPage(url.getText());
			}
			catch (IOException e)
			{
				editorPane.setText("页面: " + e);
			}
		};

		JButton loadButton = new JButton("载入");
		loadButton.addActionListener(listener);
		url.addActionListener(listener);

		// 为后退按钮添加监听器
		backButton.addActionListener(event -> {
			// 如果还没有已经浏览过的URL
			if (urls.size() <= 1) return;
			try
			{
				// 取出、并获取最后一个URL
				String urlString = urls.pop();
				url.setText(urlString);
				// 重新加载新的URL
				editorPane.setPage(urlString);
			}
			catch (IOException e)
			{
				editorPane.setText("出现异常: " + e);
			}
		});

		mainWin.add(new JScrollPane(editorPane), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.add(new JLabel("输入网址："));
		panel.add(url);
		panel.add(loadButton);
		panel.add(backButton);
		panel.add(new JLabel("是否可编辑"));
		panel.add(editable);

		mainWin.add(panel, BorderLayout.NORTH);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
   }

	public static void main(String[] args)
	{
		new JEditorPaneTest().init();
	}
}


