package test.assignment1; 

import assignment1.Address;
import assignment1.Course;
import assignment1.Student;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.time.LocalDate;

/** 
* Student Tester. 
* 
* @author <Authors name> 
* @since <pre>4月 28, 2021</pre> 
* @version 1.0 
*/ 
public class TestCloningStudents {
    Course c1 = new Course("159272","PP");
    Address a1= new Address("TJ", "GRR", "100000", 8);
    Student s1 = new Student("Doe", "John", "00000001", LocalDate.of(2000, 1, 1), c1, a1);
    Student s2;
@Before
public void before() throws Exception {
    s2 = (Student)s1.clone();
    s2.setSurname("notDoe");
    s2.setFirst_name("notJohn");
    s2.setId("00000002");
    s2.setDob(LocalDate.of(2000, 1, 2));
    Course c2 = s2.getCourse();
    Address a2 = s2.getAddress();
    c2.setNumber("159000");
    c2.setName("whatever");
    a2.setTown("BJ");
    a2.setStreet("CAR");
    a2.setPost_code("100001");
    a2.setHouse_number(1);
}

@After
public void after() throws Exception { 
}

@Test
public void testSurname1() throws Exception {
    assertEquals(s1.getSurname(), "Doe");
}

@Test
public void testSurname2() throws Exception {
    assertEquals(s2.getSurname(), "notDoe");
}

@Test
public void testfname1() throws Exception {
    assertEquals(s1.getFirst_name(), "John");
}

@Test
public void testfname2() throws Exception {
    assertEquals(s2.getFirst_name(), "notJohn");
}

@Test
public void testId1() throws Exception {
    assertEquals(s1.getId(), "00000001");
}

@Test
public void testId2() throws Exception {
    assertEquals(s2.getId(), "00000002");
}

@Test
public void testDob1() throws Exception {
    assertEquals(s1.getDob(), LocalDate.of(2000, 1, 1));
}

@Test
public void testDob2() throws Exception {
    assertEquals(s2.getDob(), LocalDate.of(2000, 1, 2));
}

@Test
public void testCourse1() throws Exception {
    assertEquals(s1.getCourse(), new Course("159000", "whatever"));
}

@Test
public void testCourse2() throws Exception {
    assertEquals(s2.getCourse(), new Course("159000", "whatever"));
}

@Test
public void testAddress1() throws Exception {
    assertEquals(s1.getAddress(), new Address("TJ", "GRR", "100000", 8));
}

@Test
public void testAddress2() throws Exception {
    assertEquals(s2.getAddress(), new Address("BJ", "CAR", "100001", 1));
}

} 
