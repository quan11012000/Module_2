package test_thi.entity;

public class Person {
    private int id;
    private String name;
    private int age;
    private String address;
    private String email;
    private String phone;

    public Person(int id, String name, int age, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return String.format(
                "| %-15s | %-20s | %-10s | %-12.0f | %-12s | %-15s | %-4s | %-50s |",
                id, name, age, address, email, phone
        );
    }
    public String toCsvLine(){
        return String.join(",",String.valueOf(id), name, String.valueOf(age), address, email, phone);
    }
}
