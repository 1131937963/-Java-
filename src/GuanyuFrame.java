import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuanyuFrame extends JFrame {

//        private JLabel author_text;//
//        private JLabel username_Label;	//�û�����ǩ��
//        private JLabel password_Label;	//�����ǩ��
//        private JTextField username_Text;	//�û����ı���
//        private JPasswordField password_Text;	//�����ı���
//        private JButton login_Button;	//��½��ť��
//        private JButton Zhuche_Button;	//ע�ᰴť��
//        private JButton fund_Button;//�һ����밴ť
        private JFrame jf;	//��ǰ���� ��
        public GuanyuFrame(){
//            super("ѧ������ϵͳ��¼����");
//            this.jf = this;
//            this.setLayout(null);
//            this.setSize(700,500);
//            Container c = this.getContentPane();//���JFrame���������


            JFrame frame=new JFrame("ѧ������ϵͳ��¼����");    //����Frame����
            JPanel jp=new JPanel();    //����һ��JPanel����
            String b;
            Read data = new Read();
            b = data.read();
            JTextArea jta=new JTextArea(b,18,58);
            jta.setLineWrap(true);    //�����ı����е��ı�Ϊ�Զ�����
            jta.setForeground(Color.BLACK);    //��������ı���ɫ
            jta.setFont(new Font("����",Font.BOLD,16));    //�޸�������ʽ
            jta.setBackground(Color.WHITE);    //���ð�ť����ɫ
            JScrollPane jsp=new JScrollPane(jta);    //���ı�������������
            Dimension size=jta.getPreferredSize();    //����ı������ѡ��С
            jsp.setBounds(500,350,size.width,size.height);
            jp.add(jsp);    //��JScrollPane��ӵ�JPanel������
            this.add(jp);    //��JPanel������ӵ�JFrame������
            this.setBackground(Color.LIGHT_GRAY);
            this.setSize(578,400);    //����JFrame�����Ĵ�С


//            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}


