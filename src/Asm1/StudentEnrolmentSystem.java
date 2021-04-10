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
		//	Add student to studentList
		if (studentList.isEmpty()) {
			System.out.println("0");
			studentList.add(se.getStudent());}
		boolean checkExistStudent = false;
		for (int i=0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			 if ((student.checkStudentList(se.getStudent().getStudentID()))) {
				break;
			}
			else {
				checkExistStudent = true;
			}
		}
		if (checkExistStudent == true) {
			studentList.add(se.getStudent());
		}
		//	Add course to courseList
		courseList.add(se.getCourse());
		
		//	Test	
		System.out.println(studentList);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(StudentEnrolment se) {
		// TODO Auto-generated method stub
		boolean checkEnrolment = false;
		for (int i = 0; i < enrolmentList.size(); i++) {
			StudentEnrolment enrolment = enrolmentList.get(i);
			if (se.getStudent().getStudentID().equals(enrolment.getStudent().getStudentID()) 
					&& se.getCourse().getCourseID().equals(enrolment.getCourse().getCourseID())
					&& se.getSemester().equals(enrolment.getSemester())) {
				enrolmentList.remove(enrolment);
				checkEnrolment = true;
			}
			
		}
		if (checkEnrolment == false) {
			System.out.println("Cannot find the enrolment!");
		} else {
			System.out.println("Deleted successfully!");
		}
		
	}
	

	@Override
	public void getOne(Student student, Course course, String semester) {
		// TODO Auto-generated method stub
		boolean checkEnrolment = false;
		for (StudentEnrolment se: enrolmentList) {
			if(se.getStudent().getStudentID().equals(student.getStudentID()) 
					&& se.getCourse().getCourseID().equals(course.getCourseID())
					&& se.getSemester().equals(semester)) {
				System.out.println(se.toString());
				checkEnrolment = true;
			}
		}
		if (checkEnrolment == false) {
			System.out.println("Cannot find the enrolment!");
		} else {
			System.out.println("Enrolment exist!");
		}
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		for (StudentEnrolment se: enrolmentList) {
			System.out.println(se.toString());
		}
	} 
	
	public void addStudent(Student student) {
		boolean checkExistStudent = false;
		for (Student s: studentList) {
			if (s.getStudentID().equals(student.getStudentID())) {
				System.out.println("Student already exists!");
				checkExistStudent = false;
			}
			else checkExistStudent = true;
		}
		if (checkExistStudent == true) {
			studentList.add(student);
			System.out.println("Added student successfully!");
		}
		
	}
	
	public void updateStudent(Student student) {
		
	}
	
	public void deleteStudent(Student student) {
		boolean checkExistStudent = false;
		for (Student s: studentList) {
			if (s.getStudentID().equals(student.getStudentID())) {
				System.out.println("Student does not exists!");
				checkExistStudent = false;
			}
			else checkExistStudent = true;
		}
		if (checkExistStudent == false) {
			studentList.remove(student);
			System.out.println("Removed student successfully!");
		}
//		studentList.remove(student);
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
