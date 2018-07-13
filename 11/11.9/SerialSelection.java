
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
public class SerialSelection implements Transferable
{
	// 持有一个可序列化的对象
	private Serializable obj;
	// 创建该类的对象时传入被持有的对象
	public SerialSelection(Serializable obj)
	{
		this.obj = obj;
	}
	public DataFlavor[] getTransferDataFlavors()
	{
		DataFlavor[] flavors = new DataFlavor[2];
		// 获取被封装对象的类型
		Class clazz = obj.getClass();
		try
		{
			flavors[0] = new DataFlavor(DataFlavor.javaSerializedObjectMimeType
				+ ";class=" + clazz.getName());
			flavors[1] = DataFlavor.stringFlavor;
			return flavors;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public Object getTransferData(DataFlavor flavor)
		throws UnsupportedFlavorException
	{
		if(!isDataFlavorSupported(flavor))
		{
			throw new UnsupportedFlavorException(flavor);
		}
		if (flavor.equals(DataFlavor.stringFlavor))
		{
			return obj.toString();
		}
		return obj;
	}
	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		return flavor.equals(DataFlavor.stringFlavor) ||
			flavor.getPrimaryType().equals("application")
			&& flavor.getSubType().equals("x-java-serialized-object")
			&& flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
	}
}
