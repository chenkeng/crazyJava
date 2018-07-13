
import java.text.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
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
public class LanTalk extends JFrame
{
	private DefaultListModel<UserInfo> listModel
		= new DefaultListModel<>();
	// 定义一个JList对象
	private JList<UserInfo> friendsList = new JList<>(listModel);
	// 定义一个用于格式化日期的格式器
	private DateFormat formatter = DateFormat.getDateTimeInstance();
	public LanTalk()
	{
		super("局域网聊天");
		// 设置该JList使用ImageCellRenderer作为单元格绘制器
		friendsList.setCellRenderer(new ImageCellRenderer());
		listModel.addElement(new UserInfo("all" , "所有人"
			, null , -2000));
		friendsList.addMouseListener(new ChangeMusicListener());
		add(new JScrollPane(friendsList));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 2, 160 , 600);
	}
	// 根据地址来查询用户
	public UserInfo getUserBySocketAddress(SocketAddress address)
	{
		for (int i = 1 ; i < getUserNum() ; i++)
		{
			UserInfo user = getUser(i);
			if (user.getAddress() != null
				&& user.getAddress().equals(address))
			{
				return user;
			}
		}
		return null;
	}
	// ------下面四个方法是对ListModel的包装------
	// 向用户列表中添加用户
	public void addUser(UserInfo user)
	{
		listModel.addElement(user);
	}
	// 从用户列表中删除用户
	public void removeUser(int pos)
	{
		listModel.removeElementAt(pos);
	}
	// 获取该聊天窗口的用户数量
	public int getUserNum()
	{
		return listModel.size();
	}
	// 获取指定位置的用户
	public UserInfo getUser(int pos)
	{
		return listModel.elementAt(pos);
	}
	// 实现JList上的鼠标双击事件的监听器
	class ChangeMusicListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			// 如果鼠标的击键次数大于2
			if (e.getClickCount() >= 2)
			{
				// 取出鼠标双击时选中的列表项
				UserInfo user = (UserInfo)friendsList.getSelectedValue();
				// 如果该列表项对应用户的交谈窗口为null
				if (user.getChatFrame() == null)
				{
					// 为该用户创建一个交谈窗口，并让该用户引用该窗口
					user.setChatFrame(new ChatFrame(null , user));
				}
				// 如果该用户的窗口没有显示，则让该用户的窗口显示出来
				if (!user.getChatFrame().isShowing())
				{
					user.getChatFrame().setVisible(true);
				}
			}
		}
	}
	/**
	 * 处理网络数据报，该方法将根据聊天信息得到聊天者，
	 * 并将信息显示在聊天对话框中。
	 * @param packet 需要处理的数据报
	 * @param single 该信息是否为私聊信息
	 */
	public void processMsg(DatagramPacket packet , boolean single)
	{
		// 获取该发送该数据报的SocketAddress
		InetSocketAddress srcAddress = (InetSocketAddress)
			packet.getSocketAddress();
		// 如果是私聊信息，则该Packet获取的是DatagramSocket的地址，
		// 将端口减1才是对应的MulticastSocket的地址
		if (single)
		{
			srcAddress = new InetSocketAddress(srcAddress.getHostName()
				, srcAddress.getPort() - 1);
		}
		UserInfo srcUser = getUserBySocketAddress(srcAddress);
		if (srcUser != null)
		{
			// 确定消息将要显示到哪个用户对应窗口上。
			UserInfo alertUser = single ? srcUser : getUser(0);
			// 如果该用户对应的窗口为空，显示该窗口
			if (alertUser.getChatFrame() == null)
			{
				alertUser.setChatFrame(new ChatFrame(null , alertUser));
			}
			// 定义添加的提示信息
			String tipMsg = single ? "对您说：" : "对大家说：";
			try{
				// 显示提示信息
				alertUser.getChatFrame().addString(srcUser.getName()
					+ tipMsg + "......................("
					+ formatter.format(new Date()) + ")\n"
					+ new String(packet.getData() , 0 , packet.getLength()
					, ComUtil.CHARSET) + "\n");
			} catch (Exception ex) { ex.printStackTrace(); }
			if (!alertUser.getChatFrame().isShowing())
			{
				alertUser.getChatFrame().setVisible(true);
			}
		}
	}
	// 主方法，程序的入口
	public static void main(String[] args)
	{
		LanTalk lanTalk = new LanTalk();
		new LoginFrame(lanTalk , "请输入用户名、头像后登录");
	}
}
// 定义用于改变JList列表项外观的类
class ImageCellRenderer extends JPanel
	implements ListCellRenderer<UserInfo>
{
	private ImageIcon icon;
	private String name;
	// 定义绘制单元格时的背景色
	private Color background;
	// 定义绘制单元格时的前景色
	private Color foreground;
	@Override
	public Component getListCellRendererComponent(JList list
		, UserInfo userInfo , int index
		, boolean isSelected , boolean cellHasFocus)
	{
		// 设置图标
		icon = new ImageIcon("ico/" + userInfo.getIcon() + ".gif");
		name = userInfo.getName();
		// 设置背景色、前景色
		background = isSelected ? list.getSelectionBackground()
			: list.getBackground();
		foreground = isSelected ? list.getSelectionForeground()
			: list.getForeground();
		// 返回该JPanel对象作为单元格绘制器
		return this;
	}
	// 重写paintComponent方法，改变JPanel的外观
	public void paintComponent(Graphics g)
	{
		int imageWidth = icon.getImage().getWidth(null);
		int imageHeight = icon.getImage().getHeight(null);
		g.setColor(background);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(foreground);
		// 绘制好友图标
		g.drawImage(icon.getImage() , getWidth() / 2 - imageWidth / 2
			, 10 , null);
		g.setFont(new Font("SansSerif" , Font.BOLD , 18));
		// 绘制好友用户名
		g.drawString(name, getWidth() / 2 - name.length() * 10
			, imageHeight + 30 );
	}
	// 通过该方法来设置该ImageCellRenderer的最佳大小
	public Dimension getPreferredSize()
	{
		return new Dimension(60, 80);
	}
}