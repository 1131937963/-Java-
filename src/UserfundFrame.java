import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserfundFrame extends JFrame {

        private JLabel username_Label;	//�û�����ǩ��
        private JLabel telphone_label;	//�绰��ǩ��
        private JLabel retelphone_label;	//ȷ�������ǩ��
        private JTextField username_Text;	//�û����ı���
        private JPasswordField telphone_Text;	//�����ı���
        private JPasswordField retelphone_Text;	//ȷ�������ı���
        private JButton fund_Button;	//�һذ�ť��
        private JButton cancel_Button;	//ȡ����ť��
        private JFrame jf;	//��ǰ���� ��

        public UserfundFrame(){
            super("ѧ����Ϣ����ϵͳ�һ��������");
            this.jf = this;
            this.setLayout(null);
            this.setSize(400,300);
            Container c = this.getContentPane();
            c.setBackground(Color.WHITE);
            username_Label = new JLabel("�û���:");
            username_Label.setBounds(100, 60, 50, 20);
            c.add(username_Label);

            username_Text = new JTextField();
            username_Text.setBounds(160, 60, 120, 20);
            username_Text.grabFocus();
            c.add(username_Text);

            telphone_label = new JLabel("��ϵ�绰:");
            telphone_label.setBounds(90, 110, 70, 20);
            c.add(telphone_label);

            telphone_Text = new JPasswordField();
            telphone_Text.setBounds(160, 110, 120, 20);
            c.add(telphone_Text);

            retelphone_label = new JLabel("ȷ�ϵ绰��");
            retelphone_label.setBounds(90, 162, 70, 20);
            c.add(retelphone_label);

            retelphone_Text = new JPasswordField();
            retelphone_Text.setBounds(160, 162, 120, 20);
            c.add(retelphone_Text);

            fund_Button = new JButton("�һ�����");
            fund_Button.setBounds(90, 210, 100, 20);
            fund_Button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String username = username_Text.getText().trim();
                    String telphone = new String(telphone_Text.getPassword());
                    String retelphone = new String(retelphone_Text.getPassword());
                    if(username.equals("")){
                        JOptionPane.showMessageDialog(jf, "�û�������Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
                        return ;
                    }
                    if(telphone.equals("")){
                        JOptionPane.showMessageDialog(jf, "��ϵ�绰����Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
                        return ;
                    }
                    if(retelphone.equals("")){
                        JOptionPane.showMessageDialog(jf, "ȷ�ϵ绰����Ϊ�գ�","", JOptionPane.WARNING_MESSAGE);
                        return ;
                    }
                    if(!telphone.equals(retelphone)){
                        JOptionPane.showMessageDialog(jf, "���ε绰���벻һ�£�","", JOptionPane.WARNING_MESSAGE);
                        return ;
                    }
                    User user = new User();//�����û�����
                    user.setUsername(username);
                    user.setTelphone(telphone);
                    ManageHelper helper = new ManageHelper();
                    System.out.println("12");
                    if(helper.Found(user)){//�һ����봦��
                        JOptionPane.showMessageDialog(jf, "�һسɹ���");
                        Sqlfunc helpe;	//���ݿ����
                        String b = null;
                        helpe = new Sqlfunc();
                        User newUser = helpe.getUser(user); //����û�����
                        b = newUser.getPassword();
                        JOptionPane.showMessageDialog(jf,b,"���˻��������ǣ�",JOptionPane.WARNING_MESSAGE);

                        jf.dispose();
                        LoginFrame frame = new LoginFrame();
                        return ;
                    }else{
                        JOptionPane.showMessageDialog(jf, "�һ�ʧ�ܣ�");
                        Reset();
                        return ;
                    }

                }
            });
            c.add(fund_Button);
            cancel_Button = new JButton("ȡ��");
            cancel_Button.setBounds(250, 210, 60, 20);
            cancel_Button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    jf.dispose();
                    LoginFrame LoginFrame = new LoginFrame();
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
            telphone_Text.setText("");
            retelphone_Text.setText("");
        }
    }

