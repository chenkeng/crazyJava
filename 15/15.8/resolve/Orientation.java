
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
public class Orientation
	implements java.io.Serializable
{
	public static final Orientation HORIZONTAL = new Orientation(1);
	public static final Orientation VERTICAL = new Orientation(2);
	private int value;
	private Orientation(int value)
	{
		this.value = value;
	}
	// 为枚举类增加readResolve()方法
	private Object readResolve()throws ObjectStreamException
	{
		if (value == 1)
		{
			return HORIZONTAL;
		}
		if (value == 2)
		{
			return VERTICAL;
		}
		return null;
	}
}
