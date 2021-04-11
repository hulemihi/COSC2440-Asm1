package Asm1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentEnrolmentSystem implements StudentEnrolmentManager{
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<StudentEnrolment> enrolmentList;
	
	// Constructor	
	public StudentEnrolmentSystem() {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		enrolmentList = new ArrayList<StudentEnrolment>();
	}
	
	
	/*
	 * 
	 * 	Implement interface methods
	 * 
	 * */
	
	//	Add student enrollment into StudentEnrolment system.
	@Override
	public void add(StudentEnrolment se) {
		// TODO Auto-generated method stub
		//	Add enrollment to enrolmentList
		enrolmentList.add(se);
		//	Add student to studentList
		if (studentList.isEmpty()) {
			studentList.add(se.getStudent());
			}
		else if (checkExistStudent(se.getStudent().getStudentID()) == false) {
			studentList.add(se.getStudent());
		}
		//	Add course to courseList
		if (courseList.isEmpty()) {
			courseList.add(se.getCourse());
		}
		else if (checkExistCourse(se.getCourse().getCourseID()) == false) {
			courseList.add(se.getCourse());
		}
	}
	
	//	Update student enrollment into StudentEnrolment system.
	@Override
	public void update(StudentEnrolment se) {
		// TODO Auto-generated method stub
		if (checkExistEnrolment(se) == false) {
			System.out.println("Cannot find the enrolment!");
		}
		else {
			
			System.out.println("Update enrolment!");
			System.out.println("Just press enter if you don't want to change the current value of any attributes.");
			
		}
	}
	
	//	Delete student enrollment on StudentEnrolment system.
	@Override
	public void delete(StudentEnrolment se) {
		// TODO Auto-generated method stub
		if (checkExistEnrolment(se) == false) {
			System.out.println("Cannot find the enrolment!");
		} 
		else {
			enrolmentList.remove(se);
			System.out.println("Deleted enrolment successfully!");
		}
		
	}
	
	//	Display one student enrollment in StudentEnrolment system.
	@Override
	public void getOne(Student student, Course course, String semester) {
		// TODO Auto-generated method stub
		StudentEnrolment se = new StudentEnrolment(student, course, semester);
		if (checkExistEnrolment(se) == true) {
			System.out.println("Enrolment exist!");
			System.out.println(se.toString());
		}
		else {
			System.out.println("Enrolment does not exist!");
		}
	}
	
	//	Display all student enrollments in StudentEnrolment system.
	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		System.out.println("Student enrollment: ");
		for (StudentEnrolment se: enrolmentList) {
			System.out.println(se.toString());
		}
	} 
	
	
	/* 
	 * 
	 * 	Methods to enroll students in courses.
	 * 
	 **/
	
	//	Add student into StudentEnrolment system. 
	public void addStudent() {
		Scanner getInput = new Scanner(System.in);
		//	Get student ID	
		System.out.println("Enter student ID: ");
		String studentID = 	getInput.nextLine().trim();
		if (checkExistStudent(studentID) == false) {
			System.out.println("Student does not exist! Create a new student? (y for yes,anything else for no)");
			String check = getInput.nextLine().trim();
			if (check.equals("y")) {
				System.out.println("Student name: ");
				String studentName = getInput.nextLine().trim();
				System.out.println("Student birthdate: ");
				String studentBd = getInput.nextLine().trim();
				Student student = new Student(studentID, studentName, studentBd);
				studentList.add(student);
			}
			else return;
		}
		//	Get semester
		System.out.println("Enter semester: ");
		String semester = getInput.nextLine().trim();
		//	Get course		
		System.out.println("Enter course ID: ");
		String courseID = getInput.nextLine().trim();
		if (checkExistCourse(courseID) == false) {
			System.out.println("Course does not exist! Create a new course? (y for yes,anything else for no)");
			String check = getInput.nextLine().trim();
			if (check.equals("y")) {
				System.out.println("Course name: ");
				String courseName = getInput.nextLine().trim();
				System.out.println("Course crefit: ");
				int courseCredits = getInput.nextInt();
				Course course = new Course(courseID, courseName, courseCredits);
				courseList.add(course);
			}
			else return;
		}
		System.out.println("");
//		else {
//			
//		}
		//	Create an enrollment
//		StudentEnrolment se = new StudentEnrolment(studentList., course, semester);
	}
	
	//	Update student into StudentEnrolment system. 
	public void updateStudent(Student student) {
		
	}
	
	//	Delete student on StudentEnrolment system.
	public void deleteStudent(Student student) {
		if (checkExistStudent(student.getStudentID()) == true) {
			studentList.remove(student);
			System.out.println("Deleted student successfully!");
		}
		else {
			System.out.println("Student does not exists!");
		}
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
	
	/*
	 * 
	 * 	Display methods
	 * 
	 * */
	
	//	Print all courses for 1 student in 1 semester. 
	public void displayCouse(String studentID, String semester) {
		for (StudentEnrolment se: enrolmentList) {
			if (se.getSemester().equals(semester) && se.getStudent().getStudentID().equals(studentID)) {
				System.out.println(se.getCourse());
			}
		}
	}
	
	//	Print all students of 1 course in 1 semester.
	public void displayStudent(String courseID, String semester) {
		for (StudentEnrolment se: enrolmentList) {
			if (se.getSemester().equals(semester) && se.getCourse().getCourseID().equals(courseID)) {
				System.out.println(se.getStudent());
			}
		}
	}
	
	//	Prints all courses offered in 1 semester.	
	public void displayAllCourses (String semester) {
		for (StudentEnrolment se: enrolmentList) {
			if (se.getSemester().equals(semester)) {
				System.out.println(se.getCourse());
			}
		}
	}
	/*
	 * 
	 * 	Methods support for StudentEnrolment system.
	 * 
	 * */
	
	//	Check existing enrollment.
	public boolean checkExistEnrolment(StudentEnrolment se) {
		for (StudentEnrolment enrolment: enrolmentList) {
			if (se.getStudent().getStudentID().equals(enrolment.getStudent().getStudentID()) 
					&& se.getCourse().getCourseID().equals(enrolment.getCourse().getCourseID())
					&& se.getSemester().equals(enrolment.getSemester())) {
				return true;
			}
		}
		return false;
	}
	
	//	Check existing student.
	public boolean checkExistStudent(String id) {
		for (Student student: studentList) {
			if (student.getStudentID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	//	Check existing course.
	public boolean checkExistCourse(String id) {
		for (Course course: courseList) {
			if (course.getCourseID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
}
