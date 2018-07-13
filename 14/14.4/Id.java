
import java.lang.annotation.*;
/**
 * Description:
 * 利嫋: <a href="http://www.crazyit.org">決髄Java選男</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Id
{
	String column();
	String type();
	String generator();
}

