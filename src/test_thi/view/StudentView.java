package test_thi.view;
import test_thi.entity.Student;
import test_thi.util.InputHelper;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    public void displayMenu(){
        System.out.println("1. Them hoc sinh");
        System.out.println("2. Hien thi danh sach hoc sinh");
        System.out.println("3. Sua hoc sinh");
        System.out.println("4. Xoa hoc sinh");
        System.out.println("5. Tim kiem hoc sinh");
        System.out.println("6. Thoat");
    }
    public Student addStudent(){
        int id = InputHelper.inputInt("Nhap id: ",1,10);
        String name = InputHelper.inputString("Nhap name: ",15,50);
        int age = InputHelper.inputInt("Nhap age: ",5,30);
        String address = InputHelper.inputString("Nhap address: ",5,100);
        String email = InputHelper.inputString("Nhap email: ",15,50);
        String phone = InputHelper.inputPhone("Nhap phone: ","10");
        String className = InputHelper.inputString("Nhap class: ",4,6);
        return new Student(id, name, age, address, email, phone, className);
    }
    public void displayAllStudents(List<Student> students) {
        System.out.println("ID | NAME | AGE | ADDRESS | EMAIL | PHONE | CLASSNAME");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void updateStudent(Student student){}
    public void deleteStudent(Student student){}

}
