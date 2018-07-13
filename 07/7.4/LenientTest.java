
import java.util.*;
import static java.util.Calendar.*;

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
public class LenientTest
{
	public static void main(String[] args)
	{
		Calendar cal = Calendar.getInstance();
		// 结果是YEAR字段加1，MONTH字段为1（二月）
		cal.set(MONTH , 13);   //①
		System.out.println(cal.getTime());
		// 关闭容错性
		cal.setLenient(false);
		// 导致运行时异常
		cal.set(MONTH , 13);   //②
		System.out.println(cal.getTime());
	}
}
