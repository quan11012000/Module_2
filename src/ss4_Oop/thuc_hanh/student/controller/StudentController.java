package ss4_Oop.thuc_hanh.student.controller;

import ss4_Oop.thuc_hanh.student.model.Student;
import ss4_Oop.thuc_hanh.student.service.IStudentService;
import ss4_Oop.thuc_hanh.student.view.StudentView;

import java.util.List;

public class StudentController {
    private final IStudentService studentService;
    private final StudentView studentView;

    public StudentController(IStudentService studentService, StudentView studentView) {
        this.studentService = studentService;
        this.studentView = studentView;
    }

    public void run() {
        while (true) {
            studentView.displayMenu();
            int choice = studentView.inputChoice();
            switch (choice) {
                case 1:
                    List<Student> students = studentService.findAll();
                    studentView.displayStudents(students);
                    break;
                case 2:
                    Student newStudent = studentView.inputStudent();
                    studentService.add(newStudent);
                    studentView.showMessage("Đã thêm sinh viên mới!");
                    break;
                case 3:
                    int idToRemove = studentView.inputId(false, "cần xóa");
                    studentService.remove(idToRemove);
                    studentView.showMessage("Đã xóa sinh viên có ID " + idToRemove);
                    break;
                case 4:
                    Boolean ascending = studentView.selectSortType();
                    List<Student> sorted = studentService.sortByNameThenId(ascending);
                    studentView.displayStudents(sorted);
                    break;
                case 5:
                    String keyword= studentView.seachStudentByName();
                    List<Student> seachList = studentService.seachByName(keyword);
                    if(!seachList.isEmpty()){
                        studentView.showMessage("Danh sách tìm kiếm theo tên "+ keyword);
                        studentView.displayStudents(seachList);
                    }else{
                        studentView.showMessage("Khong tim thay sinh vien nao ten co chua "+keyword);
                    }
                    break;
                case 0:
                    studentView.showMessage("Thoát chương trình.");
                    return;
                default:
                    studentView.showMessage("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }
}