
import java.util.HashMap;
import java.util.Vector;


//���ݿ�
public class ManageHelper {
	static private Sqlfunc helper;	//���ݿ����
//�жϵ�¼�Ƿ�ɹ�
	public boolean Login(User user){
		boolean b = true;
		helper = new Sqlfunc();
		User newUser = helper.getUser(user); //����û�����
		if(!user.getPassword().equals(newUser.getPassword())){
			b = false;
		}
		helper.close();
		return b;
	}

	//�ж�ע�����
	public boolean Register(User user){
		helper = new Sqlfunc();//
		boolean b = helper.register(user);
		helper.close();
		return b;
	}

	//�ж��һ����
	public boolean Found(User user){
		boolean b = true;
		helper = new Sqlfunc();
		User newUser = helper.found(user);
		if(!user.getTelphone().equals(newUser.getTelphone())){
			b = false;
		}
		helper.close();
		return b;
	}

//��¼���
	public boolean  Update_IsLogin(User user){
		helper = new Sqlfunc();
		boolean b = helper.update_IsLogin(user);
		helper.close();
		return b;
	}

	//�����޸�
	public boolean update_Password(User user, String new_Password){
		boolean b;
		helper = new Sqlfunc();
		b = helper.update_Password(user, new_Password);
		helper.close();
		return b;
	}

	//����ԺϵHashMap����
	public HashMap<String, String> getAllDepartment(){
		helper = new Sqlfunc();
		HashMap<String, String> map;//��ý������;
		map = helper.getAllDepartment();
		helper.close();
		return map;
	}

	//��������רҵ����
	public HashMap<String, String> getAllMajor(){
		helper = new Sqlfunc();
		HashMap<String, String> map;
		map = helper.getAllMajor();
		helper.close();
		System.out.println(map);
		return map;
	}


	//���������꼶����
	public  HashMap<String, String> getAllGrade(){
		helper = new Sqlfunc();
		HashMap<String, String> map;
		map = helper.getAllGrade();
		helper.close();
		return map;
	}

	//���ض�Ӧ��רҵ����
	public Vector<String> getMajor(String department_ID){
		helper = new Sqlfunc();
		Vector<String> vector;//�ܹ�����������͵Ķ�̬����
		vector = helper.getMajor(department_ID);
		helper.close();
		return vector;
	}

	public boolean addStudent(Student student){
		boolean b = true;
		helper = new Sqlfunc();
		b = helper.addStudent(student);
		helper.close();
		return b;
	}

	public boolean updateStudent(Student newStudent, String oldStudentID){
		boolean b = true;
		helper = new Sqlfunc();
		b = helper.updateStudent(newStudent, oldStudentID);
		helper.close();
		return b;
	}

	//ɾ��ѧ��
	public boolean deleteStudent(String studentID){
		boolean b;
		helper = new Sqlfunc();
		b = helper.deleteStudent(studentID);
		helper.close();
		return b;
	}

	//sql��䷵��ѧ������
	public Vector<Student> getStudent(String sql){
		Vector<Student> students;
		helper = new Sqlfunc();
		students = helper.getStudent(sql);
		helper.close();
		return students;
	}

	//�����꼶��רҵ��ű�ŷ��ض�Ӧ�İ༶
	public Vector<String> getAllClasse(String grade, String major_ID){
		Vector<String> vector;
		helper = new Sqlfunc();
		vector = helper.getAllClasse(grade,major_ID);
		helper.close();
		return vector;
		
	}
	
	//����רҵ��ŷ��ؿγ̼���
	public Vector<String> getCourse(String major_Id, String grade){
		Vector<String> vector;
		helper = new Sqlfunc();
		vector = helper.getCourse(major_Id,grade);
		helper.close();
		return vector;
	}

}
