package YunMusic.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import YunMusic.Dao.IUserDAO;
import YunMusic.VO.userlist;

/**
 * 用户表数据层子类，要想操作，一定要在构造方法中传入Connection接口对象
 * @author MG
 * @version 1.0
 */
public class UserDAOImpl implements IUserDAO {
	private Connection conn;		 //数据库连接对象
	private PreparedStatement pstmt; // 数据库操作对象
	
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public UserDAOImpl(Connection conn) {
		this.conn=conn;
	}
	
	 @Override
	 public boolean doCreate(userlist u) throws Exception {
        String sql = "INSERT INTO userlist(username,qq,password) VALUES (?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, u.getUsername());
        this.pstmt.setString(2, u.getQq());
        this.pstmt.setString(3, u.getPassword());
        return this.pstmt.executeUpdate() > 0;
	 }

    @Override
    public boolean doUpdateN(userlist u,String username) throws Exception {
        String sql = "UPDATE userlist SET username=?,qq = ?,password = ? WHERE username = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, username);
        this.pstmt.setString(2, u.getQq());
        this.pstmt.setString(3, u.getPassword());
        this.pstmt.setString(4, u.getUsername());
        return this.pstmt.executeUpdate() > 0;
    }
    
    @Override
    public boolean doUpdateQ(userlist u,String qq) throws Exception {
        String sql = "UPDATE userlist SET username=?,qq = ?,password = ? WHERE username = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, u.getUsername());
        this.pstmt.setString(2, qq);
        this.pstmt.setString(3, u.getPassword());
        this.pstmt.setString(4, u.getUsername());
        return this.pstmt.executeUpdate() > 0;
    }
    
    @Override
    public boolean doUpdateP(userlist u,String password) throws Exception {
        String sql = "UPDATE userlist SET username=?,qq = ?,password = ? WHERE username = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, u.getUsername());
        this.pstmt.setString(2, u.getQq());
        this.pstmt.setString(3, password);
        this.pstmt.setString(4, u.getUsername());
        return this.pstmt.executeUpdate() > 0;
    }
    
    @Override
    public boolean doRemove(userlist u) throws Exception {
    	String sql = "Delete from userlist WHERE username = ?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1, u.getUsername());
        return this.pstmt.executeUpdate()>0; 
    }

    @Override
    public boolean findN(String n) throws Exception{
    	String sql = "Select username from userlist WHERE username = ?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1, n);
    	ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
    }
    
    @Override
    public boolean findP(String n,String p) throws Exception{
    	String sql = "Select password from userlist WHERE username = ?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1, n);
    	ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			if(p.equals(rs.getString(1))) {
				return true;
			}
		}
		return false;
    }
    
    @Override
    public boolean IsP(String p){
    	if(p.length()<6||p.matches("[0-9]+")||p.matches("[a-zA-Z]+")) {
    		return false;
    	}
    	return true;
    }
    
    @Override
    public boolean findQ(String q) throws Exception{
    	String sql = "Select qq from userlist WHERE qq = ?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1, q);
    	ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
    }
    
    @Override
    public String SearchP(String q) throws Exception{//根据qq找密码
    	String sql = "Select password from userlist WHERE qq = ?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1, q);
    	ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}
		return null;
    }
}
