
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
public class RandomTest
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		System.out.println("rand.nextBoolean()："
			+ rand.nextBoolean());
		byte[] buffer = new byte[16];
		rand.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));
		// 生成0.0~1.0之间的伪随机double数
		System.out.println("rand.nextDouble()："
			+ rand.nextDouble());
		// 生成0.0~1.0之间的伪随机float数
		System.out.println("rand.nextFloat()："
			+ rand.nextFloat());
		// 生成平均值是 0.0，标准差是 1.0的伪高斯数
		System.out.println("rand.nextGaussian()："
			+ rand.nextGaussian());
		// 生成一个处于int整数取值范围的伪随机整数
		System.out.println("rand.nextInt()：" + rand.nextInt());
		// 生成0~26之间的伪随机整数
		System.out.println("rand.nextInt(26)：" + rand.nextInt(26));
		// 生成一个处于long整数取值范围的伪随机整数
		System.out.println("rand.nextLong()：" +  rand.nextLong());
	}
}
