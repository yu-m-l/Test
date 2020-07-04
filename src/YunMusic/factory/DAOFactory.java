package YunMusic.factory;

import java.sql.Connection;

import YunMusic.Dao.IHistoryDAO;
import YunMusic.Dao.IUserDAO;
import YunMusic.Dao.Impl.HistoryDAOImpl;
import YunMusic.Dao.Impl.UserDAOImpl;

/**
 * 数据层工厂类
 * @author MG
 * @version 1.0
 */
public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(Connection conn) {
		return new UserDAOImpl(conn);
	}
	public static IHistoryDAO getIHisoryDAOInstance(Connection conn) {
		return new HistoryDAOImpl(conn);
	}
}
