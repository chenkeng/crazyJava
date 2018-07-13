
import java.nio.*;
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
public class BufferTest
{
	public static void main(String[] args)
	{
		// 创建Buffer
		CharBuffer buff = CharBuffer.allocate(8);    // ①
		System.out.println("capacity: "	+ buff.capacity());
		System.out.println("limit: " + buff.limit());
		System.out.println("position: " + buff.position());
		// 放入元素
		buff.put('a');
		buff.put('b');
		buff.put('c');      // ②
		System.out.println("加入三个元素后，position = "
			+ buff.position());
		// 调用flip()方法
		buff.flip();	  // ③
		System.out.println("执行flip()后，limit = " + buff.limit());
		System.out.println("position = " + buff.position());
		// 取出第一个元素
		System.out.println("第一个元素(position=0)：" + buff.get());  // ④
		System.out.println("取出一个元素后，position = "
			+ buff.position());
		// 调用clear方法
		buff.clear();     // ⑤
		System.out.println("执行clear()后，limit = " + buff.limit());
		System.out.println("执行clear()后，position = "
			+ buff.position());
		System.out.println("执行clear()后，缓冲区内容并没有被清除："
			+ "第三个元素为：" +  buff.get(2));    // ⑥
		System.out.println("执行绝对读取后，position = "
			+ buff.position());
	}
}
