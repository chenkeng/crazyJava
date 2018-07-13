
import java.io.File;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.filechooser.*;
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
public class TableCellEditorTest
{
	JFrame jf = new JFrame("使用单元格编辑器");
	JTable table;
	// 定义二维数组作为表格数据
	Object[][] tableData =
	{
		new Object[]{"李清照" , 29 , "女" , new ImageIcon("icon/3.gif")
			, new ImageIcon("icon/3.gif") , true},
		new Object[]{"苏格拉底", 56 , "男" , new ImageIcon("icon/1.gif")
			, new ImageIcon("icon/1.gif") , false},
		new Object[]{"李白", 35 , "男" , new ImageIcon("icon/4.gif")
			, new ImageIcon("icon/4.gif") , true},
		new Object[]{"弄玉", 18 , "女" , new ImageIcon("icon/2.gif")
			, new ImageIcon("icon/2.gif") , true},
		new Object[]{"虎头" , 2 , "男" , new ImageIcon("icon/5.gif")
			, new ImageIcon("icon/5.gif") , false}
	};
	// 定义一维数据作为列标题
	String[] columnTitle = {"姓名" , "年龄" , "性别" , "主头像"
		, "次头像" , "是否中国人"};
	public void init()
	{
		// 以二维数组和一维数组来创建一个ExtendedTableModel对象
		ExtendedTableModel model = new ExtendedTableModel(
			columnTitle , tableData);
		// 以ExtendedTableModel来创建JTable
		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(40);
		// 为该表格指定默认的编辑器
		table.setDefaultEditor(ImageIcon.class, new ImageCellEditor());
		// 获取第五列
		TableColumn lastColumn = table.getColumnModel().getColumn(4);
		// 创建JComboBox对象，并添加多个图标列表项
		JComboBox<ImageIcon> editCombo = new JComboBox<>();
		for (int i = 1; i <= 10; i++)
		{
			editCombo.addItem(new ImageIcon("icon/" + i + ".gif"));
		}
		// 设置第五列使用基于JComboBox的DefaultCellEditor
		lastColumn.setCellEditor(new DefaultCellEditor(editCombo));
		// 将JTable对象放在JScrollPane中，并将该JScrollPane放在窗口中显示出来
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new TableCellEditorTest().init();
	}
}
class ExtendedTableModel extends DefaultTableModel
{
	// 重新提供一个构造器，该构造器的实现委托给DefaultTableModel父类
	public ExtendedTableModel(String[] columnNames , Object[][] cells)
	{
		super(cells , columnNames);
	}
	// 重写getColumnClass方法，根据每列的第一个值返回该列真实的数据类型
	public Class getColumnClass(int c)
	{
		return getValueAt(0 , c).getClass();
	}
}
// 扩展DefaultCellEditor来实现TableCellEditor类
class ImageCellEditor extends DefaultCellEditor
{
	// 定义文件选择器
	private JFileChooser fDialog = new JFileChooser(); ;
	private JTextField field = new JTextField(15);
	private JButton button = new JButton("...");
	public ImageCellEditor()
	{
		// 因为DefaultCellEditor没有无参数的构造器
		// 所以这里显式调用父类有参数的构造器。
		super(new JTextField());
		initEditor();
	}
	private void initEditor()
	{
		field.setEditable(false);
		// 为按钮添加监听器，当用户单击该按钮时，
		// 系统将出现一个文件选择器让用户选择图标文件。
		button.addActionListener(e -> browse());
		// 为文件选择器安装文件过滤器
		fDialog.addChoosableFileFilter(new FileFilter()
		{
			public boolean accept(File f)
			{
				if (f.isDirectory())
				{
					return true;
				}
				String extension = Utils.getExtension(f);
				if (extension != null)
				{
					if (extension.equals(Utils.tiff)
						|| extension.equals(Utils.tif)
						|| extension.equals(Utils.gif)
						|| extension.equals(Utils.jpeg)
						|| extension.equals(Utils.jpg)
						|| extension.equals(Utils.png))
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				return false;
			}
			public String getDescription()
			{
				return "有效的图片文件";
			}
		});
		fDialog.setAcceptAllFileFilterUsed(false);
	}
	// 重写TableCellEditor接口的getTableCellEditorComponent方法
	// 该方法返回单元格编辑器，该编辑器是一个JPanel，
	// 该容器包含一个文本框和一个按钮
	public Component getTableCellEditorComponent(JTable table
		, Object value , boolean isSelected , int row , int column)  // ①
	{
		this.button.setPreferredSize(new Dimension(20, 20));
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		field.setText(value.toString());
		panel.add(this.field, BorderLayout.CENTER);
		panel.add(this.button, BorderLayout.EAST);
		return panel;
	}
	public Object getCellEditorValue()
	{
		return new ImageIcon(field.getText());
	}
	private void browse()
	{
		// 设置、打开文件选择器
		fDialog.setCurrentDirectory(new File("icon"));
		int result = fDialog.showOpenDialog(null);
		// 如果单击了文件选择器的“取消”按钮
		if (result == JFileChooser.CANCEL_OPTION)
		{
			// 取消编辑
			super.cancelCellEditing();
			return;
		}
		// 如果单击了文件选择器的“确定”按钮
		else
		{
			// 设置field的内容
			field.setText("icon/" + fDialog.getSelectedFile().getName());
		}
	}
}
class Utils
{
	public final static String jpeg = "jpeg";
	public final static String jpg = "jpg";
	public final static String gif = "gif";
	public final static String tiff = "tiff";
	public final static String tif = "tif";
	public final static String png = "png";
	// 获取文件扩展名的方法
	public static String getExtension(File f)
	{
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 &&  i < s.length() - 1)
		{
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}
