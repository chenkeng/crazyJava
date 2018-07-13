
import org.crazyit.oa.UserService;
import org.crazyit.oa.senior.UserServiceSenior;
/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0
 */
module org.cimodule.senior
{
	// 指定依赖服务接口所在的模块
	requires org.cimodule;
	// 为UserService服务接口提供UserServiceSenior实现类
	provides UserService with UserServiceSenior;
}
