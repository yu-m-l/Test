package YunMusic.view;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import YunMusic.VO.History;
import YunMusic.factory.DAOFactory;
import YunMusic.factory.ServiceFactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;

import javax.media.CannotRealizeException;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

/**
 * ��¼��������Ľ���
 * @author MG
 * @version 1.0
 */
public class YunPersonCenter implements ActionListener, ControllerListener{
	JFrame frame = new JFrame();
	private JPanel contentPane;
	private JButton beforeM = new JButton("��һ��");
	JButton afterM = new JButton("��һ��");
	JButton SelectPlay = new JButton("��ͣ");
	JButton AddM = new JButton("�������");
	JButton DelM = new JButton("ɾ������");
	List playlist = new List(20);// �����б�ֻչʾ20��
	String[] s = { "˳�򲥷�", "����ѭ��", "�������" };
	JComboBox PlayStyle = new JComboBox(s);// ѡ�񲥷�ģʽ
	History h=new History(); //��Ӹ�����Ϣ

	static int index; // �����б���±�
	int count; // ��ǲ����б��е��ܸ�����
	int flag; // �����������Ż���˳�򲥷�
	public File MusicName = null; // ��ȡҪ���ŵ�����
	public java.util.List<File> MusicNames = new ArrayList<File>(); // ���÷��ͣ�����File����
	File currentDirectory = null;

	Random rand = new Random(); // ��ȡ���ֵ
	JFileChooser fileChooser = new JFileChooser();// �ļ�ѡ���
	Player player = null;// ���ֲ���
	private final JLabel label = new JLabel("�����б�:");
	private final JMenuItem Su1 = new JMenuItem("\u968F\u673A\u64AD\u653E");
	private final JMenu SelectM = new JMenu("\u6B4C\u66F2\u9009\u62E9");
	private final JMenuItem beforeM1 = new JMenuItem("\u4E0A\u4E00\u9996");
	private final JMenuItem afterM1 = new JMenuItem("\u4E0B\u4E00\u9996");
	JMenu playstyle1 = new JMenu("\u64AD\u653E\u65B9\u5F0F");
	JButton beforeM2 = new JButton("\u4E0A\u4E00\u9996");
	JButton Su2 = new JButton("\u968F\u673A\u64AD\u653E");
	JButton AddM1 = new JButton("\u6DFB\u52A0\u97F3\u4E50");
	JButton Dan2 = new JButton("\u5355\u66F2\u5FAA\u73AF");
	JButton Shu2 = new JButton("\u987A\u5E8F\u64AD\u653E");
	JButton afterM2 = new JButton("\u4E0B\u4E00\u9996");
	JMenuItem Shu1 = new JMenuItem("\u987A\u5E8F\u64AD\u653E");
	JMenuItem Dan1 = new JMenuItem("\u5355\u66F2\u5FAA\u73AF");
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();

	public YunPersonCenter(String u) {
		frame.setTitle("YunMusic");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 570);
		frame.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menuBar.add(playstyle1);
		
		playstyle1.add(Shu1);
		playstyle1.add(Dan1);
		playstyle1.add(Su1);
		
		menuBar.add(SelectM);

		SelectM.add(beforeM1);
		SelectM.add(afterM1);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(3, 0, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 25);
		contentPane.add(toolBar);
		
		toolBar.add(beforeM2);
		toolBar.addSeparator(new Dimension(10, 50));
		
		toolBar.add(afterM2);
		toolBar.addSeparator(new Dimension(10, 50));
		
		toolBar.add(Shu2);
		toolBar.addSeparator(new Dimension(10, 50));
		
		toolBar.add(Dan2);
		toolBar.addSeparator(new Dimension(10, 50));
		
		toolBar.add(Su2);
		toolBar.addSeparator(new Dimension(10, 50));
		
		toolBar.add(AddM1);
		panel.setBounds(10, 66, 127, 362);
		
		contentPane.add(panel);
		panel.setLayout(null);
		AddM.setBounds(10, 87, 97, 37);
		panel.add(AddM);
		SelectPlay.setBounds(10, 175, 97, 37);
		panel.add(SelectPlay);
		DelM.setBounds(10, 253, 97, 37);
		panel.add(DelM);
		panel_1.setBounds(10, 437, 380, 56);

