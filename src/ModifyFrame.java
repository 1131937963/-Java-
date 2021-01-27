
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

//�޸�ѧ����Ϣ����
public class ModifyFrame extends JDialog {
 	private JButton modify_Button;	//"�޸�"��ť��
    private JButton cancel_Button;	//"ȡ��"��ť��
    private JComboBox sex_Box;	//"�Ա�"ѡ�
    private JComboBox major_Box;	//"רҵ"ѡ�
    private JComboBox department_Box;	//"����Ժϵ"ѡ�
    private JLabel student_ID; //"ѧ��"��ǩ��
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
	private JTextField age_Text;
	private JTextField telphone_Text;
    private JComboBox classe_Box;	//"�༶"ѡ�
    private JComboBox grade_Box;	//"�꼶"ѡ�
    private JDialog jd;	//��ǰ���ڡ�
    private HashMap<String, String> departments;	//����Ժϵ����,HashMap������ֵ�ԣ�https://www.runoob.com/java/java-hashmap.html
    private HashMap<String, String> all_Major;	//����רҵ����
    private Vector<String> majors;	//רҵ���Ƽ���
    private ManageHelper helper;	//���ݿ�
    private Vector<String> classes;	//�༶����
    private StudentModel sm;	//ѧ������

	public ModifyFrame(JDialog owner, String title, boolean modal, int rowNum, StudentModel sm){
		super(owner, title, modal);
		helper = new ManageHelper();
		departments = this.helper.getAllDepartment();
		all_Major = this.helper.getAllMajor();
		this.jd = this;
		this.sm = sm;
		this.setSize(350,429);
		this.setLayout(null);
		//��ȡ��Ϣ
		String student_id = sm.getValueAt(rowNum, 0).toString();
		String student_name = sm.getValueAt(rowNum, 1).toString();
		String student_sex = sm.getValueAt(rowNum, 2).toString();
		String student_age = sm.getValueAt(rowNum,3).toString();
		String student_telphone = sm.getValueAt(rowNum,4).toString();
		String student_grade = sm.getValueAt(rowNum, 5).toString();
		String student_classe =  sm.getValueAt(rowNum, 6).toString();
		String student_department = sm.getValueAt(rowNum, 7).toString();
		String student_major = sm.getValueAt(rowNum,8).toString();
		String classid = String.valueOf(student_id.charAt(student_id.length()-2))+ String.valueOf(student_id.charAt(student_id.length()-1));
		student_ID = new JLabel("���:");
		student_ID.setBounds(78, 48, 30, 20);	
		this.add(student_ID);	
		
		student_IDText = new JTextField();
		student_IDText.setBounds(116, 48, 150, 20);
		student_IDText.setText(classid);	//��ȡ��Ų���ʾ
		this.add(student_IDText);
		
		student_Name = new JLabel("����:");
		student_Name.setBounds(78, 88, 30, 20);
		this.add(student_Name);

		student_NameText = new JTextField();
		student_NameText.setBounds(116, 88, 150, 20);
		student_NameText.setText(student_name);	//����ѧ����������ʾ
		this.add(student_NameText);
		
		sex_Label = new JLabel("�Ա�:");
		sex_Label.setBounds(78, 128, 30, 20);
		this.add(sex_Label);
		
		sex_Box = new JComboBox(new String[]{"","��","Ů"});
		sex_Box.setSelectedItem(sm.getValueAt(rowNum, 2));
		sex_Box.setBounds(116, 128, 60, 20);
		this.add(sex_Box);

		age_Label=new JLabel("����");
		age_Label.setBounds(78,108,30,20);
		this.add(age_Label);

		age_Text = new JTextField();
		age_Text.setBounds(116,108,60,20);
		age_Text.setText(student_age);
		this.add(age_Text);

		telphone_Label = new JLabel("��ϵ�绰");
		telphone_Label.setBounds(78,148,30,20);
		this.add(telphone_Label);

		telphone_Text = new JTextField();
		telphone_Text.setBounds(116,148,150,20);
		telphone_Text.setText(student_telphone);
		this.add(telphone_Text);

		grade_Label = new JLabel("�꼶:");
		grade_Label.setBounds(78, 168, 30, 20);
		this.add(grade_Label);
		
		
		grade_Box = new JComboBox(StudentID.CreateGrade());
		grade_Box.setBounds(116, 168, 150, 20);
		grade_Box.setSelectedItem(sm.getValueAt(rowNum, 3));	//�����꼶����ʾ
		this.add(grade_Box);

		department_Label = new JLabel("Ժϵ:");
		department_Label.setBounds(78, 208, 30, 20);
		this.add(department_Label);
		department_Box = new JComboBox(departments.keySet().toArray());//��ü��ļ���
		System.out.println("--------------------------------");
		System.out.println(department_Box);
		department_Box.setSelectedItem(sm.getValueAt(rowNum, 5));
		department_Box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMajorOption();//����רҵ��ѡ��
			}
		});
		department_Box.setBounds(116, 208, 150, 20);
		this.add(department_Box);
	
		major_Label = new JLabel("רҵ:");
		major_Label.setBounds(78, 248, 30, 20);	
		this.add(major_Label);
		
		major_Box = new JComboBox(new String[]{""});//��ֹ��ָ���쳣
		addMajorOption();
		major_Box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addClasseOption();	//���Ӱ༶ѡ��
			}
		});
		major_Box.setSelectedItem(sm.getValueAt(rowNum,6));
		
		major_Box.setBounds(116, 248, 150, 20);
		this.add(major_Box);
		
		classe_Label = new JLabel("�༶:");
		classe_Label.setBounds(78, 288, 30, 20);
		this.add(classe_Label);
		
		classe_Box = new JComboBox(new String[]{""});//��ֹ��ָ���쳣
		addClasseOption();//��ʼ���༶ѡ��
				classe_Box.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(classe_Box.getSelectedItem()!=null){	//��ֹ��ָ�� 
							if(!classe_Box.getSelectedItem().toString().equals("")){	
								String classe = classe_Box.getSelectedItem().toString();
								String grade = grade_Box.getSelectedItem().toString();
								String major_Name = major_Box.getSelectedItem().toString();//���רҵ����
								String major_ID = all_Major.get(major_Name);	//���רҵ���
								if(!grade.equals("")){
									classes = helper.getAllClasse(grade,classe);	//��ð༶
									for(String s : classes){
										classe_Box.addItem(s);
									}
								}
							}
						}
					}
				});
		classe_Box.setBounds(116, 288, 150, 20);
		classe_Box.setSelectedItem(sm.getValueAt(rowNum, 4));
		this.add(classe_Box);
		modify_Button = new JButton("�޸�");
		modify_Button.setBounds(70, 330, 60, 25);
		modify_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student newStudent = new Student();
				String id = student_IDText.getText().trim();
				String name = student_NameText.getText().trim();
				String sex = sex_Box.getSelectedItem().toString();
				String age = age_Text.getText().trim();
				String telphone = telphone_Text.getText().trim();
				String classe = classe_Box.getSelectedItem().toString();
				String grade = grade_Box.getSelectedItem().toString();
				String department_ID = null;
				String major_ID = null;
				String department_Name = null;
				String major_Name = null;
				//����У�鲿��
				if(id.equals("")){
					JOptionPane.showMessageDialog(jd, "��Ų���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(id.length()!=2){
					JOptionPane.showMessageDialog(jd, "��ű�������λ����", "", JOptionPane.WARNING_MESSAGE);
					student_IDText.setText("");
					return ;
				}
				if(name.equals("")){
					JOptionPane.showMessageDialog(jd, "��������Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(sex.equals("")){
					JOptionPane.showMessageDialog(jd, "�Ա���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(age.equals("")){
					JOptionPane.showMessageDialog(jd, "���䲻��Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(telphone.equals("")){
					JOptionPane.showMessageDialog(jd, "��ϵ��ʽ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(grade.equals("")){
					JOptionPane.showMessageDialog(jd, "�꼶����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(classe.equals("")){
					JOptionPane.showMessageDialog(jd, "�༶����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(department_Box.getSelectedItem()==null){	//�ȼ������
					JOptionPane.showMessageDialog(jd, "Ժϵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}else{
					department_Name = department_Box.getSelectedItem().toString();	//���Ժϵ����
					department_ID = departments.get(department_Name);	//���Ժϵ���	
				}
				if(department_ID.equals("")){
					JOptionPane.showMessageDialog(jd, "Ժϵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(major_Box.getSelectedItem()==null){	//�ȼ������
					JOptionPane.showMessageDialog(jd, "רҵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}else{
					major_Name = major_Box.getSelectedItem().toString();//���רҵ����
					 major_ID = all_Major.get(major_Name);	//���רҵ���
				}
				if(major_ID.equals("")){
					JOptionPane.showMessageDialog(jd, "רҵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}

				String ID = StudentID.CreateID(grade, classe, major_ID, department_ID, id);//����ѧ��
				student_IDText.setText(ID);
				JOptionPane.showMessageDialog(jd, "��ѧ����idΪ:"+ID);
					
				newStudent.setStudent_ID(ID);
				newStudent.setStudent_Name(name);
				newStudent.setSex(sex);
				newStudent.setAge(age);
				newStudent.setTelphone(telphone);
				newStudent.setGrade(grade);
				newStudent.setClasse(classe);
				newStudent.setMajor_ID(major_ID);
				newStudent.setDepartment_ID(department_ID);
				newStudent.setDepartment_Name(department_Name);
				newStudent.setMajor_Name(major_Name);
				if(helper.updateStudent(newStudent, student_id)){
					JOptionPane.showMessageDialog(jd, "�޸ĳɹ���");
					jd.dispose();
					return ;
				}else{
					JOptionPane.showMessageDialog(jd, "�޸�ʧ�ܣ�", "", JOptionPane.WARNING_MESSAGE);
					jd.dispose();
					return ;
				}
			}
			
		});
		this.add(modify_Button);
		cancel_Button = new JButton("ȡ��");
		cancel_Button.setBounds(230, 330, 60, 25);
		cancel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jd.dispose();
				
			}
		});
		this.add(cancel_Button);
		WindowUI.setFrameCenter(this);
		this.setResizable(false);
		this.setVisible(true);
	}
	//����רҵ��ѡ��
	public void addMajorOption(){
		major_Box.removeAllItems();
		String option = department_Box.getSelectedItem().toString();//���ѡ������
		String department_ID = departments.get(option);	//���Ժϵ���
		if(!department_ID.equals("")){
			majors = helper.getMajor(department_ID);	//���רҵ
			for(String s : majors){
				major_Box.addItem(s);
			}
		}
	}

	//���Ӱ༶ѡ��
	public void addClasseOption(){
		if(major_Box.getSelectedItem()!=null){	//��ֹ��ָ�� 
			if(!major_Box.getSelectedItem().toString().equals("")){
				if(major_Box.getSelectedItem().toString().equals("") || grade_Box.getSelectedItem()==null || grade_Box.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(jd, "�꼶����Ϊ��", "", JOptionPane.WARNING_MESSAGE);
					major_Box.setSelectedIndex(0);	//����Ϊ��ѡ��
					return ;
				}
				if(classe_Box!=null ){//��ֹ��ָ���쳣
					classe_Box.removeAllItems();//�Ƴ�"�༶ѡ��"������
					String option = major_Box.getSelectedItem().toString();
					String major_id = all_Major.get(option);	//רҵ���
					String grade = grade_Box.getSelectedItem().toString();
					if(!grade.equals("")){
						 classes = helper.getAllClasse(grade,major_id);	//��ð༶
						for(String s : classes){
							classe_Box.addItem(s);
						}
					}
				}
			}
		}
	}

}
