package test_thi.view;
import test_thi.entity.Student;
import test_thi.util.InputHelper;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentView {
    public Scanner sc = new Scanner(System.in);
    public void displayMenu(){
        System.out.println("1. Them hoc sinh");
        System.out.println("2. Hien thi danh sach hoc sinh");
        System.out.println("3. Sua hoc sinh");
        System.out.println("4. Xoa hoc sinh");
        System.out.println("5. Tim kiem hoc sinh");
        System.out.println("6. Thoat");
    }
    public Student addStudent(List<Student> students){
        List<Integer> existingIds = students.stream().map(Student::getId).toList();
        int id = InputHelper.inputInt("Nhap id ",1,10);
        while (existingIds.contains(id)){
            System.out.println("Id da ton tai");
            id = InputHelper.inputInt("Nhap id ",1,10);
        }
        String name = InputHelper.inputName("Nhap name ");
        int age = InputHelper.inputInt("Nhap age ",5,30);
        String address = InputHelper.inputString("Nhap address ",5,100);
        String email = InputHelper.inputEmail("Nhap email ");
        String phone = InputHelper.inputPhone("Nhap phone ","10");
        String className = InputHelper.inputString("Nhap class ",2,4);
        return new Student(id, name, age, address, email, phone, className);
    }
    public void displayAllStudents(List<Student> students) {
        if (students.isEmpty()){
            System.out.println("Khong co hoc sinh nao");
            return;
        }
        System.out.println("\n========== DANH SACH HOC SINH ==========");
        System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "LOP"));
        System.out.println("|-------|----------------------|-----|----------------------|---------------------------|--------------|------------|");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("=========================================");
        System.out.println("Tong so hoc sinh: " + students.size());
    }
    public Student updateStudent(Student existingStudent){
        if (existingStudent == null) {
            System.out.println("Khong tim thay hoc sinh!");
            return null;
        }
        System.out.println("\n========== SUA THONG TIN HOC SINH ==========");
        System.out.println("Thong tin hien tai:");
        System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "LOP"));
        System.out.println(existingStudent);
        System.out.println("\nNhap thong tin moi (Enter de giu nguyen):");
        int id = existingStudent.getId();
        String name = InputHelper.inputName("Nhap ten moi");
        int age = InputHelper.inputInt("Nhap tuoi moi", existingStudent.getAge(), 5, 100);
        String address = InputHelper.inputString("Nhap dia chi moi", existingStudent.getAddress(), 5, 100);
        String email = InputHelper.inputEmail("Nhap email moi", existingStudent.getEmail());
        String phone = InputHelper.inputPhone("Nhap so dien thoai moi", existingStudent.getPhone());
        String className = InputHelper.inputString("Nhap lop moi", existingStudent.getClassName(), 2, 20);
        return new Student(id,name,age,address,email,phone,className);
    }
    public boolean confirmDelete(Student student){
        if (student == null) {
            System.out.println("Khong tim thay hoc sinh!");
            return false;
        }
            System.out.println("\n========== XOA HOC SINH ==========");
            System.out.println("Thong tin hoc sinh se bi xoa:");
            System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                    "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "LOP"));
            System.out.println(student);
            System.out.print("Ban co chac chan muon xoa hoc sinh nay? (y/n): ");
            String confirm = sc.nextLine().trim().toLowerCase();
            return confirm.equals("y") || confirm.equals("yes");
    }
    public String getSearchName(){
        System.out.println("\n========== TIM KIEM HOC SINH ==========");
        return InputHelper.inputString("Nhap ten hoc sinh can tim", 1,50);
    }
    public int getSearchId() {
        System.out.println("\n========== TIM KIEM HOC SINH ==========");
        return InputHelper.inputInt("Nhap ID hoc sinh can tim", 1, Integer.MAX_VALUE);
    }
    public void displaySearchResult(Student student) {
        if (student == null) {
            System.out.println("Khong tim thay hoc sinh voi ID da nhap!");
        } else {
            System.out.println("\n========== KET QUA TIM KIEM ==========");
            System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                    "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "LOP"));
            System.out.println("|-------|----------------------|-----|----------------------|---------------------------|--------------|------------|");
            System.out.println(student);
            System.out.println("=====================================");
        }
    }
    public int getUpdateId() {
        System.out.println("\n========== SUA HOC SINH ==========");
        return InputHelper.inputInt("Nhap ID hoc sinh can sua", 1, Integer.MAX_VALUE);
    }

    public int getDeleteId() {
        System.out.println("\n========== XOA HOC SINH ==========");
        return InputHelper.inputInt("Nhap ID hoc sinh can xoa", 1, Integer.MAX_VALUE);
    }



    public int selectSearchType() {
        System.out.println("1. Tìm kiếm theo id ");
        System.out.println("2. Tim kiếm theo tên ");
        int choice;
        while (true) {
            try {
                System.out.print("Lua chon cua ban: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Vui long nhap 1 so nguyen tuong ung menu");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap 1 so nguyen tuong ung menu");
            }
        }
    }


}
