
import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;
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
public class ExtendsDefaultTreeCellRenderer
{
	JFrame jf = new JFrame("根据节点类型定义图标");
	JTree tree;
	// 定义几个初始节点
	DefaultMutableTreeNode root = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.ROOT , "数据库导航"));
	DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.DATABASE , "公司工资数据库"));
	DefaultMutableTreeNode customerDb = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.DATABASE , "公司客户数据库"));
	// 定义salaryDb的两个子节点
	DefaultMutableTreeNode employee = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.TABLE , "员工表"));
	DefaultMutableTreeNode attend = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.TABLE , "考勤表"));
	// 定义customerDb的一个子节点
	DefaultMutableTreeNode contact = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.TABLE , "联系方式表"));
	// 定义employee的三个子节点
	DefaultMutableTreeNode id = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.INDEX , "员工ID"));
	DefaultMutableTreeNode name = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.COLUMN , "姓名"));
	DefaultMutableTreeNode gender = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.COLUMN , "性别"));
	public void init()
	{
		// 通过add()方法建立树节点之间的父子关系
		root.add(salaryDb);
		root.add(customerDb);
		salaryDb.add(employee);
		salaryDb.add(attend);
		customerDb.add(contact);
		employee.add(id);
		employee.add(name);
		employee.add(gender);
		// 以根节点创建树
		tree = new JTree(root);
		// 设置该JTree使用自定义的节点绘制器
		tree.setCellRenderer(new MyRenderer());
		// 设置是否显示根节点的“展开/折叠”图标,默认是false
		tree.setShowsRootHandles(true);
		// 设置节点是否可见,默认是true
		tree.setRootVisible(true);
		try
		{
			// 设置使用Windows风格外观
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
				+ "windows.WindowsLookAndFeel");
		}
		catch (Exception ex){}
		// 更新JTree的UI外观
		SwingUtilities.updateComponentTreeUI(tree);
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ExtendsDefaultTreeCellRenderer().init();
	}
}
// 定义一个NodeData类，用于封装节点数据
class NodeData
{
	public int nodeType;
	public String nodeData;
	public NodeData(int nodeType , String nodeData)
	{
		this.nodeType = nodeType;
		this.nodeData = nodeData;
	}
	public String toString()
	{
		return nodeData;
	}
}
// 定义一个接口，该接口里包含数据库对象类型的常量
interface DBObjectType
{
	int ROOT = 0;
	int DATABASE = 1;
	int TABLE = 2;
	int COLUMN = 3;
	int INDEX = 4;
}
class MyRenderer extends DefaultTreeCellRenderer
{
	// 初始化5个图标
	ImageIcon rootIcon = new ImageIcon("icon/root.gif");
	ImageIcon databaseIcon = new ImageIcon("icon/database.gif");
	ImageIcon tableIcon = new ImageIcon("icon/table.gif");
	ImageIcon columnIcon = new ImageIcon("icon/column.gif");
	ImageIcon indexIcon = new ImageIcon("icon/index.gif");
	public Component getTreeCellRendererComponent(JTree tree
		, Object value , boolean sel , boolean expanded
		, boolean leaf , int row , boolean hasFocus)
	{
		// 执行父类默认的节点绘制操作
		super.getTreeCellRendererComponent(tree , value
			, sel, expanded , leaf , row , hasFocus);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		NodeData data = (NodeData)node.getUserObject();
		// 根据数据节点里的nodeType数据决定节点图标
		ImageIcon icon = null;
		switch(data.nodeType)
		{
			case DBObjectType.ROOT:
				icon = rootIcon;
				break;
			case DBObjectType.DATABASE:
				icon = databaseIcon;
				break;
			case DBObjectType.TABLE:
				icon = tableIcon;
				break;
			case DBObjectType.COLUMN:
				icon = columnIcon;
				break;
			case DBObjectType.INDEX:
				icon = indexIcon;
				break;
		}
		// 改变图标
		this.setIcon(icon);
		return this;
	}
}