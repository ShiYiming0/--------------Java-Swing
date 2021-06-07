package assignment1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Student implements Serializable, Cloneable{
    private String surname;
    private String first_name;
    private String id;
    private LocalDate dob;
    private Course course;
    private Address address;

    public Student(String surname, String first_name, String id, LocalDate dob, Course course, Address address) {
        this.surname = surname;
        this.first_name = first_name;
        this.id = id;
        this.dob = dob;
        this.course = course;
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(surname, student.surname) && Objects.equals(first_name, student.first_name) && Objects.equals(id, student.id) && Objects.equals(dob, student.dob) && Objects.equals(course, student.course) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, first_name, id, dob, course, address);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student s;
        s = (Student) super.clone();
        s.setAddress((Address) s.getAddress().clone());
        return s;
    }
}
