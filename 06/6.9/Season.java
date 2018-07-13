

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
public class Season
{
	// 把Season类定义成不可变的，将其成员变量也定义成final的
	private final String name;
	private final String desc;
	public static final Season SPRING
		= new Season("春天" , "趁春踏青");
	public static final Season SUMMER
		= new Season("夏天" , "夏日炎炎");
	public static final Season FALL
		= new Season("秋天" , "秋高气爽");
	public static final Season WINTER
		= new Season("冬天" , "围炉赏雪");
	public static Season getSeason(int seasonNum)
	{
	switch(seasonNum)
	{
		case 1 :
			return SPRING;
		case 2 :
			return SUMMER;
		case 3 :
			return FALL;
		case 4 :
			return WINTER;
		default :
			return null;
		}
	}
	// 将构造器定义成private访问权限
	private Season(String name , String desc)
	{
		this.name = name;
		this.desc = desc;
	}
	// 只为name和desc提供getter方法
	public String getName()
	{
		return this.name;
	}
	public String getDesc()
	{
		return this.desc;
	}
}
