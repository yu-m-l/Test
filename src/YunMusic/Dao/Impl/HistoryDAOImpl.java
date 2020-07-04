package YunMusic.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import YunMusic.Dao.IHistoryDAO;
import YunMusic.VO.History;

/**
 * 播放列表数据层子类
 * @author MG
 * @version 1.0
 */
public class HistoryDAOImpl implements IHistoryDAO{
	private Connection conn;		 //数据库连接对象
	private PreparedStatement pstmt; // 数据库操作对象
	
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public HistoryDAOImpl(Connection conn) {
		this.conn=conn;
	}
	
	public boolean doCreate(History h) throws Exception{
		String sql = "INSERT INTO History(username,Uname,id) VALUES (?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, h.getUsername());
        this.pstmt.setString(2, h.getUname());
        this.pstmt.setString(3, h.getId());
        return this.pstmt.executeUpdate() > 0;
	}
	
	public boolean doRemove(History h) throws Exception{
		String sql = "Delete from History WHERE id = ? and username=?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1, h.getId());
    	this.pstmt.setString(2, h.getUsername());
        return this.pstmt.executeUpdate()>0; 
	}

	@Override
	public boolean doFind(History h) throws Exception {
		String sql="Select id from History Where id=? and username=?";
		this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, h.getId());
        this.pstmt.setString(2, h.getUsername());
        ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> FindMusic(String u) throws Exception{
		String sql="Select Uname from History Where username=?";
		this.pstmt=this.conn.prepareStatement(sql);
		 this.pstmt.setString(1,u);
		ResultSet rs=pstmt.executeQuery();
		ArrayList<String> al=new ArrayList<String>();
		while(rs.next()) {
			al.add(rs.getString("Uname"));
		}
		return al;
	}
}
