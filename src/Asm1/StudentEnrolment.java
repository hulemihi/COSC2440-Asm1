package Asm1;

import java.util.ArrayList;

public class StudentEnrolment implements StudentEnrolmentManager {
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<String> semesterList;
	
	//	Constructor
	public StudentEnrolment(Student student, Course course, String semester) {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		semesterList = new ArrayList<String>();
		this.studentList.add(student);
		this.courseList.add(course);
		this.semesterList.add(semester);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOne() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
	
	}
	
	public void addStudent(Student s) {
		studentList.add(s);
	}
	public void updateStudent(Student s) {
		
	}
	public void deleteStudent(Student s) {
		studentList.remove(s);
	}
	
	public void displayAllStudent() {
		for (Student s: studentList) {
			System.out.println(s);
		}
	}
	
	public void displayAllStudentInCourse(Course course, String semester) {
		for (StudentEnrolment se: enrolmentList) {
			if (c.getCourseName().equals(course) && )
			System.out.println(s);
		}
	}
	
	public static void main(String args[]) {
		Student s1 = new Student("s3804595", "Hieu","1998");
		Student s2 = new Student("s3804599", "Minh","2000");
		Student s3 = new Student("s3dasd99", "bla","6969");

		Course c1 = new Course("COSC2440", "SADI", 12);
		Course c2 = new Course("COSC2444", "SADIII", 12);
		
		ArrayList<StudentEnrolment> enrolmentList = new ArrayList<StudentEnrolment>();
		
		StudentEnrolment e1 = new StudentEnrolment(s1,c1,"SemA-2021");
		e1.addStudent(s2);
		StudentEnrolment e2 = new StudentEnrolment(s3,c2,"SemB-2021");
		enrolmentList.add(e1);
		enrolmentList.add(e2);
		
		e1.displayAllStudent();
		e2.displayAllStudent();
		
		
	}
	
}

class Testing{
	
}
