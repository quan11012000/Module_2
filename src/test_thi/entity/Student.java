package test_thi.entity;

public class Student extends Person {
    private String className;

    public Student(int id, String name, int age, String address, String email, String phone, String className) {
        super(id, name, age, address, email, phone);
        this.className = className;
    }
}
