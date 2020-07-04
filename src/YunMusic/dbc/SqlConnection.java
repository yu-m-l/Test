package YunMusic.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * 负责数据库的连接操作，在进行被类对象实例化时自动进行数据库的连接处理
 * @author MG
 * @version 1.0
 */
public class SqlConnection {
	private static SqlConnection sql = new SqlConnection(); // 声明SQL类的静态实例
	private static final String DBDRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=YunMusic";
	private static final String DBUSER="sa";
	private static final String PASSWORD="123";
	private Connection conn = null; // 定义数据库连接
	/**
	 * 在构造方法调用时将进行数据库连接对象的取得。
	 */
	public SqlConnection() {
		try {
			Class.forName(DBDRIVER); // 加载数据库驱动
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "数据库驱动加载失败。\n" + e.getMessage());
		}
	}
	/**
	 * 取得数据库连接对象
	 * @return 实例化的Connection对象，如果返回null，表示没有连接成功。
	 */
	public Connection getConnection() {
		try {
			conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);//与数据库建立连接
			return conn; // 返回连接
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库连接失败。\n" + e.getMessage());
			return null;
		}
	}
	/**
	 * 进行数据库的关闭操作
	 */
	public void close() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "数据库关闭失败。\n" + e.getMessage());
			}
		}
	}
}
