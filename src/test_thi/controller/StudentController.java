package test_thi.controller;

import test_thi.entity.Student;
import test_thi.service.IStudentService;
import test_thi.service.StudentService;
import test_thi.view.StudentView;

import java.util.List;

public class StudentController {
    private StudentView studentView = new StudentView();
    private IStudentService studentService = new StudentService();
    public void displayMenu() {
        studentView.displayMenu();
        int choice = 1;
        switch (choice) {
            case 1:
                Student student = studentView.addStudent();
                if (studentService.add(student)) {
                    System.out.println("Student added");
                } else  {
                    System.out.println("Student not added");
                }
            case 2:
                List<Student> students = studentService.findAll();
                studentView.displayAllStudents(students);
        }
    }
}
