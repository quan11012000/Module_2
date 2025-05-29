package ss4_Oop.thuc_hanh.student.view;
import ss4_Oop.thuc_hanh.student.model.Student;
import ss4_Oop.thuc_hanh.student.service.IStudentService;
import java.util.List;
import java.util.Scanner;
public class StudentView {
    private final Scanner scanner = new Scanner(System.in);
    private final IStudentService studentService;

    public StudentView(IStudentService studentService) {
        this.studentService = studentService;
    }

    public void displayMenu() {
        System.out.println("------ QUẢN LÝ SINH VIÊN ------");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm sinh viên mới");
        System.out.println("3. Xóa sinh viên theo ID");
        System.out.println("4. Hiển thị danh sách sắp xếp (theo tên, trùng tên thì ID)");
        System.out.println("5. Hiển thị danh sách tim kiem sinh vien (theo tên)");
        System.out.println("0. Thoát");
    }

    public int inputChoice() {
        System.out.print("Chọn chức năng: ");
        String line = scanner.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int inputId(boolean checkExist, String action) {
        int id;
        while (true) {
            System.out.printf("Nhập ID sinh viên %s: ", action);
            String idStr = scanner.nextLine().trim();
            try {
                id = Integer.parseInt(idStr);
                if (id <= 0) {
                    System.out.println("ID phải là số nguyên dương!");
                } else if (checkExist && studentService.isIdExist(id)) {
                    System.out.println("ID đã tồn tại. Vui lòng nhập ID khác!");
                } else if (!checkExist && !studentService.isIdExist(id)) {
                    System.out.println("Không tìm thấy sinh viên với ID này.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID phải là số!");
            }
        }
        return id;
    }

    public Student inputStudent() {
        int id = inputId(true, "(không trùng)");
        String name;
        while (true) {
            System.out.print("Nhập tên: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên không được để trống!");
            } else {
                break;
            }
        }
        String className;
        while (true) {
            System.out.print("Nhập lớp: ");
            className = scanner.nextLine().trim();
            if (className.isEmpty()) {
                System.out.println("Lớp không được để trống!");
            } else {
                break;
            }
        }
        return new Student(id, name, className);
    }
    public void displayStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("---- DANH SÁCH SINH VIÊN ----");
            for (Student s : students) {
                System.out.println("ID: " + s.getId() +
                        " | Tên: " + s.getName() +
                        " | Lớp: " + s.getClassName());
            }
            System.out.println("-----------------------------");
        }
    }
    public String seachStudentByName(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
    public void showMessage(String message) {
        System.out.println(message);
    }

    public Boolean selectSortType() {
        System.out.println("1. Chọn sắp xếp tăng dần");
        System.out.println("2. Chọn sắp xếp giảm dần");
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.print("Lua chon cua ban: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice==1){
                    return true;
                }else if(choice==2){
                    return false;
                }else {
                    System.out.println("Ban phai nhap so trong menu");
                }
            }catch (NumberFormatException e){
                System.out.println("Ban phai nhap so trong menu");
            }

        }


    }
}
