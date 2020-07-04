package YunMusic.Dao;

import java.util.ArrayList;

import YunMusic.VO.History;
/**
 * 定义播放列表的数据层操作
 * @author DELL
 * @version 1.0
 */
public interface IHistoryDAO extends IDAO<History>{
	/**
	 * 查找歌曲是否已在表中
	 * @param h 要查找的歌曲信息
	 * @return 如果找到返回true,否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean doFind(History h) throws Exception;
	
	/**
	 * 查找表中所有音乐
	 * @param u 要查找的音乐的用户名
	 * @return 找到的所有音乐名称集合
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public ArrayList<String> FindMusic(String u) throws Exception;
}
