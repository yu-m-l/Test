package YunMusic.VO;

import java.io.Serializable;

/**
 * �����б��
 * @author MG
 * @version 1.0
 */
public class History implements Serializable{
	private String username;	//�û���
	private String Uname;	   //�����������������
	private String id;		  //�������������id
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUname() {
		return Uname;
	}
	
	public void setUname(String uname) {
		Uname = uname;
	}
}
