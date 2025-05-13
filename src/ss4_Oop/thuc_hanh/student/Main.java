package ss4_Oop.thuc_hanh.student;
import common.ValidateInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Student student =creatStudent();
        students.add(student);
        displayStudent(students);
        Student student1 =creatStudent();
        students.add(student1);
        displayStudent(students);
    }
    public static void displayStudent(ArrayList<Student> students) {
        System.out.printf("| %-10s | %-20s | %-15s | %-12s | %-20s | %-10s |\n",
                "Code", "Name", "Phone", "DOB", "Address", "Gender");
        System.out.println("----------------------------------------------------------------------------------------");
        for(int i = 0 ;i<students.size();i++){
            System.out.println(students.get(i).toString());
        }

    }
    public static Student creatStudent(){
        Scanner sc = new Scanner(System.in);
        String code;
        String name;
        String phone;
        String dob;
        String address;
        int gender;
        LocalDate temp;
        Boolean genderResult;
        do{
            System.out.println("Nhap code ");
            code = sc.nextLine();
            if(code.length()>5){
                System.out.println("Ban can nhap do dai nho hon bang 5");
            }
            if(ValidateInput.isPositiveInteger(code)==false){
                System.out.println("Ban can nhap la so nguyen lon 0 và dam bao la so nguyen");
            }
            if(ValidateInput.isCodeExists(code,students)==true){
                System.out.println("code ton tai");
            }
        }while ( code.length()>5 || ValidateInput.isPositiveInteger(code)==false
                ||ValidateInput.isCodeExists(code,students)==true);

        do{
            System.out.print("Nhap ten: ");
            name = sc.nextLine();
            if(ValidateInput.isVietnameseLettersAndSpaces(name)==false){
                System.out.println("Ban phai nhap ten dung voi dinh dang");
            }
            if(name.length()>50){
                System.out.println("Ban phai nhap ten co do dai nho hon 50 ki tu");
            }
        }while (ValidateInput.isVietnameseLettersAndSpaces(name)==false || name.length()>50);

        do{
            System.out.print("Nhap so dien thoai: ");
            phone = sc.nextLine();
            if(ValidateInput.isValidPhoneNumber(phone)==false){
                System.out.println("Ban can nhap la so nguyen lon 0");
            }
        }while (ValidateInput.isValidPhoneNumber(phone)==false);

        do{
            System.out.print("Nhap ngay sinh: ");
             dob = sc.nextLine();
            if(ValidateInput.isValidBirthday(dob)==false){
                System.out.println("Ban phai nhap ngay sinh dung dinh dang");
            }
        }while (ValidateInput.isValidBirthday(dob)==false);

        do{
            System.out.print("Nhap dia chi: ");
            address = sc.nextLine();
            if(address.length()>200){
                System.out.println("dia chi qua dai");
            }
            if(address.length()<5){
                System.out.println("dia chi qua ngan");
            }
        }while (address.length()>200||address.length()<5);

        do{
            System.out.println("Enter student gender: ");
            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            System.out.println("3. Khác");
            gender = sc.nextLine().charAt(0) - '0';
            if (gender == 1) {
                genderResult = false;
            } else if (gender == 2) {
                genderResult = true;
            } else {
                genderResult = null;
            }
            if(gender<1 || gender>3){
                System.out.println("nhap 1 trong 3 gioi tinh");
            }
        }while (gender<1 || gender>3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Student(Long.parseLong(code),name,phone,
                LocalDate.parse(dob,formatter),address,genderResult);
    }
}
