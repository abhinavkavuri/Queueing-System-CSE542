package roles;

/**
 * Created By ReddyGadu Created On 2/23/20 Project Name StudentList
 **/
public class Student {
	String userName = "";
	String email = "";
	Status status;
	String pwd;

	public Student(String name, String email, Status status) {
		this.userName = name;
		this.email = email;
		this.status = status;
	}

	public Student() {
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public String getStatus() {
		return status.toString();
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public enum Status {
		PAUSED, UNPAUSED;
	}
}
