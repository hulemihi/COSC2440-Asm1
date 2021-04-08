package Asm1;

import java.util.ArrayList;

public class StudentEnrolment implements StudentEnrolmentManager {
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<String> semesterList;
	private int seID;

	
	//	Constructor
	public StudentEnrolment() {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		semesterList = new ArrayList<String>();
	}
	

	@Override
	public void add(Student student, Course course, String semester) {
		// TODO Auto-generated method stub
		studentList.add(student);
		courseList.add(course);
		semesterList.add(semester);
		seID++;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOne(int seID) {
		// TODO Auto-generated method stub
		for (Student student: studentList) {
			
		}
	}
	
	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	public void updateStudent(Student student) {
		
	}
	public void deleteStudent(Student student) {
		studentList.remove(student);
	}
	
	public void displayAllStudent() {
		for (Student s: studentList) {
			System.out.println(s);
		}
	}
	
	public void displayAllCourse() {
		for (Course c: courseList) {
			System.out.println(c);
		}
	}
	
//	public void displayAllStudentInCourse(Course course) {
//		for (StudentEnrolment se: enrolmentList) {
//			if (se.getCourseName().equals(course))
//			System.out.println(s);
//		}
//	}
//	
	public String toString() {
		return "\nStudent: " + this.studentList + ", Course: " + this.courseList + ","
				+ " Semester: " + this.semesterList ;
	}
	



	
	
}

