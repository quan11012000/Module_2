package test_thi.controller;

import test_thi.view.View;

public class Controller {
    private View mainView;
    private StudentController studentController;
    private TeacherController teacherController;
    public Controller() {
        this.mainView = new View();
        this.studentController = new StudentController();
        this.teacherController = new TeacherController();
    }

    public void run() {
        boolean isRunning = true;

        System.out.println("========== CHUONG TRINH QUAN LY ==========");

        while (isRunning) {
            mainView.displayMenu();
            System.out.print("Lua chon cua ban: ");
            int choice = mainView.sc.nextInt();
            mainView.sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    studentController.showStudentMenu();
                    break;
                case 2:
                    teacherController.showTeacherMenu();
                    break;
                case 3:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }
        }
    }
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
