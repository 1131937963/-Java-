public class User {
	private String username;	//�û���
	private String password;	//����
	private String Telphone;   //��ϵ��ʽ�����һ�����
	private int isLogin = 0;	//�û��Ƿ��½
	
	public int getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone(){
		return Telphone;
	}
	public void setTelphone(String Telphone){
		this.Telphone = Telphone;
	}
	
}
