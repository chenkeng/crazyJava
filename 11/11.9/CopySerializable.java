
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

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
class Dog implements Serializable
{
	private String name;
	private int age;

	public Dog(){}

	public Dog(String name , int age)
	{
		this.name = name;
		this.age = age;
	}
	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		 return this.age;
	}
	public String toString()
	{
		return "Dog [ name=" + name + " , age=" + age + " ]";
	}
}
public class CopySerializable
{
	Frame f = new Frame("复制对象");
	Button copy = new Button("复制");
	Button paste = new Button("粘贴");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea ta = new TextArea(3 , 30);
	// 创建系统剪贴板
	Clipboard clipboard = Toolkit.getDefaultToolkit()
		.getSystemClipboard();
	public void init()
	{
		Panel p = new Panel();
		p.add(new Label("姓名"));
		p.add(name);
		p.add(new Label("年龄"));
		p.add(age);
		f.add(p , BorderLayout.NORTH);
		f.add(ta);
		Panel bp = new Panel();
		copy.addActionListener(e -> copyDog());
		paste.addActionListener(e ->
		{
			try
			{
				readDog();
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		});
		bp.add(copy);
		bp.add(paste);
		f.add(bp , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public void copyDog()
	{
		Dog d = new Dog(name.getText()
			, Integer.parseInt(age.getText()));
		// 把dog实例封装成SerialSelection对象
		SerialSelection ls =new SerialSelection(d);
		// 把SerialSelection对象放入系统剪贴板中
		clipboard.setContents(ls , null);
	}
	public void readDog()throws Exception
	{
		DataFlavor peronFlavor = new DataFlavor(DataFlavor
			.javaSerializedObjectMimeType + ";class=Dog");
		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
		{
			// 从系统剪贴板中读取数据
			Dog d = (Dog)clipboard.getData(peronFlavor);
			ta.setText(d.toString());
		}
	}
	public static void main(String[] args)
	{
		new CopySerializable().init();
	}
}
