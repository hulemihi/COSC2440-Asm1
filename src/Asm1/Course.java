package Asm1;

public class Course {
	private String courseID;
	private String courseName;
	private int credits;
	
	//	Constructor
	public Course(String courseID, String courseName, int credits) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credits = credits;
	}
	
	//	Getter
	public String getCourseID() {
		return courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCredits() {
		return credits;
	}



}
