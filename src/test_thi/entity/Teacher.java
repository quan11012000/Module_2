package test_thi.entity;

public class Teacher extends Person {
    private String specialization;

    public Teacher(int id, String name, int age, String address, String email, String phone, String specialization) {
        super(id, name, age, address, email, phone);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-5d | %-20s | %-3d | %-20s | %-25s | %-12s | %-10s |",
                getId(), getName(), getAge(), getAddress(), getEmail(), getPhone(),specialization
        );
    }

    @Override
    public String toCsvLine() {
        return String.join(",",String.valueOf(getId()), getName(), String.valueOf(getAge()), getAddress(), getEmail(), getPhone(),specialization);
    }
}
