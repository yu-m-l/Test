package YunMusic.VO;

import java.io.Serializable;

/**
 * �û���Ϣ��
 * @author MG
 * @version 1.0
 */
public class userlist implements Serializable{
	private String username;	// �û���
	private String qq;		   // ����qq��
	private String password;  // ����
	
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
