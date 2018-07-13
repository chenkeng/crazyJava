
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
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
public class AdjustingWidth
{
	JFrame jf = new JFrame("调整表格列宽");
	JMenuBar menuBar = new JMenuBar();
	JMenu adjustModeMenu = new JMenu("调整方式");
	JMenu selectUnitMenu = new JMenu("选择单元");
	JMenu selectModeMenu = new JMenu("选择方式");
	// 定义5个单选框按钮，用以控制表格的宽度调整方式
	JRadioButtonMenuItem[] adjustModesItem = new JRadioButtonMenuItem[5];
	// 定义3个单选框按钮，用以控制表格的选择方式
	JRadioButtonMenuItem[] selectModesItem = new JRadioButtonMenuItem[3];
	JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("选择行");
	JCheckBoxMenuItem columnsItem = new JCheckBoxMenuItem("选择列");
	JCheckBoxMenuItem cellsItem = new JCheckBoxMenuItem("选择单元格");
	ButtonGroup adjustBg = new ButtonGroup();
	ButtonGroup selectBg = new ButtonGroup();
	// 定义一个int类型的数组，用于保存表格所有的宽度调整方式
	int[] adjustModes = new int[]{
		JTable.AUTO_RESIZE_OFF
		, JTable.AUTO_RESIZE_NEXT_COLUMN
		, JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS
		, JTable.AUTO_RESIZE_LAST_COLUMN
		, JTable.AUTO_RESIZE_ALL_COLUMNS
	};
	int[] selectModes = new int[]{
		ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		, ListSelectionModel.SINGLE_INTERVAL_SELECTION
		, ListSelectionModel.SINGLE_SELECTION
	};
	JTable table;
	// 定义二维数组作为表格数据
	Object[][] tableData =
	{
		new Object[]{"李清照" , 29 , "女"},
		new Object[]{"苏格拉底", 56 , "男"},
		new Object[]{"李白", 35 , "男"},
		new Object[]{"弄玉", 18 , "女"},
		new Object[]{"虎头" , 2 , "男"}
	};
	// 定义一维数据作为列标题
	Object[] columnTitle = {"姓名" , "年龄" , "性别"};
	public void init()
	{
		// 以二维数组和一维数组来创建一个JTable对象
		table = new JTable(tableData , columnTitle);
		// -----------为窗口安装设置表格调整方式的菜单-----------
		adjustModesItem[0] = new JRadioButtonMenuItem("只调整表格");
		adjustModesItem[1] = new JRadioButtonMenuItem("只调整下一列");
		adjustModesItem[2] = new JRadioButtonMenuItem("平均调整余下列");
		adjustModesItem[3] = new JRadioButtonMenuItem("只调整最后一列");
		adjustModesItem[4] = new JRadioButtonMenuItem("平均调整所有列");
		menuBar.add(adjustModeMenu);
		for (int i = 0; i < adjustModesItem.length ; i++)
		{
			// 默认选中第三个菜单项，即对应表格默认的宽度调整方式
			if (i == 2)
			{
				adjustModesItem[i].setSelected(true);
			}
			adjustBg.add(adjustModesItem[i]);
			adjustModeMenu.add(adjustModesItem[i]);
			final int index = i;
			// 为设置调整方式的菜单项添加监听器
			adjustModesItem[i].addActionListener(evt ->
			{
				// 如果当前菜单项处于选中状态，表格使用对应的调整方式
				if (adjustModesItem[index].isSelected())
				{
					table.setAutoResizeMode(adjustModes[index]);   //①
				}
			});
		}
		// -----------为窗口安装设置表格选择方式的菜单-----------
		selectModesItem[0] = new JRadioButtonMenuItem("无限制");
		selectModesItem[1] = new JRadioButtonMenuItem("单独的连续区");
		selectModesItem[2] = new JRadioButtonMenuItem("单选");
		menuBar.add(selectModeMenu);
		for (int i = 0; i < selectModesItem.length ; i++)
		{
			// 默认选中第一个菜单项，即对应表格默认的选择方式
			if (i == 0)
			{
			selectModesItem[i].setSelected(true);
			}
			selectBg.add(selectModesItem[i]);
			selectModeMenu.add(selectModesItem[i]);
			final int index = i;
			// 为设置选择方式的菜单项添加监听器
			selectModesItem[i].addActionListener(evt -> {
				// 如果当前菜单项处于选中状态，表格使用对应的选择方式s
				if (selectModesItem[index].isSelected())
				{
					table.getSelectionModel().setSelectionMode
						(selectModes[index]);     //②
				}
			});
		}
		menuBar.add(selectUnitMenu);
		// -----为窗口安装设置表格选择单元的菜单-----
		rowsItem.setSelected(table.getRowSelectionAllowed());
		columnsItem.setSelected(table.getColumnSelectionAllowed());
		cellsItem.setSelected(table.getCellSelectionEnabled());
		rowsItem.addActionListener(event -> {
			table.clearSelection();
			// 如果该菜单项处于选中状态，设置表格的选择单元是行
			table.setRowSelectionAllowed(rowsItem.isSelected());
			// 如果选择行、选择列同时被选中，其实质是选择单元格
			cellsItem.setSelected(table.getCellSelectionEnabled());
		});
		selectUnitMenu.add(rowsItem);
		columnsItem.addActionListener(event -> {
			table.clearSelection();
			// 如果该菜单项处于选中状态，设置表格的选择单元是列
			table.setColumnSelectionAllowed(columnsItem.isSelected());
			// 如果选择行、选择列同时被选中，其实质是选择单元格
			cellsItem.setSelected(table.getCellSelectionEnabled());
		});
		selectUnitMenu.add(columnsItem);
		cellsItem.addActionListener(event -> {
			table.clearSelection();
			// 如果该菜单项处于选中状态，设置表格的选择单元是单元格
			table.setCellSelectionEnabled(cellsItem.isSelected());
			// 该选项的改变会同时影响选择行、选择列两个菜单
			rowsItem.setSelected(table.getRowSelectionAllowed());
			columnsItem.setSelected(table.getColumnSelectionAllowed());
		});
		selectUnitMenu.add(cellsItem);
		jf.setJMenuBar(menuBar);
		// 分别获取表格的三个表格列，并设置三列的最小宽度，最佳宽度和最大宽度
		TableColumn nameColumn = table.getColumn(columnTitle[0]);
		nameColumn.setMinWidth(40);
		TableColumn ageColumn = table.getColumn(columnTitle[1]);
		ageColumn.setPreferredWidth(50);
		TableColumn genderColumn = table.getColumn(columnTitle[2]);
		genderColumn.setMaxWidth(50);
		// 将JTable对象放在JScrollPane中，并将该JScrollPane放在窗口中显示出来
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new AdjustingWidth().init();
	}
}
