package YunMusic.Dao;

/**
 * 定义数据层的公共操作
 * @author MG
 * @param <V> 要操作的vo类型
 * @version 1.0
 */
public interface IDAO<V>{
	/**
	 * 数据增加操作
	 * @param v 包含了要添加的数据信息
	 * @return 如果数据添加成功，返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean doCreate(V v) throws Exception;
	
	/**
	 * 数据删除操作
	 * @param v 包含了要删除的数据信息
	 * @return 如果数据删除成功，返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean doRemove(V v) throws Exception;
}
