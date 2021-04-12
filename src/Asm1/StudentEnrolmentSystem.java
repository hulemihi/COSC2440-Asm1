package Asm1;


import java.io.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	public void update(StudentEnrolmentSystem ses, StudentEnrolment currentEnrol) throws NullPointerException{
		// TODO Auto-generated method stub
		if (checkExistEnrolment(currentEnrol) == false) {
			System.out.println("Cannot find the enrolment!");
		} else {
			try {
				System.out.println("Updated enrolment!");
				StudentEnrolment newEnrol = ses.getEnrolmentInfo(ses);
				if (checkExistEnrolment(newEnrol) == true) {
					System.out.println("Enrolment already exist!");
				} else {
					ses.add(newEnrol);
					ses.delete(currentEnrol);
				}
			} catch (Exception ex) {

			}
		}
	}
	
	//	Delete student enrollment on StudentEnrolment system.
	@Override
	public void delete(StudentEnrolment se) {
		// TODO Auto-generated method stub
		if (checkExistEnrolment(se) == false) {
			System.out.println("Cannot find the enrolment!");
		} else {
			enrolmentList.remove(se);
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
		} else {
			System.out.println("Enrolment does not exist!");
		}
	}
	
	//	Display all student enrollments in StudentEnrolment system.
	@Override
	public  void getAll() {
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
	public void addStudent(StudentEnrolmentSystem ses) {
		StudentEnrolment se = ses.getEnrolmentInfo(ses);
		if (checkExistEnrolment(se) == true) {
			System.out.println("Enrolment already exist!");
		} else {
			ses.add(se);
		}
	}
	
	//	Update student into StudentEnrolment system. 
	public void updateStudent(StudentEnrolmentSystem ses) {
		Scanner getInput = new Scanner(System.in);
		String student = "";
		String semester = "";
		String course = "";
		String option = "";
		
		do {
			System.out.print("Enter student ID: ");
			student = getInput.nextLine().trim();
			if (ses.checkExistStudent(student) == false) {
				System.out.println("Wrong input!");
			}
		} while (ses.checkExistStudent(student) == false);
		System.out.print("Enter semester: ");
		semester = getInput.nextLine().trim();	
		System.out.println("Student: " + student + ", Semester: " + semester);
		System.out.println("Course: ");
		for (StudentEnrolment se: enrolmentList) {
			if (se.getStudent().getStudentID().equals(student) && se.getSemester().equals(semester)) {
				System.out.println("	" + se.getCourse().toString());
			}
		}
		System.out.println("Do you want to update ? ");
		System.out.println("	1. Delete course.");
		System.out.println("	2. Add new course.");
		System.out.println("Or press any button to quit.");
		System.out.print("Enter the process: ");
		option = getInput.nextLine().trim();
		if (option.equals("2")) {
			do {
				System.out.print("Enter course ID: ");
				course = getInput.nextLine().trim();
				if (ses.checkExistCourse(course) == false) {
					System.out.println("Wrong input!");
				}
			} while (ses.checkExistCourse(course) == false);
			StudentEnrolment newEnrol = new StudentEnrolment(ses.getStudentByID(student), ses.getCourseByID(course), semester);
			ses.add(newEnrol);
			System.out.println("Added course successfully!");
		}
		else if (option.equals("1")) {
			do {
				System.out.print("Enter course ID: ");
				course = getInput.nextLine().trim();
				if (ses.checkExistCourse(course) == false) {
					System.out.println("Wrong input!");
				}
			} while (ses.checkExistCourse(course) == false);
			for (int i = 0; i < enrolmentList.size(); i++) {
				if (enrolmentList.get(i).getStudent().getStudentID().equals(student) && enrolmentList.get(i).getSemester().equals(semester) && enrolmentList.get(i).getCourse().getCourseID().equals(course)) {
					ses.delete(enrolmentList.get(i));
					System.out.println("Deleted course successfully!");
				}
			}
		}
		else return;
	}
	
	//	Delete student on StudentEnrolment system.
	public void deleteStudent(StudentEnrolmentSystem ses) {
		Scanner getInput = new Scanner(System.in);
		System.out.print("Enter student ID: ");
		String student = getInput.nextLine().trim().toUpperCase();
		if (checkExistStudent(student) == true) {
			for (int i = 0; i < enrolmentList.size(); i++) {
				if (enrolmentList.get(i).getStudent().getStudentID().equals(student)) {
					System.out.println("	" + enrolmentList.get(i).toString());
				}
			}
			System.out.println("Do you want to delete student's enrolments ? (y for yes,anything else for no) ");
			String option = getInput.nextLine().trim().toLowerCase();
			if (option.equals("y")) {
				for (int j = 0; j < enrolmentList.size(); j++) {
					if (enrolmentList.get(j).getStudent().getStudentID().equals(student)) {
						ses.delete(enrolmentList.get(j));
						
					}
				}
				System.out.println("Deleted student enrolment successfully!");
			}
		}
		else {
			System.out.println("Student does not exists!");
		}
	}
	

	/*
	 * 
	 * 	Display methods
	 * 
	 * */
	
	//	Print all courses for 1 student in 1 semester. 
	public void displayCouse(String studentID, String semester) {
		System.out.println("Student: " + studentID + ", Semester: " + semester);
		System.out.println("Course: ");
		for (StudentEnrolment se: enrolmentList) {
			if (se.getSemester().equals(semester) && se.getStudent().getStudentID().equals(studentID)) {
				System.out.println("	" + se.getCourse());
			}
		}
		System.out.println("Do you want to save the reports to CSV files? (y for yes,anything else for no) ");
		Scanner getInput = new Scanner(System.in);
		String option = getInput.nextLine().trim().toLowerCase();
		if (option.equals("y")) {
			try {
				FileWriter file = new FileWriter(studentID +"_"+ semester+ "_courses.csv");
				for (StudentEnrolment se: enrolmentList) {
					if (se.getSemester().equals(semester) && se.getStudent().getStudentID().equals(studentID)) {
						file.write(se.getCourse().toString()+"\n");
					}
				}
				file.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
			}
		}
	}
	
	//	Print all students of 1 course in 1 semester.
	public void displayStudent(String courseID, String semester) {
		System.out.println("Course: " + courseID + ", Semester: " + semester);
		System.out.println("Students: ");
		for (StudentEnrolment se: enrolmentList) {
			if (se.getSemester().equals(semester) && se.getCourse().getCourseID().equals(courseID)) {
				System.out.println("	" + se.getStudent());
			}
		}
		System.out.println("Do you want to save the reports to CSV files? (y for yes,anything else for no) ");
		Scanner getInput = new Scanner(System.in);
		String option = getInput.nextLine().trim().toLowerCase();
		if (option.equals("y")) {
			try {
				FileWriter file = new FileWriter(courseID +"_"+ semester+ "_students.csv");
				for (StudentEnrolment se: enrolmentList) {
					if (se.getSemester().equals(semester) && se.getCourse().getCourseID().equals(courseID)) {
						file.write(se.getStudent().toString()+"\n");
					}
				}
				file.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
			}
		}
	}
	
	//	Prints all courses offered in 1 semester.	
	public void displayAllCourses (String semester) {
		System.out.println("Semester: " + semester);
		System.out.println("Course: ");
		for (StudentEnrolment se: enrolmentList) {
			if (se.getSemester().equals(semester)) {
				System.out.println("	" + se.getCourse());
			}
		}
		System.out.println("Do you want to save the reports to CSV files? (y for yes,anything else for no) ");
		Scanner getInput = new Scanner(System.in);
		String option = getInput.nextLine().trim().toLowerCase();
		if (option.equals("y")) {
			try { 
				FileWriter file = new FileWriter(semester+ "_courses.csv");
				for (StudentEnrolment se: enrolmentList) {
					if (se.getSemester().equals(semester)) {
						file.write(se.getCourse().toString()+"\n");
					}
				}
				file.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
			}
		}
	}


	/*
	 * 
	 * 	Methods support for StudentEnrolment system.
	 * 
	 * */

	//  Get enrolment information from user
	public StudentEnrolment getEnrolmentInfo(StudentEnrolmentSystem ses) {
		Scanner getInput = new Scanner(System.in);
		String student = "";
		String course = "";
		String semester = "";
		
		do {
			System.out.print("Enter student ID: ");
			student = getInput.nextLine().trim();
			if (ses.checkExistStudent(student) == false) {
				System.out.println("Wrong input!");
			}
		} while (ses.checkExistStudent(student) == false);
		do {
			System.out.print("Enter course ID: ");
			course = getInput.nextLine().trim();
			if (ses.checkExistCourse(course) == false) {
				System.out.println("Wrong input!");
			}
		} while (ses.checkExistCourse(course) == false);
		System.out.print("Enter semester: ");
		semester = getInput.nextLine().trim();	
		StudentEnrolment newEnrol = new StudentEnrolment(ses.getStudentByID(student), ses.getCourseByID(course), semester);
		return newEnrol;
	}
	
	//  Get student by student ID
	public Student getStudentByID(String id) {
		for (Student s:studentList) {
			if (s.getStudentID().equals(id)) {
				return s;
			}
		}
		return null;
	}

	// Get course by course ID
	public Course getCourseByID(String id) {
		for (Course c:courseList) {
			if (c.getCourseID().equals(id)) {
				return c;
			}
		}
		return null;
	}

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
	
	//	Get the enrolments from file
	public static StudentEnrolmentSystem getAllEnrolment(String fileName) throws FileNotFoundException {
		Scanner se = new Scanner(new File(fileName));
		StudentEnrolmentSystem enrolmentList = new StudentEnrolmentSystem();
		while (se.hasNext()) {
			String nextLine = se.nextLine();
			String[] seSplit = nextLine.split(",");
			Student student = new Student(seSplit[0], seSplit[1], seSplit[2]);
			Course course = new Course(seSplit[3], seSplit[4], seSplit[5]);
			StudentEnrolment enrolment = new StudentEnrolment(student, course, seSplit[6]);
			enrolmentList.add(enrolment);
		}
		se.close();
		return enrolmentList;
	}
}
