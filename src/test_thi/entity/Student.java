package test_thi.entity;

public class Student extends Person {
    private String className;

    public Student(int id, String name, int age, String address, String email, String phone, String className) {
        super(id, name, age, address, email, phone);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public String toString() {
        return String.format(
                "| %-5d | %-20s | %-3d | %-20s | %-25s | %-12s | %-10s |",
                getId(), getName(), getAge(), getAddress(), getEmail(), getPhone(),className
        );
    }
    @Override
    public String toCsvLine(){
        return String.join(",",String.valueOf(getId()), getName(), String.valueOf(getAge()), getAddress(), getEmail(), getPhone(),className);
    }
}
