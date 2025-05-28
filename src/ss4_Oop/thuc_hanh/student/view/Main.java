package ss4_Oop.thuc_hanh.student.view;

import ss4_Oop.thuc_hanh.student.controller.StudentController;
import ss4_Oop.thuc_hanh.student.service.IStudentService;
import ss4_Oop.thuc_hanh.student.service.StudentService;

public class Main {
    public static void main(String[] args) {
        IStudentService studentService = new StudentService();
        StudentView studentView = new StudentView(studentService);
        StudentController studentController = new StudentController(studentService, studentView);
        studentController.run();
    }
}
