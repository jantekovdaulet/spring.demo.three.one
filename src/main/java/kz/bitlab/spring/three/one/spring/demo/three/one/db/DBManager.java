package kz.bitlab.spring.three.one.spring.demo.three.one.db;

import kz.bitlab.spring.three.one.spring.demo.three.one.models.Student;

import java.util.ArrayList;

public class DBManager {

    static ArrayList<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1L, "Daulet", "Zhantekov", 100, "A"));
        students.add(new Student(2L, "Daulet1", "Zhantekov1", 80, "B"));
        students.add(new Student(3L, "Daulet2", "Zhantekov2", 77, "B"));
        students.add(new Student(4L, "Daulet3", "Zhantekov3", 50, "D"));
        students.add(new Student(5L, "Daulet4", "Zhantekov4", 40, "F"));
    }

    static Long id = 6L;

    public static ArrayList<Student> getAllStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }
}
