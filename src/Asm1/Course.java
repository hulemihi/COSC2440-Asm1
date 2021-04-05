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

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public String toString() {
		return "CourseID: " + this.courseID + ", Name: " + this.courseName + ", Credits: " + this.credits;
	}


}
