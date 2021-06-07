package assignment1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;

public class StudentListEditor {
    private JButton exitButton;
    private JButton loadButton;
    private JButton saveButton;
    private JButton addButton;
    private JButton cloneButton;
    private JButton saveEditButton;
    private JButton deleteButton;
    private JList<Object> list1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JPanel mainpanel;
    private JToolBar toolbar;
    private JPanel panel1;
    private JScrollPane spanel;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    java.util.Collection<Student> students = new java.util.ArrayList<Student>();;

    public StudentListEditor() {
        // Load
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    students = StudentStorage.load(new java.io.File("StudentList.txt"));
                    list1.setListData(students.toArray());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });
        //Save
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StudentStorage.save(students, "StudentList.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //Add
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = textField1.getText();
                String sname = textField2.getText();
                String id = textField3.getText();
                LocalDate dob = LocalDate.of(comboBox1.getSelectedIndex()+1, comboBox2.getSelectedIndex()+1, comboBox3.getSelectedIndex()+1);
                Course course = new Course(textField7.getText(), textField8.getText());
                int num = 0;
                try {
                    num = Integer.parseInt(textField9.getText());
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
                Address address = new Address(textField4.getText(), textField5.getText(), textField6.getText(), num);
                Student student = new Student(sname, fname, id, dob, course, address);
                students.add(student);
                list1.setListData(students.toArray());
            }
        });
        //Clone
        cloneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = (Student) list1.getSelectedValue();
                try {
                    Student clone_stu = (Student) student.clone();
                    students.add(clone_stu);
                    list1.setListData(students.toArray());
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }

            }
        });
        //Delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = (Student) list1.getSelectedValue();
                students.remove(student);
                list1.setListData(students.toArray());
            }
        });
        //click on list item
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Student student = (Student) list1.getSelectedValue();
                textField1.setText(student.getFirst_name());
                textField2.setText(student.getSurname());
                textField3.setText(student.getId());
                comboBox1.setSelectedIndex(student.getDob().getYear()-1);
                comboBox2.setSelectedIndex(student.getDob().getMonthValue()-1);
                comboBox3.setSelectedIndex(student.getDob().getDayOfMonth()-1);
                textField4.setText(student.getAddress().getTown());
                textField5.setText(student.getAddress().getStreet());
                textField6.setText(student.getAddress().getPost_code());
                textField9.setText(""+student.getAddress().getHouse_number());
                textField7.setText(student.getCourse().getNumber());
                textField8.setText(student.getCourse().getName());
            }
        });
        //save edit
        saveEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = (Student) list1.getSelectedValue();
                students.remove(student);
                String fname = textField1.getText();
                String sname = textField2.getText();
                String id = textField3.getText();
                LocalDate dob = LocalDate.of(comboBox1.getSelectedIndex()+1, comboBox2.getSelectedIndex()+1, comboBox3.getSelectedIndex()+1);
                Course course = new Course(textField7.getText(), textField8.getText());
                int num = 0;
                try {
                    num = Integer.parseInt(textField9.getText());
                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                }
                Address address = new Address(textField4.getText(), textField5.getText(), textField6.getText(), num);
                Student new_student = new Student(sname, fname, id, dob, course, address);
                students.add(new_student);
                list1.setListData(students.toArray());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student List Editor");
        frame.setContentPane(new StudentListEditor().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
