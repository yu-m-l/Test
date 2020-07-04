package YunMusic.service.Impl;

import java.io.File;
import java.util.ArrayList;

import YunMusic.VO.History;
import YunMusic.dbc.SqlConnection;
import YunMusic.factory.DAOFactory;
import YunMusic.service.IHistoryService;
/**
 * ȡ�ò����б������������ݿ����
 * @author DELL
 * @version 1.0
 */
public class HistoryServiceImpl implements IHistoryService{
	private SqlConnection dbc = new SqlConnection();
	
	@Override
	public boolean AddMusic(History h) throws Exception {
		//����DAOFactory���е�getIHisoryDAOInstance����ȡ��IHistoryDAO�ӿڶ���
		//�ж������Ƿ���ڣ����������
		if(!DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).doFind(h)) {
			if(DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).doCreate(h)) {
				return true;
			}
        }
		return false;
	}

	@Override
	public boolean DelMusic(History h) throws Exception {
		//�ж������Ƿ���ڣ�����ɾ��
		if(DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).doFind(h)) {
			if(DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).doRemove(h)) {
				return true;
			}
        }
		return false;
	}

	@Override
	public ArrayList<File> findMusicF(String u) throws Exception
	{
		ArrayList<String> als=DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).FindMusic(u);
		ArrayList<File> alf=new ArrayList<File>();
		String s="F:\\����\\java\\Java����\\����\\";//������ֵ��ļ���
		File f=null;
		if(als!=null) {
			for(String as:als) {
				f=new File(s+as);
				alf.add(f);
			}
		}
		return alf;
	}

	@Override
	public ArrayList<String> findMusicS(String u) throws Exception
	{
		return DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).FindMusic(u);
	}
}
