package Asm1;

public interface StudentEnrolmentManager {
	
	public void add(StudentEnrolment se);
	public void update(StudentEnrolment se);
	public void delete(StudentEnrolment se);
	public void getOne(Student student, Course course, String semester);
	public void getAll();
	
}
