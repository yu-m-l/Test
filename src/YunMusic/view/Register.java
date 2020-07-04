package YunMusic.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import YunMusic.VO.History;
import YunMusic.VO.userlist;
import YunMusic.factory.ServiceFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
/**
 * 用户注册界面
 * @author MG
 * @version 1.0
 */
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField qq;

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("\u6CE8\u518C\u754C\u9762");
		addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent arg0){}
			public void windowClosed(WindowEvent arg0){}
			public void windowClosing(WindowEvent arg0)
			{
				Enter e=new Enter();
				e.setVisible(true);
				dispose();
			}
			public void windowDeactivated(WindowEvent arg0){}
			public void windowDeiconified(WindowEvent arg0){}
			public void windowIconified(WindowEvent arg0){}
			public void windowOpened(WindowEvent arg0){}
		});
		setBounds(100, 100, 299, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setBounds(10, 27, 58, 15);
		contentPane.add(label);
		
		username = new JTextField();
		username.setBounds(78, 24, 155, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(10, 59, 58, 15);
		contentPane.add(label_1);
		
		password = new JTextField();
		password.setText("\u5927\u4E8E6\u4F4D\uFF0C\u4E14\u82F1\u6587\u6570\u5B57\u6DF7\u6742");
		password.setBounds(78, 56, 155, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblQq = new JLabel("qq\uFF1A");
		lblQq.setFont(new Font("宋体", Font.PLAIN, 15));
		lblQq.setBounds(10, 84, 58, 15);
		contentPane.add(lblQq);
		
		qq = new JTextField();
		qq.setBounds(78, 81, 155, 21);
		contentPane.add(qq);
		qq.setColumns(10);
		
		JButton Sure = new JButton("\u786E\u5B9A");
		Sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlist ul=new userlist();
				ul.setPassword(password.getText());
				ul.setQq(qq.getText());
				ul.setUsername(username.getText());
				try {
					if(new ServiceFactory().getIUserServiceInstance().register(ul)) {
						JOptionPane.showMessageDialog(null, "恭喜你注册成功,请前往登录界面进行登录");
						Enter en=new Enter();
						en.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Sorry,你的账号已存在或密码不符合要求");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		Sure.setBounds(10, 123, 97, 23);
		contentPane.add(Sure);
		
		JButton quit = new JButton("\u9000\u51FA");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enter en=new Enter();
				en.setVisible(true);
				dispose();
			}
		});
		quit.setBounds(136, 123, 97, 23);
		contentPane.add(quit);
	}

}
