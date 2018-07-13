
import java.util.*;
import java.io.*;
import java.lang.reflect.*;
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
public class ExtendedObjectPoolFactory
{
    // 定义一个对象池，前面是对象名，后面是实际对象
    private Map<String ,Object> objectPool = new HashMap<>();
    private Properties config = new Properties();
    // 从指定属性文件中初始化Properties对象
    public void init(String fileName)
    {
        try(
            FileInputStream fis = new FileInputStream(fileName))
        {
            config.load(fis);
        }
        catch (IOException ex)
        {
            System.out.println("读取" + fileName + "异常");
        }
    }
    // 定义一个创建对象的方法
    // 该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象
    private Object createObject(String clazzName)
        throws Exception
    {
        // 根据字符串来获取对应的Class对象
        Class<?> clazz =Class.forName(clazzName);
        // 使用clazz对应类的默认构造器创建实例
        return clazz.getConstructor().newInstance();
    }
    // 该方法根据指定文件来初始化对象池
    // 它会根据配置文件来创建对象
    public void initPool()throws Exception
    {
        for (String name : config.stringPropertyNames())
        {
            // 每取出一个key-value对，如果key中不包含百分号（%）
            // 这就表明是根据value来创建一个对象
            // 调用createObject创建对象，并将对象添加到对象池中
            if (!name.contains("%"))
            {
                objectPool.put(name ,
                    createObject(config.getProperty(name)));
            }
        }
    }
    // 该方法将会根据属性文件来调用指定对象的setter方法
    public void initProperty()throws InvocationTargetException
        ,IllegalAccessException,NoSuchMethodException
    {
        for (String name : config.stringPropertyNames())
        {
            // 每取出一对key-value对，如果key中包含百分号（%）
            // 即可认为该key用于控制调用对象的setter方法设置值
            // %前半为对象名字，后半控制setter方法名
            if (name.contains("%"))
            {
                // 将配置文件中的key按%分割
                String[] objAndProp = name.split("%");
                // 取出调用setter方法的参数值
                Object target = getObject(objAndProp[0]);
                // 获取setter方法名:set + "首字母大写" + 剩下部分
                String mtdName = "set" +
                objAndProp[1].substring(0 , 1).toUpperCase()
                    + objAndProp[1].substring(1);
                // 通过target的getClass()获取它的实现类所对应的Class对象
                Class<?> targetClass = target.getClass();
                // 获取希望调用的setter方法
                Method mtd = targetClass.getMethod(mtdName , String.class);
                // 通过Method的invoke方法执行setter方法
                // 将config.getProperty(name)的值作为调用setter方法的参数
                mtd.invoke(target , config.getProperty(name));
            }
        }
    }
    public Object getObject(String name)
    {
        // 从objectPool中取出指定name对应的对象
        return objectPool.get(name);
    }
    public static void main(String[] args)
        throws Exception
    {
        ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
        epf.init("extObj.txt");
        epf.initPool();
        epf.initProperty();
        System.out.println(epf.getObject("a"));
    }
}


