
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

//������
public class SystemMainFrame extends JFrame {
	private JMenuBar menuBar;	//Ӧ�ò˵�����
	private JMenu student_Management;	//"ѧ������"�˵���
	private JMenu personal_Management;	//"���˹���"�˵���
	private JMenu information_Management; //"��Ϣ����"�˵���
	private JMenuItem add_Student;	//"���ѧ��"�˵��
	private JMenuItem query_Student;	//"��ѯѧ����Ϣ"�˵��
	private JMenuItem modify_Student;	//"�޸�ѧ����Ϣ"�˵��
	private JMenuItem delete_Student;	//"ɾ��ѧ��"�˵��
	private JMenuItem change_Password;	//"�޸�����"�˵��
	private JMenuItem logout;	//"�˳���¼"�˵��
	private JMenuItem System_info;//"ϵͳ����"�˵��
	private JMenuItem Author_info;//"����"�˵��
	private JFrame jf;	//��ǰ���ڡ�
	private User user;//��ǰ�û���
	public SystemMainFrame(User user){
		super("ѧ������ϵͳ,��ӭ��    "+user.getUsername());
		this.user = user;
		this.jf = this;
		menuBar = new JMenuBar();	//�����˵�����
		this.setJMenuBar(menuBar);
		student_Management = new JMenu("ѧ������");
		menuBar.add(student_Management);
		add_Student = new JMenuItem("���ѧ��");
		add_Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddStudentFrame addStudentFrame = new AddStudentFrame(jf,"���ѧ��",true);
			}
		});
		student_Management.add(add_Student);
		query_Student = new JMenuItem("��ѯѧ����Ϣ");
		query_Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChaXunStudentFrame queryStudentFrame = new ChaXunStudentFrame(jf, "��ѯѧ����Ϣ", true);
				
			}
		});
		student_Management.add(query_Student);
		modify_Student = new JMenuItem("�޸�ѧ����Ϣ");
		modify_Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XiuGaiStudentFrame modifyStudentFrame = new XiuGaiStudentFrame(jf, "�޸�ѧ����Ϣ", true);
			}
		});
		student_Management.add(modify_Student);
		delete_Student = new JMenuItem("ɾ��ѧ��");
		delete_Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudentFrame deleteStudentFrame = new DeleteStudentFrame(jf, "ɾ��ѧ��", true);
			}
		});
		student_Management.add(delete_Student);
		personal_Management = new JMenu("���˹���");
		menuBar.add(personal_Management);
		logout = new JMenuItem("�˳���¼");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				//�޸ĵ�½״̬
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//���õ�½״̬Ϊδ��¼��
				helper.Update_IsLogin(user);
				LoginFrame frame = new LoginFrame();
			}
		});
		change_Password = new JMenuItem("�޸�����");
		change_Password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePasswordFrame frame = new UpdatePasswordFrame(jf, "�޸�����", true,user);
			}
		});
		personal_Management.add(change_Password);
		personal_Management.add(logout);

		information_Management = new JMenu("����");
		menuBar.add(information_Management);
		System_info = new JMenuItem("ϵͳ����");
		System_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//jf.dispose();
//				String b = "ϵͳ����\n��ϵͳΪѧ������ϵͳ";
//				String b;
//				Read data = new Read();
//				b = data.read();
//				JOptionPane.showMessageDialog(jf,b,"ϵͳ����",JOptionPane.WARNING_MESSAGE);

				GuanyuFrame frame = new GuanyuFrame();
			}
		});
		information_Management.add(System_info);

		Author_info = new JMenuItem("��������");
		Author_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String b = "\t\t��������\n@Author��\t419�������1��\t����ǿ\nQQ:\t1131937963";
				JOptionPane.showMessageDialog(jf,b,"��������",JOptionPane.WARNING_MESSAGE);
			}
		});
		information_Management.add(Author_info);

		this.setSize(578, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		WindowUI.setFrameCenter(this);//���ô�����С�
		ImagePancel imagePanel = new ImagePancel();

		setContentPane(imagePanel);//����Ϊ�������
		try {
			BufferedImage img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setVisible(true);//���ô���ɼ���
		this.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//�޸ĵ�½״̬
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//���õ�½״̬Ϊδ��¼��
				helper.Update_IsLogin(user);
				
			}
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
}
