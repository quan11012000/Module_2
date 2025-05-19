package phone.controller;
import common.ValidateInput;
import phone.model.HashTable;
import phone.view.PhoneBookView;
import phone.controller.PhoneBookController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashTable model = new HashTable();
        PhoneBookView view = new PhoneBookView();
        PhoneBookController controller = new PhoneBookController(model, view);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ DANH BẠ ---");
            System.out.println("1. Thêm số điện thoại");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Xóa số điện thoại");
            System.out.println("4. Hiển thị tất cả danh bạ");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            String phone;
            String nameAdd;
            switch (choice) {
                case 1:
                    do{
                        System.out.print("Nhập tên: ");
                         nameAdd= scanner.nextLine();
                        if(!ValidateInput.isVietnameseLettersAndSpaces(nameAdd)){
                            System.out.println("nhap sai dinh ten");
                        }
                        if(ValidateInput.isCodeExists(nameAdd,)){
                            System.out.println("ten da ton tai");
                        }
                    }while (!ValidateInput.isVietnameseLettersAndSpaces(nameAdd));

                    do{
                        System.out.print("Nhập số điện thoại: ");
                         phone = scanner.nextLine();
                        if(!ValidateInput.isValidPhoneNumber(phone)){
                            System.out.println("nhap sai dinh dang phone");
                        }
                    }while (!ValidateInput.isValidPhoneNumber(phone));

                    controller.addContact(nameAdd, phone);
                    System.out.println("Đã thêm.");
                    break;

                case 2:
                    System.out.print("Nhập tên cần tìm: ");
                    String nameSearch = scanner.nextLine();
                    controller.searchContact(nameSearch);
                    break;

                case 3:
                    System.out.print("Nhập tên cần xóa: ");
                    String nameDelete = scanner.nextLine();
                    controller.deleteContact(nameDelete);
                    break;

                case 4:
                    System.out.println("--- DANH BẠ HIỆN TẠI ---");
                    controller.displayContacts();
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 0);

        scanner.close();
    }
}