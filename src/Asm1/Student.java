package Asm1;


public class Student {
	private String studentID;
	private String studentName;
	private String birthdate;
	
	//	Constructor
	public Student(String studentID, String studentName, String birthdate) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.birthdate = birthdate;
	}

	//	Getter and Setter
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public String toString() {
		return  this.studentID + ", " + this.studentName + ", " + this.birthdate;
	}

}
