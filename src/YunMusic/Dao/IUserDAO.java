package YunMusic.Dao;

import YunMusic.VO.userlist;

/**
 * �����û�������ݲ������׼
 * @author MG
 * @version 1.0
 */
public interface IUserDAO extends IDAO<userlist>{
	
	/**
	 * �޸��û���
	 * @param u Ҫ�޸ĵ��û���Ϣ
	 * @param username �޸ĺ���û���
	 * @return ����޸ĳɹ�������true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean doUpdateN(userlist u, String username) throws Exception;

	/**
	 * �޸Ĺ���qq��
	 * @param u Ҫ�޸ĵ��û���Ϣ
	 * @param qq �޸ĺ��qq
	 * @return ����޸ĳɹ�������true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean doUpdateQ(userlist u, String qq) throws Exception;

	/**
	 * �޸�����
	 * @param u Ҫ�޸ĵ��û���Ϣ
	 * @param password �޸ĺ������
	 * @return ����޸ĳɹ�������true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean doUpdateP(userlist u, String password) throws Exception;

	/**
	 * �ж��˺��Ƿ��Ѿ�����
	 * @param n Ҫ�жϵ��˺���
	 * @return ������ڣ�����true,���򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean findN(String n) throws Exception;

	/**
	 * �ж������Ƿ���ȷ
	 * @param n Ҫ�жϵ��˺���
	 * @param p Ҫ�жϵ�����
	 * @return �����ȷ������true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean findP(String n, String p) throws Exception;

	/**
	 * �ж������Ƿ����ע��涨
	 * @param p Ҫ�жϵ�����
	 * @return ������ϣ�����true�����򷵻�false
	 */
	public boolean IsP(String p);

	/**
	 * �ж�qq�Ƿ��Ѿ�����
	 * @param q Ҫ�жϵ�qq��
	 * @return ������ڷ���true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean findQ(String q) throws Exception;

	/**
	 * ����qq�ҵ�����
	 * @param q Ҫ���ҵ�������������qq��
	 * @return �����ҵ������룬���û�ҵ�����null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	String SearchP(String q) throws Exception;
}
