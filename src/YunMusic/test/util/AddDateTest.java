package YunMusic.test.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import YunMusic.VO.userlist;
import YunMusic.dbc.SqlConnection;
import YunMusic.factory.DAOFactory;
import junit.framework.TestCase;

/**
 * 生成一万条数据
 * @author MG
 * @version 1.0
 */
class AddDateTest {
	private SqlConnection dbc = new SqlConnection();
	userlist ul=new userlist();
	/**
	 * 将数据存进数据库
	 */
	@Test
	void testDoCreate()
	{
		for(int i=0;i<10000;i++) {
			ul.setUsername(new AddSql().getName());
			ul.setPassword(new AddSql().getPass());
			ul.setQq(new AddSql().getQqname());
			try {
				if(!DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findN(ul.getUsername())) {
					if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).IsP(ul.getPassword())) {
						try {
							if(!DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).findQ(ul.getQq())) {
								if(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).IsQ(ul.getQq())) {
									TestCase.assertTrue(DAOFactory.getIUserDAOInstance(this.dbc.getConnection()).doCreate(ul));
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
