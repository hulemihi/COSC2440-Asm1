package Asm1;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestLogic {
    public static StudentEnrolmentSystem ses;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {  
        ses = new StudentEnrolmentSystem();
        ses = StudentEnrolmentSystem.getAllEnrolment("default.csv");           
    }  

    @Before 
    public void setUpBeforeMethod() throws Exception {  
        System.out.println("------------------------------------- ");   
        System.out.println("New test: ");   
    }  

    @After 
    public void setUpAfterMethod() throws Exception {  
        System.out.println("End of test.");   
    } 

    @Test
    public void addTest() {
        System.out.println("Test add() enrolment method. ");   
        StudentEnrolment se = new StudentEnrolment(ses.getStudentByID("S101312"), ses.getCourseByID("COSC4030"), "2021A");
        assertTrue(ses.add(se));
    }


    @Test 
    public void deleteTest() {
        System.out.println("Test delete() enrolment method. ");   
        StudentEnrolment currentEnrol = new StudentEnrolment(ses.getStudentByID("S101312"), ses.getCourseByID("COSC4030"), "2020C");
        assertTrue(ses.delete(currentEnrol));
    }

    @Test 
    public void getOneTest() {
        System.out.println("Test getOne() enrolment method. ");   
        assertTrue(ses.getOne(ses.getStudentByID("S101312"), ses.getCourseByID("COSC4030"), "2020C"));
    }

    @Test 
    public void getAllTest() {
        System.out.println("Test getAll() enrolment method. ");
        assertTrue(ses.getAll());
    }

    @Test
    public void checkExistEnrolmentTest() {
        System.out.println("Test checkExistEnrolment() method. ");
        StudentEnrolment currentEnrol = new StudentEnrolment(ses.getStudentByID("S101312"), ses.getCourseByID("COSC4030"), "2020C");
        assertTrue(ses.checkExistEnrolment(currentEnrol));
        StudentEnrolment fakeEnrol = new StudentEnrolment(ses.getStudentByID("S101312"), ses.getCourseByID("COSC4030"), "2023C");
        assertFalse(ses.checkExistEnrolment(fakeEnrol));
    }

    @Test
    public void checkExistCourseTest() {
        System.out.println("Test checkExistEnrolment() method. ");
        assertTrue(ses.checkExistCourse("COSC4030"));
        assertFalse(ses.checkExistCourse("S101313"));
    }

    @Test
    public void checkExistStudentTest() {
        System.out.println("Test checkExistEnrolment() method. ");
        assertTrue(ses.checkExistStudent("S101312"));
        assertFalse(ses.checkExistStudent("COSC4030"));
    }
    
}
