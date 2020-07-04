package YunMusic.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import YunMusic.VO.userlist;
import YunMusic.dbc.SqlConnection;
import YunMusic.factory.DAOFactory;
import YunMusic.service.IUserService;

/**
 * ȡ���û��������������ݿ����
 * @author DELL
 * @version 1.0
 */
public class UserServiceImpl implements IUserService {
	private SqlConnection dbc = new SqlConnection();
	
	@Override
	public boolean enter(String n,String p) throws Exception {
		//����DAOFactory���е�getIUserDAOInstance����ȡ��IUserDAO�ӿڶ���
        //�ڵ���getIEmpInstance()��ʱ����Ҫͨ��SqlConnection����ȡ��Connection�ӿڶ��󣬴��ݽ�ȥ
		//�ж��û��Ƿ���ڣ��ж������Ƿ���ȷ
		if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findN(n)) {
			if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findP(n, p)) {
				return true;
			}
        }
		return false;
	}

	@Override
	public boolean register(userlist u) throws Exception {
		//�ж��û��Ƿ���ڣ������Ƿ���Ϲ涨��qq�Ƿ����,�Ƿ���Ϲ涨,�˺��Ƿ񴴽��ɹ�
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