		contentPane.add(panel_1);
		panel_1.setLayout(null);
		beforeM.setBounds(10, 10, 97, 37);
		panel_1.add(beforeM);
		afterM.setBounds(273, 10, 97, 37);
		panel_1.add(afterM);

		String box = (String) PlayStyle.getSelectedItem();
		PlayStyle.setBounds(142, 10, 97, 37);
		panel_1.add(PlayStyle);
		PlayStyle.setModel(new DefaultComboBoxModel(new String[] { "˳�򲥷�", "����ѭ��", "�������" }));
		panel_2.setBounds(142, 35, 262, 399);

		contentPane.add(panel_2);
		panel_2.setLayout(null);
		playlist.setBounds(10, 27, 242, 362);
		panel_2.add(playlist);
		label.setBounds(10, 0, 109, 24);
		panel_2.add(label);
		
		h.setUsername(u);//�Ȱ��û�����ס
		try {
			MusicNames=new ServiceFactory().getIHistoryServiceInstance().findMusicF(u);//�����ݿ��а����ֶ�ȡ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		//��������ӽ��б�
		try {
			ArrayList<String> muns=new ServiceFactory().getIHistoryServiceInstance().findMusicS(u);
			for(String mn:muns) {
				playlist.add(mn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		playlist.addActionListener(this);
		PlayStyle.addActionListener(this);
		afterM.addActionListener(this);
		beforeM.addActionListener(this);
		DelM.addActionListener(this);
		SelectPlay.addActionListener(this);
		AddM.addActionListener(this);
		
		
		beforeM1.addActionListener(this);
		afterM1.addActionListener(this);
		beforeM2.addActionListener(this);
		afterM2.addActionListener(this);
		
		Su1.addActionListener(this);
		Shu1.addActionListener(this);
		Dan1.addActionListener(this);
		Shu2.addActionListener(this);
		Dan2.addActionListener(this);
		Su2.addActionListener(this);
		AddM1.addActionListener(this);
	}

	/**
	 * ��һ��ʵ�ֺ���
	 */
	private void PreviousMusic()
	{
		player.stop();
		index--;
		if (index < 0)
		{
			index = MusicNames.size() - 1;
		}
		PlayFile();
	}

	/**
	 * ��һ��ʵ�ֺ���
	 */
	private void nextMusic()
	{
		player.stop();
		index++;
		if (index == MusicNames.size())
		{
			index = 0;
		}
		PlayFile();
	}

	/**
	 * ����MP3�ļ�������
	 */
	public void PlayFile()
	{
		try {
			player = Manager.createRealizedPlayer(MusicNames.get(index).toURI().toURL());
			player.prefetch();// playerʵ������ɺ����player����ǰԤ����
			player.setMediaTime(new Time(0.0));// ��ĳ��ʱ��ο�ʼ����
			player.addControllerListener(this);
			player.start();
			playlist.select(index);
		} catch (Exception e1) { // ��ѡ��һ�����ֲ��ܲ���ʱ��������д���
			dealError();
			return;
		}
	}

	/**
	 * �����ų���ʱ
	 */
	private void dealError()
	{
		MusicNames.remove(index);
		if (--count == index) {// �պ������һ�׳���
			index = 0;
		}
		if (count == 0) {// �ļ�û��ѡ��ɹ�
			player = null;
		} else {
			PlayFile();
		}
	}

	@Override
	public void controllerUpdate(ControllerEvent e)
	{
		String box = (String) PlayStyle.getSelectedItem(); // �жϲ��ŵķ�ʽ
		if (e instanceof EndOfMediaEvent)
		{
			player.setMediaTime(new Time(0));
			if ("����ѭ��".equals(box))
			{
				player.start();
			}
			if ("˳�򲥷�".equals(box))
			{
				nextMusic();
			}
			if ("�������".equals(box))
			{
				if (MusicNames != null && !MusicNames.isEmpty())
				{
					int index = (int) rand.nextInt(MusicNames.size()) + 1;
					try
					{
						player = Manager.createRealizedPlayer(MusicNames.get(index).toURI().toURL());
						playlist.select(index);
						player.prefetch();
						player.addControllerListener(this);
						player.start();
						flag = 1;
					} catch (NoPlayerException | CannotRealizeException | IOException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();                   //ͨ����ȡ�ַ������ж��ǲ��Ż�����ͣ��
		String box = (String) PlayStyle.getSelectedItem(); // �жϲ��ŵķ�ʽ
        if(e.getSource()==AddM||e.getSource()==AddM1)//�������
        {
        	fileChooser.setFileFilter(new FileNameExtensionFilter("WAV & MP3 MUSIC", "mp3", "wav"));// ֻ����ѡ��mp3���ļ�
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {// ���ļ��Ի��򣬲�ȷ��
				MusicName = fileChooser.getSelectedFile();// ������ѡ�ļ�
				MusicNames.add(MusicName);// ���ļ��ŵ�����Ŀ¼��
				playlist.add(MusicName.getName());// ������������ӽ������б�
				index = MusicNames.indexOf(MusicName); // ����������±�
				count = MusicNames.size();// ����������Ŀ
				h.setId(String.valueOf(index));
				h.setUname(MusicName.getName());
				try {
					new ServiceFactory().getIHistoryServiceInstance().AddMusic(h);//�������Ƽӽ����ݿ�
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (player == null) {//��ѡ���ǵ�һ�׸�ʱ�Ų���һ�£�������ʱֱ�Ӳ���֮ǰ��
				PlayFile();
			}
        }

        if (cmd.equals("��ͣ")) {
			SelectPlay.setText("����");
			player.stop();
		}
		if (cmd.equals("����")) {
			SelectPlay.setText("��ͣ");
			player.start();
		}

        if(e.getSource()==afterM||e.getSource()==afterM1||e.getSource()==afterM2){        //��һ��
			if (player != null) {
				if ("�������".equals(box)) {
					int index = rand.nextInt(MusicNames.size() - 1);// 0-MusicNames.size()-1
					if (MusicNames != null && !MusicNames.isEmpty()) {
						// �����������ǵ�ǰ����
						if (++index == MusicNames.size()) {
							index = rand.nextInt(MusicNames.size() - 1);
						}
						player.stop(); // �������һ�����򽫵�ǰ�ĸ���ֹͣ���ţ�������һ��
						try {
							player = Manager.createRealizedPlayer(MusicNames.get(index).toURI().toURL());
							playlist.select(index);
							player.addControllerListener(this);
							player.prefetch();
							player.start();
							flag = 1;
						} catch (NoPlayerException | CannotRealizeException | IOException e1) {
							e1.printStackTrace();
						}
					}
				} else {// ˳���ѭ������ֱ����һ��
					nextMusic();
				}
			}
        }
        if(e.getSource()==beforeM||e.getSource()==beforeM1||e.getSource()==beforeM2){       //��һ��
        	if (player != null) {
				if ("�������".equals(box)) {
					int index = (int) rand.nextInt(MusicNames.size()) + 1;
					if (MusicNames != null && !MusicNames.isEmpty()) {
						if (index-- == (int) rand.nextInt(MusicNames.size()) + 1) {
							index = MusicNames.size() - 1;
						}
						player.stop(); // �������һ�����򽫵�ǰ�ĸ���ֹͣ���ţ�������һ��
						try {
							player = Manager.createRealizedPlayer(MusicNames.get(index).toURI().toURL());
							playlist.select(index);
							player.prefetch();
							player.addControllerListener(this);
							player.start();
							flag = 1;
						} catch (NoPlayerException | CannotRealizeException | IOException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					PreviousMusic();
				}
			}
        }
        
        if(e.getSource()==DelM){             //ɾ������
        	index = playlist.getSelectedIndex();
			playlist.remove(index);
			MusicNames.remove(index);
			try {
				new ServiceFactory().getIHistoryServiceInstance().DelMusic(h);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        }

        //˫���б�ʱʵ�ֲ���
        playlist.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	// ˫��ʱ����
				if (e.getClickCount() == 2) {
					if (player != null) {
						player.stop();
					}
					// ����ѡ�е��ļ�
					index = playlist.getSelectedIndex();
					//�������/��ͣ��ť�ǲ��ţ�����ĳ���ͣ
					if (cmd.equals("����")) {
						SelectPlay.setText("��ͣ");
					}
					PlayFile();
				}
            }
        });
        
        if(e.getSource()==Shu1||e.getSource()==Shu2) {
        	PlayStyle.setSelectedIndex(0);
        }
        if(e.getSource()==Dan1||e.getSource()==Dan2) {
        	PlayStyle.setSelectedIndex(1);
        }
        if(e.getSource()==Su1||e.getSource()==Su2) {
        	PlayStyle.setSelectedIndex(2);
        }
	}
}
