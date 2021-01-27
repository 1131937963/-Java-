/*
��������ѯ����
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiaojianChaxunFrame extends JDialog {
    private JLabel student_ID;    //"ѧ��"��ǩ��
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
    private JTextField sex_Text;	//�Ա�ѡ��
	private JTextField age_Text;  //"����"�ı���
	private JTextField telphone_Text;  //"��ϵ"�ı���
    private JTextField grade_Text;	//�꼶ѡ��
    private JTextField department_Text;	//ϵ��
    private JTextField major_Text;	//רҵ
    private JTextField classe_Text;	//�༶
    private JButton conditions_button;	//��������ѯ��ť
    private ManageHelper helper;
    private JDialog jd;	//��ǰ����

    public TiaojianChaxunFrame(JDialog owner, String title, boolean modal, JTable jt){
    	super(owner, title, modal);
    	this.jd = this;
    	this.setLayout(null);
    	
    	student_ID = new JLabel("ѧ��:");
    	student_ID.setBounds(29, 19, 30, 20);
    	this.add(student_ID);
    	
    	student_IDText = new JTextField();
    	student_IDText.setBounds(65, 19, 100, 20);
    	this.add(student_IDText);
    	
    	student_Name = new JLabel("����:");
    	student_Name.setBounds(200, 19, 30, 20);
    	this.add(student_Name);
    	
    	student_NameText = new JTextField();
    	student_NameText.setBounds(240, 19, 100, 20);
    	this.add(student_NameText);
    	
    	sex_Label = new JLabel("�Ա�:");
    	sex_Label.setBounds(29, 50, 30, 20);
    	this.add(sex_Label);
    	
    	sex_Text = new JTextField();
    	sex_Text.setBounds(65, 50, 100, 20);
    	this.add(sex_Text);
    	
    	grade_Label = new JLabel("�꼶:");
    	grade_Label.setBounds(200, 50, 30, 20);
    	this.add(grade_Label);
    	
    	grade_Text = new JTextField();
    	grade_Text.setBounds(240, 50, 100, 20);
    	this.add(grade_Text);
    	
    	department_Label = new JLabel("Ժϵ:");
    	department_Label.setBounds(29, 83, 30, 20);
    	this.add(department_Label);
    	
    	department_Text = new JTextField();
    	department_Text.setBounds(65, 83, 100, 20);
    	this.add(department_Text);
    	
    	major_Label = new JLabel("רҵ:");
    	major_Label.setBounds(200, 83, 30, 20);
    	this.add(major_Label);
    	
    	major_Text = new JTextField();
    	major_Text.setBounds(240, 83, 100, 20);
    	this.add(major_Text);
    	
    	classe_Label = new JLabel("�༶:");
    	classe_Label.setBounds(29,116, 30, 20);
    	this.add(classe_Label);
    	
    	classe_Text = new JTextField();
    	classe_Text.setBounds(65, 116, 100, 20);
    	this.add(classe_Text);

    	this.setSize(411, 222);
    	this.setResizable(false);
    	WindowUI.setFrameCenter(this);
    	this.setVisible(true);
    }
}
