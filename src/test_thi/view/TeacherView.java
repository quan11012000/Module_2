package test_thi.view;
import test_thi.entity.Student;
import test_thi.entity.Teacher;
import test_thi.util.InputHelper;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeacherView {
    public Scanner sc = new Scanner(System.in);
    public void displayMenu(){
        System.out.println("1. Them giao vien");
        System.out.println("2. Hien thi danh sach giao vien");
        System.out.println("3. Sua giao vien");
        System.out.println("4. Xoa giao vien");
        System.out.println("5. Tim kiem giao vien");
        System.out.println("6. Thoat");
    }
    public Teacher addTeacher(List<Teacher> teachers){
        List<Integer> existingIds = teachers.stream().map(Teacher::getId).toList();
        int id = InputHelper.inputInt("Nhap id: ",1,10);
        while (existingIds.contains(id)){
            System.out.println("Id da ton tai");
            id = InputHelper.inputInt("Nhap id: ",1,10);
        }
        String name = InputHelper.inputString("Nhap name: ",3,50);
        int age = InputHelper.inputInt("Nhap age: ",5,30);
        String address = InputHelper.inputString("Nhap address: ",5,100);
        String email = InputHelper.inputString("Nhap email: ",5,50);
        String phone = InputHelper.inputPhone("Nhap phone: ","10");
        String spec = InputHelper.inputString("Nhap chuyen nganh: ",2,4);
        return new Teacher(id, name, age, address, email, phone, spec);
    }
    public void displayAllTeacher(List<Teacher> teachers) {
        if (teachers.isEmpty()){
            System.out.println("Khong co giao vien nao");
            return;
        }
        System.out.println("\n========== DANH SACH GIAO VIEN ==========");
        System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "CHUYEN NGANH"));
        System.out.println("|-------|----------------------|-----|----------------------|---------------------------|--------------|------------|");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        System.out.println("=========================================");
        System.out.println("Tong so hoc sinh: " + teachers.size());
    }
    public Teacher updateTeacher(Teacher existingTeacher){
        if (existingTeacher == null) {
            System.out.println("Khong tim thay giao vien!");
            return null;
        }
        System.out.println("\n========== SUA THONG TIN GIAO VIEN ==========");
        System.out.println("Thong tin hien tai:");
        System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "CHUYEN NGANH"));
        System.out.println(existingTeacher);
        System.out.println("\nNhap thong tin moi (Enter de giu nguyen):");
        int id = existingTeacher.getId();
        String name = InputHelper.inputString("Nhap ten moi", existingTeacher.getName(), 2, 50);
        int age = InputHelper.inputInt("Nhap tuoi moi", existingTeacher.getAge(), 5, 100);
        String address = InputHelper.inputString("Nhap dia chi moi", existingTeacher.getAddress(), 5, 100);
        String email = InputHelper.inputEmail("Nhap email moi", existingTeacher.getEmail());
        String phone = InputHelper.inputPhone("Nhap so dien thoai moi", existingTeacher.getPhone());
        String spec = InputHelper.inputString("Nhap chuyen nganh ", existingTeacher.getSpecialization(), 2, 20);
        return new Teacher(id,name,age,address,email,phone,spec);
    }
    public boolean confirmDelete(Teacher teacher){
        if (teacher == null) {
            System.out.println("Khong tim thay giao vien!");
            return false;
        }
        System.out.println("\n========== XOA GIAO VIEN ==========");
        System.out.println("Thong tin giao vien se bi xoa:");
        System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "CHUYEN NGANH"));
        System.out.println(teacher);
        System.out.print("Ban co chac chan muon xoa giao vien nay? (y/n): ");
        String confirm = sc.nextLine().trim().toLowerCase();
        return confirm.equals("y") || confirm.equals("yes");
    }
    public String getSearchName(){
        System.out.println("\n========== TIM KIEM GIAO VIEN ==========");
        return InputHelper.inputString("Nhap ten giao vien can tim", 1,50);
    }
    public int getSearchId() {
        System.out.println("\n========== TIM KIEM GIAO VIEN ==========");
        return InputHelper.inputInt("Nhap ID giao vien can tim", 1, Integer.MAX_VALUE);
    }
    public void displaySearchResult(Teacher teacher) {
        if (teacher == null) {
            System.out.println("Khong tim thay giao vien voi ID da nhap!");
        } else {
            System.out.println("\n========== KET QUA TIM KIEM ==========");
            System.out.println(String.format("| %-5s | %-20s | %-3s | %-20s | %-25s | %-12s | %-10s |",
                    "ID", "TEN", "TUOI", "DIA CHI", "EMAIL", "DIEN THOAI", "CHUYEN NGANH"));
            System.out.println("|-------|----------------------|-----|----------------------|---------------------------|--------------|------------|");
            System.out.println(teacher);
            System.out.println("=====================================");
        }
    }
    public int getUpdateId() {
        System.out.println("\n========== SUA GIAO VIEN ==========");
        return InputHelper.inputInt("Nhap ID giao vien can sua", 1, Integer.MAX_VALUE);
    }

    public int getDeleteId() {
        System.out.println("\n========== XOA GIAO VIEN ==========");
        return InputHelper.inputInt("Nhap ID giao vien can xoa", 1, Integer.MAX_VALUE);
    }

    public void showMessage(String message) {
        System.out.println("\n" + message);
    }

    public void showError(String error) {
        System.out.println("\n[LOIX] " + error);
    }

    public void showSuccess(String success) {
        System.out.println("\n[THANH CONG] " + success);
    }

    public void pause() {
        System.out.print("\nNhan Enter de tiep tuc...");
        sc.nextLine();
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
