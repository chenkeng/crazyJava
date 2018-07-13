

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
@FkTag(age=5)
@FkTag(name="疯狂Java" , age=9)
//@FkTags({@FkTag(age=5),
//	@FkTag(name="疯狂Java" , age=9)})
public class FkTagTest
{
	public static void main(String[] args)
	{
		Class<FkTagTest> clazz = FkTagTest.class;
		/* 使用Java 8新增的getDeclaredAnnotationsByType()方法获取
			修饰FkTagTest类的多个@FkTag注解 */
		FkTag[] tags = clazz.getDeclaredAnnotationsByType(FkTag.class);
		// 遍历修饰FkTagTest类的多个@FkTag注解
		for(FkTag tag : tags)
		{
			System.out.println(tag.name() + "-->" + tag.age());
		}
		/* 使用传统的getDeclaredAnnotation()方法获取
			修饰FkTagTest类的@FkTags注解 */
		FkTags container = clazz.getDeclaredAnnotation(FkTags.class);
		System.out.println(container);
	}
}
