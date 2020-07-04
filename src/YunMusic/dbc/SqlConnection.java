package YunMusic.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * �������ݿ�����Ӳ������ڽ��б������ʵ����ʱ�Զ��������ݿ�����Ӵ���
 * @author MG
 * @version 1.0
 */
public class SqlConnection {
	private static SqlConnection sql = new SqlConnection(); // ����SQL��ľ�̬ʵ��
	private static final String DBDRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=YunMusic";
	private static final String DBUSER="sa";
	private static final String PASSWORD="123";
	private Connection conn = null; // �������ݿ�����
	/**
	 * �ڹ��췽������ʱ���������ݿ����Ӷ����ȡ�á�
	 */
	public SqlConnection() {
		try {
			Class.forName(DBDRIVER); // �������ݿ�����
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "���ݿ���������ʧ�ܡ�\n" + e.getMessage());
		}
	}
	/**
	 * ȡ�����ݿ����Ӷ���
	 * @return ʵ������Connection�����������null����ʾû�����ӳɹ���
	 */
	public Connection getConnection() {
		try {
			conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);//�����ݿ⽨������
			return conn; // ��������
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���ݿ�����ʧ�ܡ�\n" + e.getMessage());
			return null;
		}
	}
	/**
	 * �������ݿ�Ĺرղ���
	 */
	public void close() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "���ݿ�ر�ʧ�ܡ�\n" + e.getMessage());
			}
		}
	}
}
