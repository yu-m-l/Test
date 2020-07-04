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
 * 登录后个人中心界面
 * @author MG
 * @version 1.0
 */
public class YunPersonCenter implements ActionListener, ControllerListener{
	JFrame frame = new JFrame();
	private JPanel contentPane;
	private JButton beforeM = new JButton("上一首");
	JButton afterM = new JButton("下一首");
	JButton SelectPlay = new JButton("暂停");
	JButton AddM = new JButton("添加音乐");
	JButton DelM = new JButton("删除音乐");
	List playlist = new List(20);// 播放列表，只展示20首
	String[] s = { "顺序播放", "单曲循环", "随机播放" };
	JComboBox PlayStyle = new JComboBox(s);// 选择播放模式
	History h=new History(); //添加歌曲信息

	static int index; // 播放列表的下标
	int count; // 标记播放列表中的总歌曲数
	int flag; // 标记是随机播放还是顺序播放
	public File MusicName = null; // 获取要播放的音乐
	public java.util.List<File> MusicNames = new ArrayList<File>(); // 运用泛型，创建File对象
	File currentDirectory = null;

	Random rand = new Random(); // 获取随机值
	JFileChooser fileChooser = new JFileChooser();// 文件选择框
	Player player = null;// 音乐播放
	private final JLabel label = new JLabel("播放列表:");
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
		PlayStyle.setModel(new DefaultComboBoxModel(new String[] { "顺序播放", "单曲循环", "随机播放" }));
		panel_2.setBounds(142, 35, 262, 399);

		contentPane.add(panel_2);
		panel_2.setLayout(null);
		playlist.setBounds(10, 27, 242, 362);
		panel_2.add(playlist);
		label.setBounds(10, 0, 109, 24);
		panel_2.add(label);
		
		h.setUsername(u);//先把用户名记住
		try {
			MusicNames=new ServiceFactory().getIHistoryServiceInstance().findMusicF(u);//从数据库中把音乐读取出来
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将名称添加进列表
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
	 * 上一首实现函数
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
	 * 下一首实现函数
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
	 * 播放MP3文件主函数
	 */
	public void PlayFile()
	{
		try {
			player = Manager.createRealizedPlayer(MusicNames.get(index).toURI().toURL());
			player.prefetch();// player实例化完成后进行player播放前预处理
			player.setMediaTime(new Time(0.0));// 从某个时间段开始播放
			player.addControllerListener(this);
			player.start();
			playlist.select(index);
		} catch (Exception e1) { // 当选到一首音乐不能播放时，对其进行处理
			dealError();
			return;
		}
	}

	/**
	 * 当播放出错时
	 */
	private void dealError()
	{
		MusicNames.remove(index);
		if (--count == index) {// 刚好是最后一首出错
			index = 0;
		}
		if (count == 0) {// 文件没有选择成功
			player = null;
		} else {
			PlayFile();
		}
	}

	@Override
	public void controllerUpdate(ControllerEvent e)
	{
		String box = (String) PlayStyle.getSelectedItem(); // 判断播放的方式
		if (e instanceof EndOfMediaEvent)
		{
			player.setMediaTime(new Time(0));
			if ("单曲循环".equals(box))
			{
				player.start();
			}
			if ("顺序播放".equals(box))
			{
				nextMusic();
			}
			if ("随机播放".equals(box))
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
		String cmd = e.getActionCommand();                   //通过获取字符串来判断是播放还是暂停，
		String box = (String) PlayStyle.getSelectedItem(); // 判断播放的方式
        if(e.getSource()==AddM||e.getSource()==AddM1)//添加音乐
        {
        	fileChooser.setFileFilter(new FileNameExtensionFilter("WAV & MP3 MUSIC", "mp3", "wav"));// 只允许选择mp3的文件
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {// 打开文件对话框，并确认
				MusicName = fileChooser.getSelectedFile();// 返回所选文件
				MusicNames.add(MusicName);// 将文件放到音乐目录下
				playlist.add(MusicName.getName());// 将音乐名称添加进播放列表
				index = MusicNames.indexOf(MusicName); // 定义歌曲的下标
				count = MusicNames.size();// 歌曲的总数目
				h.setId(String.valueOf(index));
				h.setUname(MusicName.getName());
				try {
					new ServiceFactory().getIHistoryServiceInstance().AddMusic(h);//音乐名称加进数据库
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (player == null) {//当选的是第一首歌时才播放一下，其他歌时直接播放之前的
				PlayFile();
			}
        }

        if (cmd.equals("暂停")) {
			SelectPlay.setText("播放");
			player.stop();
		}
		if (cmd.equals("播放")) {
			SelectPlay.setText("暂停");
			player.start();
		}

        if(e.getSource()==afterM||e.getSource()==afterM1||e.getSource()==afterM2){        //下一曲
			if (player != null) {
				if ("随机播放".equals(box)) {
					int index = rand.nextInt(MusicNames.size() - 1);// 0-MusicNames.size()-1
					if (MusicNames != null && !MusicNames.isEmpty()) {
						// 如果随机到的是当前歌曲
						if (++index == MusicNames.size()) {
							index = rand.nextInt(MusicNames.size() - 1);
						}
						player.stop(); // 若点击下一曲，则将当前的歌曲停止播放，播放下一曲
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
				} else {// 顺序跟循环都是直接下一首
					nextMusic();
				}
			}
        }
        if(e.getSource()==beforeM||e.getSource()==beforeM1||e.getSource()==beforeM2){       //上一曲
        	if (player != null) {
				if ("随机播放".equals(box)) {
					int index = (int) rand.nextInt(MusicNames.size()) + 1;
					if (MusicNames != null && !MusicNames.isEmpty()) {
						if (index-- == (int) rand.nextInt(MusicNames.size()) + 1) {
							index = MusicNames.size() - 1;
						}
						player.stop(); // 若点击上一曲，则将当前的歌曲停止播放，播放上一曲
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
        
        if(e.getSource()==DelM){             //删除歌曲
        	index = playlist.getSelectedIndex();
			playlist.remove(index);
			MusicNames.remove(index);
			try {
				new ServiceFactory().getIHistoryServiceInstance().DelMusic(h);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        }

        //双击列表时实现播放
        playlist.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	// 双击时处理
				if (e.getClickCount() == 2) {
					if (player != null) {
						player.stop();
					}
					// 播放选中的文件
					index = playlist.getSelectedIndex();
					//如果播放/暂停按钮是播放，将其改成暂停
					if (cmd.equals("播放")) {
						SelectPlay.setText("暂停");
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
