package ss4_Oop.thuc_hanh.student.service;

import ss4_Oop.thuc_hanh.student.model.Person;

public interface IService {
    public boolean add(Person person);
    public boolean edit(Person person);
    public boolean delete(int code);
    public void display();
}
