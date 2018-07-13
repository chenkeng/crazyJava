module org.cimodule
{
	// 导出org.crazyit.oa包，以便其他包能使用该包下的服务接口
	exports org.crazyit.oa;
	// 声明该模块提供UserService服务接口
	uses org.crazyit.oa.UserService;
}