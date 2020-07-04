package YunMusic.Dao;

import YunMusic.VO.userlist;

/**
 * 定义用户表的数据层操作标准
 * @author MG
 * @version 1.0
 */
public interface IUserDAO extends IDAO<userlist>{
	
	/**
	 * 修改用户名
	 * @param u 要修改的用户信息
	 * @param username 修改后的用户名
	 * @return 如果修改成功，返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean doUpdateN(userlist u, String username) throws Exception;

	/**
	 * 修改关联qq号
	 * @param u 要修改的用户信息
	 * @param qq 修改后的qq
	 * @return 如果修改成功，返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean doUpdateQ(userlist u, String qq) throws Exception;

	/**
	 * 修改密码
	 * @param u 要修改的用户信息
	 * @param password 修改后的密码
	 * @return 如果修改成功，返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean doUpdateP(userlist u, String password) throws Exception;

	/**
	 * 判断账号是否已经存在
	 * @param n 要判断的账号名
	 * @return 如果存在，返回true,否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean findN(String n) throws Exception;

	/**
	 * 判断密码是否正确
	 * @param n 要判断的账号名
	 * @param p 要判断的密码
	 * @return 如果正确，返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean findP(String n, String p) throws Exception;

	/**
	 * 判断密码是否符合注册规定
	 * @param p 要判断的密码
	 * @return 如果符合，返回true，否则返回false
	 */
	public boolean IsP(String p);

	/**
	 * 判断qq是否已经存在
	 * @param q 要判断的qq号
	 * @return 如果存在返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean findQ(String q) throws Exception;

	/**
	 * 根据qq找到密码
	 * @param q 要查找的密码所关联的qq号
	 * @return 返回找到的密码，如果没找到返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	String SearchP(String q) throws Exception;
}
