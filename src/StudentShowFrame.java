/*
**ѧ����Ϣ��ʾ����
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StudentShowFrame extends JDialog {
	private JButton confirm_Button;	//"ȷ��"��ť��
    private JTextField sex_Text;	//"�Ա�"ѡ�
    private JTextField major_Text;	//"רҵ"ѡ�
    private JTextField department_Text;	//"����Ժϵ"ѡ�
    private JLabel student_ID;  //"ѧ��"��ǩ��
    private JLabel student_Name;	//"����"��ǩ��
    private JLabel sex_Label;	//"�Ա�"��ǩ��
	private JLabel age_Label;  //"����"��ǩ
	private JLabel telphone_Label;//"��ϵ"��ǩ
    private JLabel classe_Label;	//"�༶"��ǩ��
    private JLabel grade_Label;	//"�꼶��ǩ"��
    private JLabel major_Label;	//"רҵ"��ǩ��
    private JLabel department_Label;	//"����Ժϵ"��ǩ��
    private JTextField student_IDText;	//"ѧ��"�ı���
    private JTextField student_NameText;	//"����"�ı���
	private JTextField age_Text;  //"����"�ı���
	private JTextField telphone_Text;  //"��ϵ"�ı���
    private JTextField classe_Text;	//"�༶"�ı���
    private JTextField grade_Text;	//"�꼶"�ı���
    private StudentModel sm;	//�����ѧ������ģ��
    private JDialog jd;	//��ǰ���ڡ�

public StudentShowFrame(JDialog owner, String title, boolean modal, int
		rowNum, StudentModel sm){
	super(owner, title, modal);
	this.sm = sm;	//����ѧ������
	this.jd = this;
	this.setSize(350,429);
	this.setLayout(null);
	
	student_ID = new JLabel("ѧ��:");
	student_ID.setBounds(78, 28, 30, 20);
	this.add(student_ID);	
	
	student_IDText = new JTextField();
	student_IDText.setEditable(false);	//���ɱ༭
	student_IDText.setText(sm.getValueAt(rowNum, 0).toString());	//��ȡѧ�Ų���ʾ
	student_IDText.setBounds(116, 28, 150, 20);
	this.add(student_IDText);
	
	student_Name = new JLabel("����:");
	student_Name.setBounds(78, 58, 30, 20);
	this.add(student_Name);
	
	
	student_NameText = new JTextField();
	student_NameText.setBounds(116, 58, 150, 20);
	student_NameText.setEditable(false);//���ɱ༭
	student_NameText.setText(sm.getValueAt(rowNum, 1).toString());	//����ѧ����������ʾ
	this.add(student_NameText);
	
	sex_Label = new JLabel("�Ա�:");
	sex_Label.setBounds(78, 148, 30, 20);
	this.add(sex_Label);
	
	sex_Text = new JTextField();
	sex_Text.setBounds(116, 148, 60, 20);
	sex_Text.setEditable(false);//���ɱ༭
	sex_Text.setText(sm.getValueAt(rowNum, 2).toString());	//����ѧ���Ա���ʾ
	this.add(sex_Text);

	age_Label = new JLabel("����:");
	age_Label.setBounds(78,88,30,20);
	this.add(age_Label);

	age_Text = new JTextField();
	age_Text.setBounds(116,88,150,20);
	age_Text.setEditable(false);
	age_Text.setText(sm.getValueAt(rowNum,3).toString());
	this.add(age_Text);

	telphone_Label = new JLabel("��ϵ�绰:");
	telphone_Label.setBounds(55,118,80,20);
	this.add(telphone_Label);

	telphone_Text = new JTextField();
	telphone_Text.setBounds(116,118,150,20);
	telphone_Text.setEditable(false);
	telphone_Text.setText(sm.getValueAt(rowNum,4).toString());
	this.add(telphone_Text);


	grade_Label = new JLabel("�꼶:");
	grade_Label.setBounds(78, 178, 30, 20);
	this.add(grade_Label);
	
	grade_Text = new JTextField();
	grade_Text.setBounds(116, 178, 150, 20);
	grade_Text.setEditable(false);
	grade_Text.setText(sm.getValueAt(rowNum, 5).toString());	//�����꼶����ʾ
	this.add(grade_Text);
	
	classe_Label = new JLabel("�༶:");
	classe_Label.setBounds(78, 208, 30, 20);
	this.add(classe_Label);
	
	classe_Text = new JTextField();
	classe_Text.setBounds(116, 208, 150, 20);
	classe_Text.setEditable(false);
	classe_Text.setText(sm.getValueAt(rowNum, 6).toString());
	this.add(classe_Text);
		
	department_Label = new JLabel("Ժϵ:");
	department_Label.setBounds(78, 238, 30, 20);
	
	this.add(department_Label);
	
	department_Text = new JTextField();
	department_Text.setEditable(false);
	department_Text.setText(sm.getValueAt(rowNum, 7).toString());
	department_Text.setBounds(116, 238, 150, 20);
	this.add(department_Text);

	major_Label = new JLabel("רҵ:");
	major_Label.setBounds(78, 268, 30, 20);
	this.add(major_Label);
	
	major_Text = new JTextField();
	major_Text.setEditable(false);
	major_Text.setBounds(116, 268, 150, 20);
	major_Text.setText(sm.getValueAt(rowNum, 8).toString());
	this.add(major_Text);
	
	confirm_Button = new JButton("ȷ��");
	confirm_Button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jd.dispose();//�رյ�ǰ����
		}
	});
	confirm_Button.setBounds(150, 330, 60, 25);
	
	this.add(confirm_Button);
	WindowUI.setFrameCenter(this);
	this.setResizable(false);
	this.setVisible(true);
	}
}
