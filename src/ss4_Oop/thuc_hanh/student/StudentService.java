package ss4_Oop.thuc_hanh.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import common.ValidateInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    public static Student createStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        String code, name, phone, dob, address;
        int gender;
        LocalDate temp;
        Boolean genderResult;

        // Nhập code
        do {
            System.out.println("Nhập code:");
            code = sc.nextLine();
            if (code.length() > 5)
                System.out.println("Code phải <= 5 ký tự.");
            if (!ValidateInput.isPositiveInteger(code))
                System.out.println("Code phải là số nguyên dương.");
            if (ValidateInput.isCodeExists(code, students))
                System.out.println("Code đã tồn tại.");
        } while (code.length() > 5 || !ValidateInput.isPositiveInteger(code)
                || ValidateInput.isCodeExists(code, students));

        // Nhập tên
        do {
            System.out.print("Nhập tên: ");
            name = sc.nextLine();
            if (!ValidateInput.isVietnameseLettersAndSpaces(name))
                System.out.println("Tên không hợp lệ.");
            if (name.length() > 50)
                System.out.println("Tên quá dài.");
        } while (!ValidateInput.isVietnameseLettersAndSpaces(name) || name.length() > 50);

        // Nhập số điện thoại
        do {
            System.out.print("Nhập số điện thoại: ");
            phone = sc.nextLine();
            if (!ValidateInput.isValidPhoneNumber(phone))
                System.out.println("Số điện thoại không hợp lệ.");
        } while (!ValidateInput.isValidPhoneNumber(phone));

        // Nhập ngày sinh
        do {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            dob = sc.nextLine();
            if (!ValidateInput.isValidBirthday(dob))
                System.out.println("Ngày sinh không đúng định dạng.");
        } while (!ValidateInput.isValidBirthday(dob));

        // Nhập địa chỉ
        do {
            System.out.print("Nhập địa chỉ: ");
            address = sc.nextLine();
            if (address.length() > 200)
                System.out.println("Địa chỉ quá dài.");
            if (address.length() < 5)
                System.out.println("Địa chỉ quá ngắn.");
        } while (address.length() > 200 || address.length() < 5);

        // Nhập giới tính
        do {
            System.out.println("Chọn giới tính:");
            System.out.println("1. Nam\n2. Nữ\n3. Khác");
            gender = sc.nextLine().charAt(0) - '0';
            if (gender == 1) genderResult = false;
            else if (gender == 2) genderResult = true;
            else genderResult = null;

            if (gender < 1 || gender > 3)
                System.out.println("Chọn 1, 2 hoặc 3.");
        } while (gender < 1 || gender > 3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Student(Long.parseLong(code), name, phone,
                LocalDate.parse(dob, formatter), address, genderResult);
    }

    public static void displayStudent(ArrayList<Student> students) {
        System.out.printf("| %-10s | %-20s | %-15s | %-12s | %-20s | %-10s |\n",
                "Code", "Name", "Phone", "DOB", "Address", "Gender");
        System.out.println("----------------------------------------------------------------------------------------");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }
}

