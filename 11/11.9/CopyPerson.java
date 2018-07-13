
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
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

class Person
{
	private String name;
	private int age;

	public Person(){}

	public Person(String name , int age)
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
		return "Person[ name=" + name + " , age=" + age + " ]";
	}
}
public class CopyPerson
{
	Frame f = new Frame("复制对象");
	Button copy = new Button("复制");
	Button paste = new Button("粘贴");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea ta = new TextArea(3 , 30);
	// 创建本地的剪贴板
	Clipboard clipboard = new Clipboard("cp");
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
		// 为“复制”按钮添加事件监听器
		copy.addActionListener(e -> copyPerson());
		// 为“粘贴”按钮添加事件监听器
		paste.addActionListener(e ->
		{
			try
			{
				readPerson();
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
	public void copyPerson()
	{
		// 以name,age文本框的内容创建Person对象
		Person p = new Person(name.getText()
			, Integer.parseInt(age.getText()));
		// 将Person对象封装成LocalObjectSelection对象
		LocalObjectSelection ls = new LocalObjectSelection(p);
		// 将LocalObjectSelection对象放入本地剪贴板
		clipboard.setContents(ls , null);
	}
	public void readPerson()throws Exception
	{
		// 创建保存Person对象引用的DataFlavor对象
		DataFlavor peronFlavor = new DataFlavor(
			"application/x-java-jvm-local-objectref;class=Person");
		// 取出本地剪贴板内的内容
		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
		{
			Person p = (Person)clipboard.getData(peronFlavor);
			ta.setText(p.toString());
		}
	}
	public static void main(String[] args)
	{
		new CopyPerson().init();
	}
}

