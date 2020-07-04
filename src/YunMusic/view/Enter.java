package YunMusic.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import YunMusic.factory.ServiceFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 用户登录界面
 * @author MG
 * @version 1.0
 */
public class Enter extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enter frame = new Enter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Enter() {
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setBounds(10, 31, 58, 15);
		contentPane.add(label);
		
		username = new JTextField();
		username.setBounds(78, 28, 213, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(10, 84, 58, 15);
		contentPane.add(label_1);
		
		password = new JTextField();
		password.setText("");
		password.setBounds(78, 81, 213, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton Reg = new JButton("\u6CE8\u518C");
		Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register rg=new Register();
				rg.setVisible(true);
				dispose();
			}
		});
		Reg.setBounds(20, 149, 78, 23);
		contentPane.add(Reg);
		
		JButton Ent = new JButton("\u767B\u9646");
		Ent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(new ServiceFactory().getIUserServiceInstance().enter(username.getText(),password.getText())) {
						JOptionPane.showMessageDialog(null, "登录成功");
						new YunPersonCenter(username.getText());
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "用户名或密码错误");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Ent.setBounds(115, 149, 78, 23);
		contentPane.add(Ent);
		
		JButton ZJEnt = new JButton("\u76F4\u63A5\u8FDB\u5165");
		ZJEnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new PersonCenter();
				dispose();
			}
		});
		ZJEnt.setBounds(203, 149, 88, 23);
		contentPane.add(ZJEnt);
		
		JLabel find = new JLabel("\u627E\u56DE\u5BC6\u7801");
		find.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				find f=new find();
				f.setVisible(true);
				dispose();
			}
		});
		find.setFont(new Font("宋体", Font.ITALIC, 15));
		find.setBounds(225, 116, 115, 23);
		contentPane.add(find);
	}
}
