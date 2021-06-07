package assignment1;

import java.io.*;
import java.util.Collection;

public class StudentStorage {
    private static void save(java.util.Collection<Student> students, java.io.File file) throws IOException {
        ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file));
        objectOut.writeObject(students);
        objectOut.close();
    }

    public static void save(java.util.Collection<Student> students, String fileName) throws IOException {
        File file = new File(fileName);
        save(students, file);
    }
    public static java.util.Collection<Student> load(java.io.File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(file));
        java.util.Collection<Student> students;
        students = (Collection<Student>) objectIn.readObject();
        return students;
    }
}
