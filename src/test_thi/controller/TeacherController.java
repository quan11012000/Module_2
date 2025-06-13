package test_thi.controller;
import test_thi.entity.Teacher;
import test_thi.service.ITeacherService;
import test_thi.service.TeacherService;
import test_thi.view.TeacherView;
import java.util.List;

public class TeacherController {
    private ITeacherService teacherService;
    private TeacherView teacherView;

    public TeacherController() {
        this.teacherService = new TeacherService();
        this.teacherView = new TeacherView();
    }

    public void showTeacherMenu() {
        boolean isRunning = true;

        while (isRunning) {
            teacherView.displayMenu();
            int choice = teacherView.sc.nextInt();
            teacherView.sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    displayAllTeachers();
                    break;
                case 3:
                    updateTeacher();
                    break;
                case 4:
                    deleteTeacher();
                    break;
                case 5:
                    searchTeacher();
                    break;
                case 6:
                    teacherView.showMessage("Thoat quan ly giao vien...");
                    isRunning = false;
                    break;
                default:
                    teacherView.showError("Lua chon khong hop le! Vui long chon lai.");
            }

            if (isRunning && choice != 6) {
                teacherView.pause();
            }
        }
    }

    private void addTeacher () {
        List<Teacher> teachers = teacherService.findAll();
        Teacher newTeacher = teacherView.addTeacher(teachers);
        boolean result = teacherService.add(newTeacher);
        if (result) {
            teacherView.showSuccess("Them giao vien thanh cong!");
        } else {
            teacherView.showError("Them giao vien that bai! Co loi xay ra");
        }
    }

    private void displayAllTeachers() {
        try {
            List<Teacher> teachers = teacherService.findAll();
            teacherView.displayAllTeacher(teachers);
        } catch (Exception e) {
            teacherView.showError("Co loi xay ra khi hien thi danh sach: " + e.getMessage());
        }
    }

    private void updateTeacher() {
        try {
            int id = teacherView.getUpdateId();
            Teacher existingTeacher = teacherService.findById(id);

            if (existingTeacher == null) {
                teacherView.showError("Khong tim thay giao vien voi ID: " + id);
                return;
            }

            Teacher updateTeacher = teacherView.updateTeacher(existingTeacher);
            if (updateTeacher != null) {
                boolean result = teacherService.update(updateTeacher);
                if (result) {
                    teacherView.showSuccess("Cap nhat thong tin giao vien thanh cong!");
                } else {
                    teacherView.showError("Cap nhat thong tin giao vien that bai!");
                }
            }
        } catch (Exception e) {
            teacherView.showError("Co loi xay ra khi cap nhat hoc sinh: " + e.getMessage());
        }
    }

    private void deleteTeacher() {
        try {
            int id = teacherView.getDeleteId();
            Teacher teacher = teacherService.findById(id);

            if (teacher == null) {
                teacherView.showError("Khong tim thay giao vien voi ID: " + id);
                return;
            }

            boolean confirmed = teacherView.confirmDelete(teacher);
            if (confirmed) {
                boolean result = teacherService.delete(id);
                if (result) {
                    teacherView.showSuccess("Xoa giao vien thanh cong!");
                } else {
                    teacherView.showError("Xoa giao vien that bai!");
                }
            } else {
                teacherView.showMessage("Da huy thao tac xoa.");
            }
        } catch (Exception e) {
            teacherView.showError("Co loi xay ra khi xoa giao vien: " + e.getMessage());
        }
    }

    private void searchTeacher() {
        int choice = teacherView.selectSearchType();
        switch (choice) {
            case 1:
                int id = teacherView.getSearchId();
                Teacher teacher = teacherService.findById(id);
                teacherView.displaySearchResult(teacher);
                break;
            case 2:
                String name = teacherView.getSearchName();
                List<Teacher> foundTeachers = teacherService.findByName(name);
                if (foundTeachers.isEmpty()) {
                    System.out.println("Không tìm thấy học sinh có tên " + name);
                } else {
                    System.out.println("Tìm thấy " + foundTeachers.size() + " học sinh có tên " + name);
                    teacherView.displayAllTeacher(foundTeachers);
                }
                break;
        }
    }
}
