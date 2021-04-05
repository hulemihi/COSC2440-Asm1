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
	
	//	Getter
	public String getStudentID() {
		return studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getBirthdate() {
		return birthdate;
	}
	
}
