package YunMusic.service;

import java.io.File;
import java.util.ArrayList;

import YunMusic.VO.History;

/**
 * 定义播放列表表的业务层操作标准
 * @author MG
 * @version 1.0
 */
public interface IHistoryService {
	/**
	 * 添加歌曲
	 * @param h 包含要添加的歌曲信息
	 * @return 如果添加成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean AddMusic(History h) throws Exception;
	
	/**
	 * 删除歌曲
	 * @param h 包含要删除的歌曲信息
	 * @return 如果删除成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean DelMusic(History h) throws Exception;
	
	/**
	 * 查找表中所有音乐
	 * @param u 要查找的音乐的用户名
	 * @return 找到的所有音乐名称的文件集合
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public ArrayList<File> findMusicF(String u) throws Exception;
	
	/**
	 * 查找表中所有音乐
	 * @param u 要查找的音乐的用户名
	 * @return 找到的所有音乐名称集合
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public ArrayList<String> findMusicS(String u) throws Exception;
}
