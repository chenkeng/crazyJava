
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
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
public class ZoomImage
{
	// 下面两个常量设置缩小后图片的大小
	private final int WIDTH = 80;
	private final int HEIGHT = 60;
	// 定义个BuffedImage对象，用于保存缩小后的位图
	BufferedImage image = new BufferedImage(WIDTH , HEIGHT
		, BufferedImage. TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	public void zoom()throws Exception
	{
		// 读取原始位图
		Image srcImage = ImageIO.read(new File("image/board.jpg"));
		// 将原始位图缩小后绘制到image图像中
		g.drawImage(srcImage , 0 , 0 , WIDTH , HEIGHT , null);
		// 将image图像文件输出到磁盘文件中。
		ImageIO.write(image , "jpeg"
			, new File(System.currentTimeMillis() + ".jpg"));
	}
	public static void main(String[] args)throws Exception
	{
		new ZoomImage().zoom();
	}
}
