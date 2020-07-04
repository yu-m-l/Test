package YunMusic.service;

import java.io.File;
import java.util.ArrayList;

import YunMusic.VO.History;

/**
 * ���岥���б���ҵ��������׼
 * @author MG
 * @version 1.0
 */
public interface IHistoryService {
	/**
	 * ��Ӹ���
	 * @param h ����Ҫ��ӵĸ�����Ϣ
	 * @return �����ӳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean AddMusic(History h) throws Exception;
	
	/**
	 * ɾ������
	 * @param h ����Ҫɾ���ĸ�����Ϣ
	 * @return ���ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean DelMusic(History h) throws Exception;
	
	/**
	 * ���ұ�����������
	 * @param u Ҫ���ҵ����ֵ��û���
	 * @return �ҵ��������������Ƶ��ļ�����
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public ArrayList<File> findMusicF(String u) throws Exception;
	
	/**
	 * ���ұ�����������
	 * @param u Ҫ���ҵ����ֵ��û���
	 * @return �ҵ��������������Ƽ���
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public ArrayList<String> findMusicS(String u) throws Exception;
}
