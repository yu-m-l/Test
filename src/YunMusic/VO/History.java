package YunMusic.VO;

import java.io.Serializable;

/**
 * 播放列表表
 * @author MG
 * @version 1.0
 */
public class History implements Serializable{
	private String username;	//用户名
	private String Uname;	   //最近听过的音乐名称
	private String id;		  //最近听过的音乐id
	
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
