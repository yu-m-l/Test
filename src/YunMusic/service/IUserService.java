package YunMusic.service;

import YunMusic.VO.userlist;

/**
 * �����û����ҵ��������׼
 * @author MG
 * @version 1.0
 */
public interface IUserService {
	/**
	 * �û���¼����
	 * @param n ��¼��Ա���û���
	 * @param p ��¼��Ա������
	 * @return �����¼�ɹ�������true,���򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean enter(String n,String p) throws Exception;
	
	/**
	 * �û�ע�����
	 * @param u ������Ҫע����Ա��������Ϣ
	 * @return ���ע��ɹ�������true,���򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean register(userlist u) throws Exception;
	
	/**
	 * ����qq���һ��������
	 * @param qq Ҫ����������˺���������qq��
	 * @return ���ز��ҵ������룬���û�ҵ�����null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public String findPassword(String qq) throws Exception;
}
