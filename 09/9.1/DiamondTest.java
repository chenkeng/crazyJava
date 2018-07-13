
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
public class DiamondTest
{
	public static void main(String[] args)
	{
		// Java自动推断出ArrayList的<>里应该是String
		List<String> books = new ArrayList<>();
		books.add("疯狂Java讲义");
		books.add("疯狂Android讲义");
		// 遍历books集合，集合元素就是String类型
		books.forEach(ele -> System.out.println(ele.length()));
		// Java自动推断出HashMap的<>里应该是String , List<String>
		Map<String , List<String>> schoolsInfo = new HashMap<>();
		// Java自动推断出ArrayList的<>里应该是String
		List<String> schools = new ArrayList<>();
		schools.add("斜月三星洞");
		schools.add("西天取经路");
		schoolsInfo.put("孙悟空" , schools);
		// 遍历Map时，Map的key是String类型，value是List<String>类型
		schoolsInfo.forEach((key , value) -> System.out.println(key + "-->" + value));
	}
}
