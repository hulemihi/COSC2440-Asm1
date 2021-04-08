package Asm1;

public interface StudentEnrolmentManager {
	
	public void add(Student student, Course course, String semester);
	public void update();
	public void getOne(int seID);
	public void getAll();
	
}
