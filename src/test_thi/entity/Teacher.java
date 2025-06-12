package test_thi.entity;

public class Teacher extends Person {
    private String specialization;

    public Teacher(int id, String name, int age, String address, String email, String phone, String specialization) {
        super(id, name, age, address, email, phone);
        this.specialization = specialization;
    }
}
