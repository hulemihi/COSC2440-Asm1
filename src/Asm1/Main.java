package Asm1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String argsp[]) throws FileNotFoundException {
		
//		//	Student
//		Student hieu = new Student("1", "Hieu", "1998");
//		Student minh = new Student("2", "Minh", "2000");
//		Student nghia = new Student("3", "Nghia", "1999");
//		Student tri = new Student("4", "Tri", "1998");
//		Student den = new Student("5", "Tri", "1998");
//		
//		
//		List<Student> studentList = new ArrayList<>();
//		studentList.add(hieu);
//		studentList.add(minh);
//		studentList.add(nghia);
//		
//		//	Course
//		Course sepm = new Course("1", "SEPM", 4);
//		Course sadi = new Course("2", "SADI", 8);
//		Course eeee = new Course("3", "EEEE", 4);
//		
//		List<Course> courseList = new ArrayList<>();
//		courseList.add(sepm);
//		courseList.add(sadi);
//		courseList.add(eeee);
//		
//		//	Enrollment
//		StudentEnrolment e1 = new StudentEnrolment(hieu, sepm,"2020");
//		StudentEnrolment e2 = new StudentEnrolment(hieu, sadi,"2020");
//		StudentEnrolment e3 = new StudentEnrolment(hieu, eeee,"2020");
//		StudentEnrolment e4 = new StudentEnrolment(minh, sepm,"2020");
//		StudentEnrolment e5 = new StudentEnrolment(nghia, sepm,"2020");
//		
//		
//		//	System
////		List<StudentEnrolmentSystem> enrolSystem = new ArrayList<StudentEnrolmentSystem>();
//		StudentEnrolmentSystem ses = new StudentEnrolmentSystem();
//		ses.add(e1);
//		ses.add(e2);
//		ses.add(e3);
//		ses.add(e4);
//		ses.add(e5);
//		
//		ses.displayAllStudent();
//		System.out.println("----------");
//		ses.displayAllCourse();
//		System.out.println("----------");
//		ses.getAll();
//		System.out.println("----------");
//		
//		ses.getOne(nghia, eeee, null);
//		ses.getOne(hieu, sepm, "2020");
//		System.out.println("----------");
//		
//		ses.delete(e5);
//		ses.getAll();
//		System.out.println("----------");
//		
////		ses.addStudent(nghia);
////		ses.addStudent(tri);
//		ses.displayAllStudent();
//		System.out.println("----------");
//		
//		ses.deleteStudent(den);
//		ses.displayAllStudent();
//		ses.deleteStudent(tri);
//		ses.deleteStudent(hieu);
//		ses.displayAllStudent();
//		ses.getAll();
		
		Scanner getInput = new Scanner(System.in);
		System.out.println("------------------------------------- ");
		System.out.println("Welcome to Student Enrolment System! \n");
		System.out.println("Current enrolments file: default.csv ");
		System.out.println("Do you want to change enrolments file? (y for yes,anything else for no) ");

		String check = getInput.nextLine().trim();
		if (check.equals("y")) {
			
		}
		else {
			// System.out.println(enrolmentList = StudentEnrolmentSystem.getAllEnrolment());
			StudentEnrolmentSystem se = StudentEnrolmentSystem.getAllEnrolment();
			se.getAll();
			System.out.println("------------------------------------- ");
			se.displayAllCourses("2021A");
			System.out.println("------------------------------------- ");
			se.displayCouse("S101312", "2020C");
			System.out.println("------------------------------------- ");
			se.displayStudent("PHYS1230", "2021A");
		}
		

	}
}
