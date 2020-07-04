package YunMusic.Dao;

import java.util.ArrayList;

import YunMusic.VO.History;
/**
 * ���岥���б�����ݲ����
 * @author DELL
 * @version 1.0
 */
public interface IHistoryDAO extends IDAO<History>{
	/**
	 * ���Ҹ����Ƿ����ڱ���
	 * @param h Ҫ���ҵĸ�����Ϣ
	 * @return ����ҵ�����true,���򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean doFind(History h) throws Exception;
	
	/**
	 * ���ұ�����������
	 * @param u Ҫ���ҵ����ֵ��û���
	 * @return �ҵ��������������Ƽ���
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public ArrayList<String> FindMusic(String u) throws Exception;
}
