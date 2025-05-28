package ss4_Oop.thuc_hanh.student.service;

public interface IService {
    public boolean add(Person person);
    public boolean edit(Person person);
    public boolean delete(int code);
    public void display();
}
