
import java.util.*;
import java.io.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
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
public class MyTextPane extends JTextPane
{
	protected StyledDocument doc;
	protected SyntaxFormatter formatter = new SyntaxFormatter("my.stx");
	// 定义该文档的普通文本的外观属性
	private SimpleAttributeSet normalAttr =
		formatter.getNormalAttributeSet();
	private SimpleAttributeSet quotAttr = new SimpleAttributeSet();
	// 保存文档改变的开始位置
	private int docChangeStart = 0;
	// 保存文档改变的长度
	private int docChangeLength = 0;
	public MyTextPane()
	{
		StyleConstants.setForeground(quotAttr
			, new Color(255, 0 , 255));
		StyleConstants.setFontSize(quotAttr, 16);
		this.doc = super.getStyledDocument();
		// 设置该文档的页边距
		this.setMargin(new Insets(3, 40, 0, 0));
		// 添加按键监听器，当按键松开时进行语法分析
		this.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent ke)
			{
				syntaxParse();
			}
		});
		// 添加文档监听器
		doc.addDocumentListener(new DocumentListener()
		{
			// 当Document的属性或属性集发生了改变时触发该方法
			public void changedUpdate(DocumentEvent e){}
			// 当向Document中插入文本时触发该方法
			public void insertUpdate(DocumentEvent e)
			{
				docChangeStart = e.getOffset();
				docChangeLength = e.getLength();
			}
			// 当从Document中删除文本时触发该方法
			public void removeUpdate(DocumentEvent e){}
		});
	}
	public void syntaxParse()
	{
		try
		{
			// 获取文档的根元素，即文档内的全部内容
			Element root = doc.getDefaultRootElement();
			// 获取文档中光标插入符的位置
			int cursorPos = this.getCaretPosition();
			int line = root.getElementIndex(cursorPos);
			// 获取光标所在位置的行
			Element para = root.getElement(line);
			// 定义光标所在行的行头在文档中位置
			int start = para.getStartOffset();
			// 让start等于start与docChangeStart中较小值。
			start = start > docChangeStart ? docChangeStart :start;
			// 定义被修改部分的长度
			int length = para.getEndOffset() - start;
			length = length < docChangeLength ? docChangeLength + 1
				: length;
			// 取出所有可能被修改的字符串
			String s = doc.getText(start, length);
			// 以空格、点号等作为分隔符
			String[] tokens = s.split("\\s+|\\.|\\(|\\)|\\{|\\}|\\[|\\]");
			// 定义当前分析单词的在s字符串中的开始位置
			int curStart = 0;
			// 定义单词是否处于引号以内
			boolean isQuot = false;
			for (String token : tokens)
			{
				// 找出当前分析单词在s字符串中的位置
				int tokenPos = s.indexOf(token , curStart);
				if (isQuot && (token.endsWith("\"") || token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
					isQuot = false;
				}
				else if (isQuot && !(token.endsWith("\"")
					|| token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
				}
				else if ((token.startsWith("\"") || token.startsWith("\'"))
					&& (token.endsWith("\"") || token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
				}
				else if ((token.startsWith("\"") || token.startsWith("\'"))
					&& !(token.endsWith("\"") || token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
					isQuot = true;
				}
				else
				{
					// 使用格式器对当前单词设置颜色
					formatter.setHighLight(doc , token , start + tokenPos
						, token.length());
				}
				// 开始分析下一个单词
				curStart = tokenPos + token.length();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 重画该组件，设置行号
	public void paint(Graphics g)
	{
		super.paint(g);
		Element root = doc.getDefaultRootElement();
		// 获得行号
		int line = root.getElementIndex(doc.getLength());
		// 设置颜色
		g.setColor(new Color(230, 230, 230));
		// 绘制显示行数的矩形框
		g.fillRect(0 , 0 , this.getMargin().left - 10 , getSize().height);
		// 设置行号的颜色
		g.setColor(new Color(40, 40, 40));
		// 每行绘制一个行号
		for (int count = 0, j = 1; count <= line; count++, j++)
		{
			g.drawString(String.valueOf(j), 3, (int)((count + 1)
				* 1.535 * StyleConstants.getFontSize(normalAttr)));
		}
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("文本编辑器");
		// 使用MyTextPane
		frame.getContentPane().add(new JScrollPane(new MyTextPane()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(inset, inset, screenSize.width - inset*2
			, screenSize.height - inset * 2);
		frame.setVisible(true);
	}
}
// 定义语法格式器
class SyntaxFormatter
{
	// 以一个Map保存关键字和颜色的对应关系
	private Map<SimpleAttributeSet , ArrayList<String>> attMap
		= new HashMap<>();
	// 定义文档的正常文本的外观属性
	SimpleAttributeSet normalAttr = new SimpleAttributeSet();
	public SyntaxFormatter(String syntaxFile)
	{
		// 设置正常文本的颜色、大小
		StyleConstants.setForeground(normalAttr, Color.BLACK);
		StyleConstants.setFontSize(normalAttr, 16);
		// 创建一个Scanner对象，负责根据语法文件加载颜色信息
		Scanner scaner = null;
		try
		{
			scaner = new Scanner(new File(syntaxFile));
		}
		catch (FileNotFoundException e)
		{
			throw new RuntimeException("丢失语法文件："
				+ e.getMessage());
		}
		int color = -1;
		ArrayList<String> keywords = new ArrayList<>();
		// 不断读取语法文件的内容行
		while(scaner.hasNextLine())
		{
			String line = scaner.nextLine();
			// 如果当前行以#开头
			if (line.startsWith("#"))
			{
				if (keywords.size() > 0 && color > -1)
				{
					// 取出当前行的颜色值，并封装成SimpleAttributeSet对象
					SimpleAttributeSet att = new SimpleAttributeSet();
					StyleConstants.setForeground(att, new Color(color));
					StyleConstants.setFontSize(att, 16);
					// 将当前颜色和关键字List对应起来
					attMap.put(att , keywords);
				}
				// 重新创建新的关键字List，为下一个语法格式准备
				keywords = new ArrayList<>();
				color = Integer.parseInt(line.substring(1) , 16);
			}
			else
			{
				// 对于普通行，每行内容添加到关键字List里
				if (line.trim().length() > 0)
				{
					keywords.add(line.trim());
				}
			}
		}
		// 把所有关键字和颜色对应起来
		if (keywords.size() > 0 && color > -1)
		{
			SimpleAttributeSet att = new SimpleAttributeSet();
			StyleConstants.setForeground(att, new Color(color));
			StyleConstants.setFontSize(att, 16);
			attMap.put(att , keywords);
		}
	}
	// 返回该格式器里正常文本的外观属性
	public SimpleAttributeSet getNormalAttributeSet()
	{
		return normalAttr;
	}
	// 设置语法高亮
	public void setHighLight(StyledDocument doc , String token
		, int start , int length)
	{
		// 保存需要对当前单词对应的外观属性
		SimpleAttributeSet currentAttributeSet = null;
		outer :
		for (SimpleAttributeSet att : attMap.keySet())
		{
			// 取出当前颜色对应的所有关键字
			ArrayList<String> keywords = attMap.get(att);
			// 遍历所有关键字
			for (String keyword : keywords)
			{
				// 如果该关键字与当前单词相同
				if (keyword.equals(token))
				{
					// 跳出循环，并设置当前单词对应的外观属性
					currentAttributeSet = att;
					break outer;
				}
			}
		}
		// 如果当前单词对应的外观属性不为空
		if (currentAttributeSet != null)
		{
			// 设置当前单词的颜色
			doc.setCharacterAttributes(start , length
				, currentAttributeSet , false);
		}
		// 否则使用普通外观来设置该单词
		else
		{
			doc.setCharacterAttributes(start , length , normalAttr , false);
		}
	}
}
