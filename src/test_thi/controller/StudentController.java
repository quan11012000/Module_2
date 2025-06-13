package test_thi.controller;

import test_thi.entity.Student;
import test_thi.service.IStudentService;
import test_thi.service.StudentService;
import test_thi.view.CommonView;
import test_thi.view.StudentView;

import java.util.List;

public class StudentController {
    private IStudentService studentService;
    private StudentView studentView;

    public StudentController() {
        this.studentService = new StudentService();
        this.studentView = new StudentView();
    }

    public void showStudentMenu() {
        boolean isRunning = true;

        while (isRunning) {
            studentView.displayMenu();
            int choice = studentView.sc.nextInt();
            studentView.sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    CommonView.showMessage("Thoat quan ly hoc sinh...");
                    isRunning = false;
                    break;
                default:
                    CommonView.showError("Lua chon khong hop le! Vui long chon lai.");
            }

            if (isRunning && choice != 6) {
                CommonView.pause();
            }
        }
    }

    private void addStudent() {
        List<Student> students = studentService.findAll();
        Student newStudent = studentView.addStudent(students);
        boolean result = studentService.add(newStudent);
        if (result) {
            CommonView.showSuccess("Them hoc sinh thanh cong!");
        } else {
            CommonView.showError("Them hoc sinh that bai! Co loi xay ra");
        }
    }

    private void displayAllStudents() {
        try {
            List<Student> students = studentService.findAll();
            studentView.displayAllStudents(students);
        } catch (Exception e) {
            CommonView.showError("Co loi xay ra khi hien thi danh sach: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            int id = studentView.getUpdateId();
            Student existingStudent = studentService.findById(id);

            if (existingStudent == null) {
                CommonView.showError("Khong tim thay hoc sinh voi ID: " + id);
                return;
            }

            Student updatedStudent = studentView.updateStudent(existingStudent);
            if (updatedStudent != null) {
                boolean result = studentService.update(updatedStudent);
                if (result) {
                    CommonView.showSuccess("Cap nhat thong tin hoc sinh thanh cong!");
                } else {
                    CommonView.showError("Cap nhat thong tin hoc sinh that bai!");
                }
            }
        } catch (Exception e) {
            CommonView.showError("Co loi xay ra khi cap nhat hoc sinh: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            int id = studentView.getDeleteId();
            Student student = studentService.findById(id);

            if (student == null) {
                CommonView.showError("Khong tim thay hoc sinh voi ID: " + id);
                return;
            }

            boolean confirmed = studentView.confirmDelete(student);
            if (confirmed) {
                boolean result = studentService.delete(id);
                if (result) {
                    CommonView.showSuccess("Xoa hoc sinh thanh cong!");
                } else {
                    CommonView.showError("Xoa hoc sinh that bai!");
                }
            } else {
                CommonView.showMessage("Da huy thao tac xoa.");
            }
        } catch (Exception e) {
            CommonView.showError("Co loi xay ra khi xoa hoc sinh: " + e.getMessage());
        }
    }

    private void searchStudent() {
        int choice = studentView.selectSearchType();
        switch (choice) {
            case 1:
                int id = studentView.getSearchId();
                Student student = studentService.findById(id);
                studentView.displaySearchResult(student);
                break;
            case 2:
                String name = studentView.getSearchName();
                List<Student> foundStudents = studentService.findByName(name);
                if (foundStudents.isEmpty()) {
                    System.out.println("Không tìm thấy học sinh có tên " + name);
                } else {
                    System.out.println("Tìm thấy " + foundStudents.size() + " học sinh có tên " + name);
                    studentView.displayAllStudents(foundStudents);
                }
                break;
        }
    }
}

