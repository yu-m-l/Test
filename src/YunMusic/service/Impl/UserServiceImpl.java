package YunMusic.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import YunMusic.VO.userlist;
import YunMusic.dbc.SqlConnection;
import YunMusic.factory.DAOFactory;
import YunMusic.service.IUserService;

/**
 * 取得用户表类对象进行数据库操作
 * @author DELL
 * @version 1.0
 */
public class UserServiceImpl implements IUserService {
	private SqlConnection dbc = new SqlConnection();
	
	@Override
	public boolean enter(String n,String p) throws Exception {
		//利用DAOFactory类中的getIUserDAOInstance方法取得IUserDAO接口对象
        //在调用getIEmpInstance()的时候需要通过SqlConnection对象取得Connection接口对象，传递进去
		//判断用户是否存在，判断密码是否正确
		if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findN(n)) {
			if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findP(n, p)) {
				return true;
			}
        }
		return false;
	}

	@Override
	public boolean register(userlist u) throws Exception {
		//判断用户是否存在，密码是否符合规定，qq是否存在,是否符合规定,账号是否创建成功
		if(!DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findN(u.getUsername())) {
			if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).IsP(u.getPassword())) {
				if(!DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findQ(u.getQq())) {
					if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).IsQ(u.getQq())) {
						if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).doCreate(u)) {
							return true;
						}
					}
				}
			}
        }
		return false;
	}

	@Override
	public String findPassword(String qq) throws Exception {
		return DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).SearchP(qq);
	}
}
