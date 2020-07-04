package YunMusic.factory;

import YunMusic.service.IHistoryService;
import YunMusic.service.IUserService;
import YunMusic.service.Impl.HistoryServiceImpl;
import YunMusic.service.Impl.UserServiceImpl;

/**
 * 业务层工厂类
 * @author MG
 * @version 1.0
 */
public class ServiceFactory {
	public static IUserService getIUserServiceInstance() {
		return new UserServiceImpl();
	}
	public static IHistoryService getIHistoryServiceInstance() {
		return new HistoryServiceImpl();
	}
}
