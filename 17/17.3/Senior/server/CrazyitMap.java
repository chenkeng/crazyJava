
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
// 通过组合HashMap对象来实现CrazyitMap，CrazyitMap要求value也不可重复
public class CrazyitMap<K,V>
{
	// 创建一个线程安全的HashMap
	public Map<K ,V> map = Collections.synchronizedMap(new HashMap<K,V>());
	// 根据value来删除指定项
	public synchronized void removeByValue(Object value)
	{
		for (Object key : map.keySet())
		{
			if (map.get(key) == value)
			{
				map.remove(key);
				break;
			}
		}
	}
	// 获取所有value组成的Set集合
	public synchronized Set<V> valueSet()
	{
		Set<V> result = new HashSet<V>();
		// 将map中所有value添加到result集合中
		map.forEach((key , value) -> result.add(value));
		return result;
	}
	// 根据value查找key。
	public synchronized K getKeyByValue(V val)
	{
		// 遍历所有key组成的集合
		for (K key : map.keySet())
		{
			// 如果指定key对应的value与被搜索的value相同，则返回对应的key
			if (map.get(key) == val || map.get(key).equals(val))
			{
				return key;
			}
		}
		return null;
	}
	// 实现put()方法，该方法不允许value重复
	public synchronized V put(K key,V value)
	{
		// 遍历所有value组成的集合
		for (V val : valueSet() )
		{
			// 如果某个value与试图放入集合的value相同
			// 则抛出一个RuntimeException异常
			if (val.equals(value)
				&& val.hashCode()== value.hashCode())
			{
				throw new RuntimeException("MyMap实例中不允许有重复value!");
			}
		}
		return map.put(key , value);
	}
}
