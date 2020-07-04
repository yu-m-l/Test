package YunMusic.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import YunMusic.factory.ServiceFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

/**
 * 找回密码界面
 * @author MG
 * @version 1.0
 */
public class find extends JFrame {

	private JPanel contentPane;
	private JTextField qq;

	public find() {
		setTitle("\u627E\u56DE\u5BC6\u7801\u754C\u9762");
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
		setBounds(100, 100, 320, 141);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("qq\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 32, 58, 15);
		contentPane.add(lblNewLabel);
		
		qq = new JTextField();
		qq.setBounds(47, 29, 216, 21);
		contentPane.add(qq);
		qq.setColumns(10);
		
		JButton search = new JButton("\u627E\u56DE");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw=null;
				try {
					pw=new ServiceFactory().getIUserServiceInstance().findPassword(qq.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if(pw!=null) {
					JOptionPane.showMessageDialog(null, "你的密码是:“"+pw+"”,请进入登录界面进行登录");
					Enter en=new Enter();
					en.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Sorry,该QQ号未曾注册过");
				}
			}
		});
		search.setBounds(188, 60, 77, 23);
		contentPane.add(search);
	}

}
