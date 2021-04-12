package Asm1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String argsp[]) throws FileNotFoundException {
		
		runEnrolmentSystem();
		// Scanner getInput = new Scanner(System.in);
		// System.out.println("------------------------------------- ");
		// System.out.println("Welcome to Student Enrolment System! \n");
		// System.out.println("Current enrolments file: default.csv ");
		// System.out.println("Do you want to change enrolments file? (y for yes,anything else for no) ");

		// String check = getInput.nextLine().trim();
		// if (check.equals("y")) {
			
		// }
		// else {
		// 	// System.out.println(enrolmentList = StudentEnrolmentSystem.getAllEnrolment());
		// 	StudentEnrolmentSystem se = StudentEnrolmentSystem.getAllEnrolment();
		// 	se.getAll();
		// 	System.out.println("------------------------------------- ");
		// 	se.displayAllCourses("2021A");
		// 	System.out.println("------------------------------------- ");
		// 	se.displayCouse("S101312", "2020C");
		// 	System.out.println("------------------------------------- ");
		// 	se.displayStudent("PHYS1230", "2021A");
		// }

	}

	public static void runEnrolmentSystem() throws FileNotFoundException {
		Scanner getInput = new Scanner(System.in);
		String fileName = "";
		System.out.println("------------------------------------- ");
		System.out.println("Welcome to Student Enrolment System! \n");
		System.out.println("------------------------------------- ");
		boolean checkFile = true;
		do {
			System.out.println("Current enrolments file: default.csv ");
			System.out.println("Do you want to change enrolments file? (y for yes,anything else for no) ");
			String check = getInput.nextLine().trim();
			if (check.equals("y")) {
				System.out.println("Enter new directory: ");
				fileName = getInput.nextLine().trim();
			} else {
				fileName = "default.csv";
			}
			try {
				StudentEnrolmentSystem se = StudentEnrolmentSystem.getAllEnrolment(fileName);
				System.out.println("------------------------------------- ");
				se.getAll();
				checkFile = true;
				runMenu(se);
			} catch (Exception ex) {
				System.out.println("File not found!");
				checkFile = false;
			} 
		} while (checkFile == false);
		
	}
	
	public static void runMenu(StudentEnrolmentSystem se) {
		Scanner getInput = new Scanner(System.in);
		String student = "";
		String course = "";
		String semester = "";

		System.out.println("------------------------------------- ");
		System.out.println("Student Enrolment System!");
		System.out.println("Please choose the process: ");
		System.out.println("	1. ");
		System.out.println("	2. Display all courses for 1 student in 1 semester. ");
		System.out.println("	4. Display all students of 1 course in 1 semester.");
		System.out.println("	4. Display all courses offered in 1 semester. ");
		System.out.println("Enter the process: ");
		
		String process = getInput.nextLine().trim();
		switch (process) {
			case "1":
				System.out.println("------------------------------------- ");
			 
				break;
			case "2":
				System.out.println("------------------------------------- ");
				System.out.println("Display all courses for 1 student in 1 semester. ");
				System.out.println("Enter student ID: ");
				student = getInput.nextLine().trim();
				System.out.println("Enter semester: ");
				semester = getInput.nextLine().trim();
				se.displayCouse(student, semester);
				break;
			case "3":
				System.out.println("------------------------------------- ");
				System.out.println("Display all students of 1 course in 1 semester.");
				System.out.println("Enter course ID: ");
				course = getInput.nextLine().trim();
				System.out.println("Enter semester: ");
				semester = getInput.nextLine().trim();
				se.displayStudent(course, semester);
				break;
			case "4":
				System.out.println("------------------------------------- ");
				System.out.println("Display all courses offered in 1 semester.");
				System.out.println("Enter semester: ");
				semester = getInput.nextLine().trim();
				se.displayAllCourses(semester);
				break;
		}	
		System.out.println("------------------------------------- ");
		System.out.println("Do you want to continue? (y for yes,anything else for no) ");
		String check = getInput.nextLine().trim();
		if (check.equals("y")) {
			runMenu(se);
		}  else {
			System.out.println("Quit Enrolment System! ");
		}
	}
}
