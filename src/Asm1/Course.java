package Asm1;

public class Course {
	private String courseID;
	private String courseName;
	private String credits;
	
	//	Constructor
	public Course(String courseID, String courseName, String credits) {
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

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}
	
	public String toString() {
		return this.courseID + ", " + this.courseName + ", " + this.credits;
	}


}
