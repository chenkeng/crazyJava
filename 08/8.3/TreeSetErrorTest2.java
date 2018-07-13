
import java.util.*;
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
public class TreeSetErrorTest2
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		// 向TreeSet集合中添加两个对象
		ts.add(new String("疯狂Java讲义"));
		ts.add(new Date());   // ①
	}
}
