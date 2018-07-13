
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
public class EnumerationTest
{
	public static void main(String[] args)
	{
		Vector v = new Vector();
		v.add("疯狂Java讲义");
		v.add("轻量级Java EE企业应用实战");
		Hashtable scores = new Hashtable();
		scores.put("语文" , 78);
		scores.put("数学" , 88);
		Enumeration em = v.elements();
		while (em.hasMoreElements())
		{
			System.out.println(em.nextElement());
		}
		Enumeration keyEm = scores.keys();
		while (keyEm.hasMoreElements())
		{
			Object key = keyEm.nextElement();
			System.out.println(key + "--->"
				+ scores.get(key));
		}
	}
}
