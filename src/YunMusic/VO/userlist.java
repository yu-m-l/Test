package YunMusic.VO;

import java.io.Serializable;

/**
 * 用户信息表
 * @author MG
 * @version 1.0
 */
public class userlist implements Serializable{
	private String username;	// 用户名
	private String qq;		   // 关联qq号
	private String password;  // 密码
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getQq() {
		return qq;
	}
	
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
