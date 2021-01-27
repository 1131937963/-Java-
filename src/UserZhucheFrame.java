/*
**ע��ģ��
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserZhucheFrame extends JFrame {

	private JLabel username_Label;	//�û�����ǩ��
	private JLabel password_Label;	//�����ǩ��
	private JLabel repassword_Label;	//ȷ�������ǩ��
	private JLabel telphone_Label;     //�лص绰��ǩ��
	private JTextField username_Text;	//�û����ı���
	private JPasswordField password_Text;	//�����ı���
	private JPasswordField repassword_Text;	//ȷ�������ı���
	private JPasswordField telphone_Text;//�һص绰�ı���
	private JButton register_Button;	//ע�ᰴť��
	private JButton cancel_Button;	//ȡ����ť��
	private JFrame jf;	//��ǰ���� ��
	
	public UserZhucheFrame(){
		super("ѧ����Ϣ����ϵͳע�����");
		this.jf = this;
		this.setLayout(null);
		this.setSize(400,350);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		username_Label = new JLabel("�û���:");
		username_Label.setBounds(100, 60, 50, 20);
		c.add(username_Label);
		
		username_Text = new JTextField();
		username_Text.setBounds(160, 60, 120, 20);
		username_Text.grabFocus();
		c.add(username_Text);
		
		password_Label = new JLabel("����:");
		password_Label.setBounds(110, 110, 50, 20);
		c.add(password_Label);
		
		password_Text = new JPasswordField();
		password_Text.setBounds(160, 110, 120, 20);
		c.add(password_Text);
		
		repassword_Label = new JLabel("ȷ������:");
		repassword_Label.setBounds(90, 162, 70, 20);
		c.add(repassword_Label);
		
		repassword_Text = new JPasswordField();
		repassword_Text.setBounds(160, 162, 120, 20);
		c.add(repassword_Text);

		telphone_Label = new JLabel("�һص绰:");
		telphone_Label.setBounds(90,210,70,20);
		c.add(telphone_Label);

		telphone_Text = new JPasswordField();
		telphone_Text.setBounds(160,210,120,20);
		c.add(telphone_Text);
		
		register_Button = new JButton("ע��");
		register_Button.setBounds(90, 260, 60, 20);
		register_Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String username = username_Text.getText().trim();
				String password = new String(password_Text.getPassword());
				String repassword = new String(repassword_Text.getPassword());
				String telphone = new String(telphone_Text.getPassword());
				if(username.equals("")){
					JOptionPane.showMessageDialog(jf, "�û�������Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(password.equals("")){
					JOptionPane.showMessageDialog(jf, "���벻��Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(repassword.equals("")){
					JOptionPane.showMessageDialog(jf, "ȷ�����벻��Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(telphone.equals("")){
					JOptionPane.showMessageDialog(jf, "�һص绰����Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(!password.equals(repassword)){
					JOptionPane.showMessageDialog(jf, "�������벻һ�£�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				User user = new User();//�����û�����
				user.setUsername(username);
				user.setPassword(password);
				user.setTelphone(telphone);
				ManageHelper helper = new ManageHelper();
				if(helper.Register(user)){//ע�ᴦ��
					JOptionPane.showMessageDialog(jf, "ע��ɹ���");
					jf.dispose();
					LoginFrame frame = new LoginFrame();//���ص�½ҳ�档
					return ;
				}else{
					JOptionPane.showMessageDialog(jf, "ע��ʧ�ܣ�");
					Reset();
					return ; 
				}
				
			}
		});
		c.add(register_Button);	//���"ע��"��ť��
		
		
		cancel_Button = new JButton("ȡ��");	//����"ȡ��"��ť��
		cancel_Button.setBounds(250, 260, 60, 20);	//����"ȡ��"��ťλ�á�
		//ע��"ȡ��"��ť�¼�������
		cancel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();//�رյ�ǰҳ�档
				LoginFrame studentSystemLoginFrame = new LoginFrame();//�򿪵�½ҳ�档
			}
		});
		c.add(cancel_Button);	//���"ȡ��"��ť��
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
	
	//����
	public void Reset(){
		username_Text.setText("");
		password_Text.setText("");
		repassword_Text.setText("");
	}
}
