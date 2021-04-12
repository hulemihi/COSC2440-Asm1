package Asm1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static StudentEnrolmentSystem ses;
	static Scanner getInput = new Scanner(System.in);
	static String student = "";
	static String course = "";
	static String semester = "";
	static String option = "";
	
	// Main
	public static void main(String argsp[]) throws FileNotFoundException {
		runEnrolmentSystem();
	}

	// Welcome message 
	public static void runEnrolmentSystem() throws FileNotFoundException {
		Scanner getInput = new Scanner(System.in);
		String fileName = "";
		System.out.println("------------------------------------- ");
		System.out.println("Welcome to Student Enrolment System! ");
		System.out.println("------------------------------------- ");
		boolean checkFile = true;
		do {
			System.out.println("Current enrolments file: default.csv ");
			System.out.print("Do you want to change enrolments file? (y for yes,anything else for no) ");
			String check = getInput.nextLine().trim();
			if (check.equals("y")) {
				System.out.print("Enter new directory: ");
				fileName = getInput.nextLine().trim();
			} else {
				fileName = "default.csv";
			}
			try {
				ses = StudentEnrolmentSystem.getAllEnrolment(fileName);
				System.out.println("------------------------------------- ");
				ses.getAll();
				checkFile = true;
			} catch (Exception ex) {
				System.out.println("File not found!");
				checkFile = false;
			} 
		} while (checkFile == false);
		runMenu(ses);
	}
	
	// Enrolment System main menu
	public static void runMenu(StudentEnrolmentSystem ses) {
		System.out.println("------------------------------------- ");
		System.out.println("Student Enrolment System!");
		System.out.println("Please choose the process: ");
		System.out.println("	1. Enrolment operation.");
		System.out.println("	2. Student enrolment. ");
		System.out.println("	3. Display student enrolments.");
		System.out.print("Enter the process: ");
		String process = getInput.nextLine().trim();
		switch (process) {
			case "1":
				enrolmentOperation();
				break;
			case "2":
				studentEnrolment();
				break;
			case "3":
				displayEnrolment();
				break;
			default :
				System.out.println("Wrong input!");
		}
		System.out.println("------------------------------------- ");
		System.out.print("Do you want to continue? (y for yes,anything else for no) ");
		String check = getInput.nextLine().trim();
		if (check.equals("y")) {
			runMenu(ses);
		}  else {
			System.out.println("Quit Enrolment System! ");
		}
	}

	// Enrolment operation menu
	public static void enrolmentOperation() {
		System.out.println("------------------------------------- ");
		System.out.println("Enrolment operation:");
		System.out.println("Please choose the operation: ");
		System.out.println("	1. Create a new enrolment.");
		System.out.println("	2. Update the enrolment.");
		System.out.println("	3. Delete the enrolment.");
		System.out.print("Enter the process: ");
		option = getInput.nextLine().trim();
		if (option.equals("1")) {
			StudentEnrolment newEnrol = ses.getEnrolmentInfo(ses);
			if (ses.checkExistEnrolment(newEnrol) == false) {
				ses.add(newEnrol);
				newEnrol.toString();
				System.out.println("Created enrolment successfully!");
			} else {
				System.out.println("Enrolment already exist!");
			}
		}
		else if (option.equals("2")) {
			StudentEnrolment currentEnrol = ses.getEnrolmentInfo(ses);
			ses.update(ses, currentEnrol);
			System.out.println("Update enrolment successfully!");
		}
		else if (option.equals("3")) {
			StudentEnrolment deleteEnrol = ses.getEnrolmentInfo(ses);
			ses.delete(deleteEnrol);
			System.out.println("Deleted enrolment successfully!");
		}
		else {
			System.out.println("Wrong input!");
		}
	}

	// Student enrolments menu
	public static void studentEnrolment() {
		System.out.println("------------------------------------- ");
		System.out.println("Student enrolments:");
		System.out.println("Please choose the operation: ");
		System.out.println("	1. New enrolment.");
		System.out.println("	2. Update an enrolment of a student for 1 semester");
		System.out.println("	3. Delete student enrolment.");
		System.out.print("Enter the process: ");
		option = getInput.nextLine().trim();
		if (option.equals("1")) {
			System.out.println("------------------------------------- ");
			System.out.println("New enrolment: ");
			ses.addStudent(ses);
			System.out.println("Created enrolment successfully!");
		}
		else if (option.equals("2")) {
			System.out.println("------------------------------------- ");
			System.out.println("Update an enrolment of a student for 1 semester: ");
			ses.updateStudent(ses);
		}
		else if (option.equals("3")) {
			System.out.println("------------------------------------- ");
			System.out.println("Delete student enrolment.");
			ses.deleteStudent(ses);
		}
	}

	// Display enrolments menu
	public static void displayEnrolment() {
		System.out.println("------------------------------------- ");
		System.out.println("Display student enrolments:");
		System.out.println("Please choose the operation: ");
		System.out.println("	1. Display all courses for 1 student in 1 semester.");
		System.out.println("	2. Display all students of 1 course in 1 semester.");
		System.out.println("	3. Display all courses offered in 1 semester.");
		System.out.print("Enter the process: ");
		option = getInput.nextLine().trim();
		if (option.equals("1")) { 
			System.out.println("------------------------------------- ");
			System.out.println("Display all courses for 1 student in 1 semester. ");
			System.out.print("Enter student ID: ");
			student = getInput.nextLine().trim();
			System.out.print("Enter semester: ");
			semester = getInput.nextLine().trim();
			ses.displayCouse(student, semester);
		}
		else if (option.equals("2")) {
			System.out.println("------------------------------------- ");
			System.out.println("Display all students of 1 course in 1 semester.");
			System.out.print("Enter course ID: ");
			course = getInput.nextLine().trim();
			System.out.print("Enter semester: ");
			semester = getInput.nextLine().trim();
			ses.displayStudent(course, semester);
		}
		else if (option.equals("3")) {
			System.out.println("------------------------------------- ");
			System.out.println("Display all courses offered in 1 semester.");
			System.out.print("Enter semester: ");
			semester = getInput.nextLine().trim();
			ses.displayAllCourses(semester);
		}
		else {
			System.out.println("Wrong input!");
		}
	}
}
