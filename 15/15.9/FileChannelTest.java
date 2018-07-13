
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
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
public class FileChannelTest
{
	public static void main(String[] args)
	{
		File f = new File("FileChannelTest.java");
		try(
			// 创建FileInputStream，以该文件输入流创建FileChannel
			FileChannel inChannel = new FileInputStream(f).getChannel();
			// 以文件输出流创建FileBuffer，用以控制输出
			FileChannel outChannel = new FileOutputStream("a.txt")
				.getChannel())
		{
			// 将FileChannel里的全部数据映射成ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel
				.MapMode.READ_ONLY , 0 , f.length());   // ①
			// 使用GBK的字符集来创建解码器
			Charset charset = Charset.forName("GBK");
			// 直接将buffer里的数据全部输出
			outChannel.write(buffer);     // ②
			// 再次调用buffer的clear()方法，复原limit、position的位置
			buffer.clear();
			// 创建解码器(CharsetDecoder)对象
			CharsetDecoder decoder = charset.newDecoder();
			// 使用解码器将ByteBuffer转换成CharBuffer
			CharBuffer charBuffer =  decoder.decode(buffer);
			// CharBuffer的toString方法可以获取对应的字符串
			System.out.println(charBuffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
