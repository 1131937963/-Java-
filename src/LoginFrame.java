/*
*****�û���¼����
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginFrame extends JFrame {
	private JLabel author_text;//
	private JLabel username_Label;	//�û�����ǩ��
	private JLabel password_Label;	//�����ǩ��
	private JTextField username_Text;	//�û����ı���
	private JPasswordField password_Text;	//�����ı���
	private JButton login_Button;	//��½��ť��
	private JButton Zhuche_Button;	//ע�ᰴť��
	private JButton fund_Button;//�һ����밴ť
	private JFrame jf;	//��ǰ���� ��
	public LoginFrame(){
		super("ѧ������ϵͳ��¼����");
		this.jf = this;
		this.setLayout(null);
		this.setSize(700,500);
		Container c = this.getContentPane();//���JFrame���������
		JLabel jl3=new JLabel(new ImageIcon("src/login.png"));
		jf.add(jl3);
		jl3.setBounds(0, 0-30, 700, 300);
		JLabel U=new JLabel(new ImageIcon("src/User.png"));
		U.setBounds(225,300,20,20);
		jf.add(U);
		JLabel M=new JLabel(new ImageIcon("src/����.png"));
		M.setBounds(225,350,20,20);
		jf.add(M);
		author_text = new JLabel("@author:  ����ǿ");
		author_text.setBounds(300, 440, 500, 20);
		c.add(author_text);
		username_Label = new JLabel("�û���:");
		username_Label.setBounds(250, 300, 50, 20);
		c.add(username_Label);
		
		username_Text = new JTextField();
		username_Text.setBounds(300, 300, 120, 20);
		username_Text.grabFocus();//��ù�ꡣ
		c.add(username_Text);
		
		password_Label = new JLabel("����:");
		password_Label.setBounds(260, 350, 50, 20);
		c.add(password_Label);
		
		password_Text = new JPasswordField();
		password_Text.setBounds(300, 350, 120, 20);
		c.add(password_Text);

//		JLabel D=new JLabel(new ImageIcon("src/ȷ��.png"));
//		D.setBounds(230,400,20,20);
//		jf.add(D);

		fund_Button = new JButton("�һ�����");
		fund_Button.setBounds(310, 400, 90, 20);
		fund_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();	//��ǰ���ڹرա�
				UserfundFrame studentSystemFrame = new UserfundFrame();	//���һؽ���

			}
		});
		c.add(fund_Button);

		login_Button = new JButton("��¼");
		login_Button.setBounds(250, 400, 60, 20);
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = username_Text.getText().trim();
				String password = new String(password_Text.getPassword());
				if(username.equals("")){//�ж�������Ƿ�Ϊ�գ�
					JOptionPane.showMessageDialog(jf, "�û�������Ϊ��","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(password.equals("")){
					JOptionPane.showMessageDialog(jf, "���벻��Ϊ��","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				//��¼
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				ManageHelper helper = new ManageHelper();
				if(helper.Login(user)){	//
						JOptionPane.showMessageDialog(jf, "��½�ɹ���");
						jf.dispose();
						user.setIsLogin(1);//�޸ĳ�Ϊ�Ѿ���½��
						helper.Update_IsLogin(user);
						user.setPassword("");//��������
						SystemMainFrame frame = new SystemMainFrame(user);
						return ;
				}else{
					JOptionPane.showMessageDialog(jf, "�û������������");
					 Reset();
					return ;
				}
				
			}
		});
		c.add(login_Button);

		Zhuche_Button = new JButton("ע��");
		Zhuche_Button.setBounds(400, 400, 60, 20);
		Zhuche_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();	//��ǰ���ڹرա�
				UserZhucheFrame studentSystemFrame = new UserZhucheFrame();	//��ע�����
				
			}
		});
		c.add(Zhuche_Button);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	//���ô�С���ɸı䡣
		WindowUI.setFrameCenter(this);//���ô��ھ��С�
		try {
			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setVisible(true);	//���ô���ɼ���
	}
		public void Reset(){
			username_Text.setText("");
			password_Text.setText("");
		}
}
