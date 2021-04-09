package Asm1;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentEnrolmentSystem implements StudentEnrolmentManager{
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<StudentEnrolment> enrolmentList;
	
	
	public StudentEnrolmentSystem() {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		enrolmentList = new ArrayList<StudentEnrolment>();
	}

	@Override
	public void add(StudentEnrolment se) {
		// TODO Auto-generated method stub
		enrolmentList.add(se);
//		System.out.println(studentList);
//		if (studentList.isEmpty()) {
//			System.out.println("0");
//			studentList.add(se.getStudent());}
//		for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext(); ) {
//			Student student =iterator.next();
//			 if ((student.checkStudentList(se.getStudent().getStudentID()))) {
//				System.out.println("1");
//				break;
//			}
//			else {
//				studentList.add(se.getStudent());
//				System.out.println("2");
//			}
//		}
		studentList.add(se.getStudent());
		courseList.add(se.getCourse());
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
		for (StudentEnrolment se: enrolmentList) {
			System.out.println(se.toString());
		}
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
	
	
	
	
}
