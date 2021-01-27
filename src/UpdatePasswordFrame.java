/*
**�޸�����
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePasswordFrame extends JDialog {

	private JLabel password_Label;	//ԭ�����ǩ��
	private JLabel newpassword_Label;	//�������ǩ��
	private JLabel repassword_Label;	//ȷ�������ǩ��
	private JPasswordField password_Text;	//ԭ�����ı���
	private JPasswordField newpassword_Text;	//�������ı���
	private JPasswordField repassword_Text;	//ȷ�������ı���
	private JButton confirm_Button;	//ȷ�ϰ�ť��
	private JButton cancel_Button;	//ȡ����ť��
	private JDialog jd;	//��ǰ���� ��
	private User user;

	public UpdatePasswordFrame(JFrame owner, String title, boolean modal, User user){
		super(owner, title, modal);
		this.user = user;
		this.jd = this;
		this.setLayout(null);
		this.setSize(400,300);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		password_Label = new JLabel("ԭ����:");
		password_Label.setBounds(100, 60, 50, 20);
		c.add(password_Label);
		
		password_Text = new JPasswordField();
		password_Text.setBounds(160, 60, 120, 20);
		password_Text.grabFocus();
		c.add(password_Text);
		
		newpassword_Label = new JLabel("������:");
		newpassword_Label.setBounds(100, 110, 50, 20);
		c.add(newpassword_Label);
		
		newpassword_Text = new JPasswordField();
		newpassword_Text.setBounds(160, 110, 120, 20);
		c.add(newpassword_Text);
		
		repassword_Label = new JLabel("ȷ������");
		repassword_Label.setBounds(100, 162, 70, 20);
		c.add(repassword_Label);
		
		repassword_Text = new JPasswordField();
		repassword_Text.setBounds(160, 162, 120, 20);
		c.add(repassword_Text);
		
		confirm_Button = new JButton("ȷ��");
		confirm_Button.setBounds(90, 210, 60, 20);
		confirm_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(password_Text.getPassword());
				String repassword = new String(repassword_Text.getPassword());
				String newpassword = new String(newpassword_Text.getPassword());
				if(password.equals("")){
					JOptionPane.showMessageDialog(jd, "ԭ���벻��Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(newpassword.equals("")){
					JOptionPane.showMessageDialog(jd, "�����벻��Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(repassword.equals("")){
					JOptionPane.showMessageDialog(jd, "ȷ�����벻��Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(repassword.equals(newpassword)){
					//���ԭ�����Ƿ���ȷ
					ManageHelper helper = new ManageHelper();
					user.setPassword(password);
					if(helper.Login(user)){//���ԭ�����Ƿ���ȷ
						helper.update_Password(user, newpassword);
						JOptionPane.showMessageDialog(jd, "�޸�����ɹ���");
						jd.dispose();
						return ;
					}else{
						JOptionPane.showMessageDialog(jd,"ԭ���벻��ȷ��","", JOptionPane.WARNING_MESSAGE);
						Reset();
						return ;
					}
				}else{
					JOptionPane.showMessageDialog(jd,"�������벻һ��","", JOptionPane.WARNING_MESSAGE);
					Reset();
					return ;
				}
				
			}
		});
		c.add(confirm_Button);	//���"ȷ��"��ť��
		
		
		cancel_Button = new JButton("ȡ��");	//����"ȡ��"��ť��
		cancel_Button.setBounds(250, 210, 60, 20);	//����"ȡ��"��ťλ�á�
		//ע��"ȡ��"��ť�¼�������
		cancel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.dispose();//�رյ�ǰҳ�档
			
			}
		});
		c.add(cancel_Button);	//���"ȡ��"��ť��
		

		this.setResizable(false);	//���ô�С���ɸı䡣
		WindowUI.setFrameCenter(this);//���ô��ھ��С�
		this.setVisible(true);	//���ô���ɼ���
	}
	
	//����
	public void Reset(){
		password_Text.setText("");
		repassword_Text.setText("");
		newpassword_Text.setText("");
	}
}
