package Asm1;


public interface StudentEnrolmentManager {

	public boolean add(StudentEnrolment se);
	public boolean update(StudentEnrolmentSystem ses,StudentEnrolment se);
	public boolean delete(StudentEnrolment se);
	public boolean getOne(Student student, Course course, String semester);
	public boolean getAll();

}
