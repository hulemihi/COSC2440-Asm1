package Asm1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String argsp[]) {
		
		//	Student
		Student hieu = new Student("1", "Hieu", "1998");
		Student minh = new Student("2", "Minh", "2000");
		Student nghia = new Student("3", "Nghia", "1999");
		Student tri = new Student("4", "Tri", "1998");
		Student den = new Student("5", "Tri", "1998");
		
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(hieu);
		studentList.add(minh);
		studentList.add(nghia);
		
		//	Course
		Course sepm = new Course("1", "SEPM", 4);
		Course sadi = new Course("2", "SADI", 8);
		Course eeee = new Course("3", "EEEE", 4);
		
		List<Course> courseList = new ArrayList<>();
		courseList.add(sepm);
		courseList.add(sadi);
		courseList.add(eeee);
		
		//	Enrollment
		StudentEnrolment e1 = new StudentEnrolment(hieu, sepm,"2020");
		StudentEnrolment e2 = new StudentEnrolment(hieu, sadi,"2020");
		StudentEnrolment e3 = new StudentEnrolment(hieu, eeee,"2020");
		StudentEnrolment e4 = new StudentEnrolment(minh, sepm,"2020");
		StudentEnrolment e5 = new StudentEnrolment(nghia, sepm,"2020");
		
		
		//	System
//		List<StudentEnrolmentSystem> enrolSystem = new ArrayList<StudentEnrolmentSystem>();
		StudentEnrolmentSystem ses = new StudentEnrolmentSystem();
		ses.add(e1);
		ses.add(e2);
		ses.add(e3);
		ses.add(e4);
		ses.add(e5);
		
		ses.displayAllStudent();
		System.out.println("----------");
		ses.displayAllCourse();
		System.out.println("----------");
		ses.getAll();
		System.out.println("----------");
		ses.getOne(nghia, eeee, null);
		ses.getOne(hieu, sepm, "2020");
		System.out.println("----------");
		ses.delete(e5);
		ses.getAll();
		System.out.println("----------");
		ses.addStudent(nghia);
		ses.addStudent(tri);
		ses.displayAllStudent();
		System.out.println("----------");
		ses.deleteStudent(den);
		ses.displayAllStudent();
		ses.deleteStudent(tri);
		ses.displayAllStudent();
		
	}
}
