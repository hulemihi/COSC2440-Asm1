package Asm1;

public class StudentEnrolment {
	private Student student;
	private Course course;
	private String semester;
	
	//	Constructor
	public StudentEnrolment(Student student, Course course, String semester) {
		super();
		this.student = student;
		this.course = course;
		this.semester = semester;
	}
	
	public static void main(String args[]) {
		System.out.println("Basic");
	}
}
