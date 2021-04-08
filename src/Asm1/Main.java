package Asm1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String argsp[]) {
		
		//	Student
		Student hieu = new Student("1", "Hieu", "1998");
		Student minh = new Student("2", "Minh", "2000");
		Student nghia = new Student("3", "Nghia", "1999");
		
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
		List<StudentEnrolment> enrol = new ArrayList<>();
		StudentEnrolment e1 = new StudentEnrolment();
		e1.add(hieu, sepm,"2020");
		enrol.add(e1);
		
		
		
		
		
//		enrol.add(nghia, sepm, "2020");
//		enrol.add(minh, sepm, "2020");
//		enrol.add(hieu, sadi, "2020");
//		enrol.add(minh, sadi," 2020");
		
		enrol.displayAllStudent();	
	}
}
