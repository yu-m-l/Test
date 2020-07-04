package YunMusic.service;

import YunMusic.VO.userlist;

/**
 * 定义用户表的业务层操作标准
 * @author MG
 * @version 1.0
 */
public interface IUserService {
	/**
	 * 用户登录操作
	 * @param n 登录人员的用户名
	 * @param p 登录人员的密码
	 * @return 如果登录成功，返回true,否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean enter(String n,String p) throws Exception;
	
	/**
	 * 用户注册操作
	 * @param u 包含了要注册人员的数据信息
	 * @return 如果注册成功，返回true,否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public boolean register(userlist u) throws Exception;
	
	/**
	 * 根据qq号找回密码操作
	 * @param qq 要查找密码的账号所关联的qq号
	 * @return 返回查找到的密码，如果没找到返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException,如果SQL语句错误抛出SQLException
	 */
	public String findPassword(String qq) throws Exception;
}
