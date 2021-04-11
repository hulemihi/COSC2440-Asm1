package Asm1;

import java.util.Scanner;

public class Helper {
	
	// Get enrollment form user input
	public static void getStudentEnrolment() {
		System.out.println("Enter enrollment information: \n");
		
		//	Get Student information		
		System.out.println("1/ Student information: \n");
		
		System.out.println("----Student ID: \n");
		Scanner getStudentID = new Scanner(System.in);
		String studentID = getStudentID.nextLine().trim();
		
		System.out.println("----Student name: \n");
		Scanner getStudentName = new Scanner(System.in);
		String studentName = getStudentName.nextLine().trim();
		
		System.out.println("----Student birthdate: \n");
		Scanner getStudentBd = new Scanner(System.in);
		String studentBd = getStudentBd.nextLine().trim();
		
		Student student = new Student(studentID, studentName, studentBd);
		
		//	Get Course information
		System.out.println("2/ Course information: \n");
		
		System.out.println("----Course ID: \n");
		Scanner getCourseID = new Scanner(System.in);
		String courseID = getCourseID.nextLine().trim();
		
		System.out.println("----Student name: \n");
		Scanner getCourseName = new Scanner(System.in);
		String courseName = getCourseName.nextLine().trim();
		
		System.out.println("----Student birthdate: \n");
		Scanner getCredit = new Scanner(System.in);
		int credit = getCredit.nextInt();
		
		Course course = new Course(courseID, courseName, credit);
	}
	
	
}
