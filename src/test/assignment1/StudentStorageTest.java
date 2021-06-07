package test.assignment1; 

import assignment1.Address;
import assignment1.Course;
import assignment1.Student;
import assignment1.StudentStorage;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;

/** 
* StudentStorage Tester. 
* 
* @author <Authors name> 
* @since <pre>4月 28, 2021</pre> 
* @version 1.0 
*/ 
public class StudentStorageTest {
    Course c1 = new Course("159272","PP");
    Course c2 = new Course("159000", "whatever");
    Address a1 = new Address("TJ", "GRR", "100000", 8);
    Address a2 = new Address("BJ", "CAR", "100001", 1);
    Student s1 = new Student("Doe", "John", "00000001", LocalDate.of(2000, 1, 1), c1, a1);
    Student s2 = new Student("notDoe", "notJohn", "00000002", LocalDate.of(2000, 1, 2), c2, a2);

@Before
public void before() throws Exception {
    java.util.Collection<Student> students = new java.util.ArrayList<Student>();
    students.add(s1);
    students.add(s2);
    StudentStorage.save(students, "test_student.txt");
}

@After
public void after() throws Exception {
    File file = new File("test_student.txt");
    if (file.isFile()) {
        file.delete();
    }
}

@Test
public void testSaveAndLoad() throws Exception {
    java.util.Collection<Student> students = new java.util.ArrayList<Student>();
    students.add(s1);
    students.add(s2);
    java.util.Collection<Student> a = StudentStorage.load(new java.io.File("test_student.txt"));
    assertEquals(a, students);
} 
}