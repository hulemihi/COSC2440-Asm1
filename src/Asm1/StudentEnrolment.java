package Asm1;


public class StudentEnrolment {
	private Student student;
	private Course course;
	private String semester;

	
	//	Constructor
	public StudentEnrolment(Student student, Course course, String semester) {
		this.student = student;
		this.course = course;
		this.semester = semester;
	}

	//	Getter and Setter
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public String toString() {
		return this.student + ", " + this.course + ", " + this.semester;
	}
	
	public String toFileString() {
		return String.join(",", this.student.getStudentID(), this.student.getStudentName(), this.student.getBirthdate(),
								this.course.getCourseID(), this.course.getCourseName(), this.course.getCredits(),
								this.semester);
	}
}

