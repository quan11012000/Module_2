package ss4_Oop.thuc_hanh.student;

import common.ValidateInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(StudentService.createStudent(students));
        StudentService.displayStudent(students);
        students.add(StudentService.createStudent(students));
        StudentService.displayStudent(students);
    }
}


