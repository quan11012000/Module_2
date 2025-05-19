package ss4_Oop.thuc_hanh.student.controller;

import ss4_Oop.thuc_hanh.student.model.Student;
import ss4_Oop.thuc_hanh.student.view.StudentView;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(StudentView.createStudent(students));
        StudentView.displayStudent(students);
        students.add(StudentView.createStudent(students));
        StudentView.displayStudent(students);
    }
}


