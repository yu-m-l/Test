package YunMusic.test.util;

import java.util.Random;

import YunMusic.VO.userlist;
import YunMusic.factory.ServiceFactory;
/**
 * ���ݿ�����������
 * @author MG
 * @version 1.0
 */
public class AddSql {

	public static void main(String[] args)
	{
		userlist u=new userlist();
		String name="Zym";//�û���
		int name2=0; 
		String pn="lili";//����ǰ���
		int pn2=0;//�������
		long qq=0l;
		Random rs=new Random();
		for(int i=0;i<1000;i++) {
			pn2=(int)(Math.random()*1000000)+100;
			name2=rs.nextInt(10000)+1;
			qq=(long)(Math.random()*1000000000000l)+100000000;
			u.setPassword(pn+pn2);
			u.setUsername(name+name2);
			u.setQq(String.valueOf(qq));
			try {
				new ServiceFactory().getIUserServiceInstance().register(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ok");
	}
}
