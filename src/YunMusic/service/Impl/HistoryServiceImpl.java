package YunMusic.service.Impl;

import java.io.File;
import java.util.ArrayList;

import YunMusic.VO.History;
import YunMusic.dbc.SqlConnection;
import YunMusic.factory.DAOFactory;
import YunMusic.service.IHistoryService;
/**
 * 取得播放列表类对象进行数据库操作
 * @author DELL
 * @version 1.0
 */
public class HistoryServiceImpl implements IHistoryService{
	private SqlConnection dbc = new SqlConnection();
	
	@Override
	public boolean AddMusic(History h) throws Exception {
		//利用DAOFactory类中的getIHisoryDAOInstance方法取得IHistoryDAO接口对象
		//判断音乐是否存在，不存在添加
		if(!DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).doFind(h)) {
			if(DAOFactory.getIHisoryDAOInstance(this.dbc.getConnection()).doCreate(h)) {
				return true;
			}
        }
		return false;
	}

	@Override
	public boolean DelMusic(History h) throws Exception {
		//判断音乐是否存在，存在删除
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
		String s="F:\\娱乐\\java\\Java课设\\音乐\\";//存放音乐的文件夹
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
