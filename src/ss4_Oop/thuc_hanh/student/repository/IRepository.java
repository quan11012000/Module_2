package ss4_Oop.thuc_hanh.student.repository;

import ss4_Oop.thuc_hanh.student.model.Student;

import java.util.List;

public interface IRepository<T>{
    List<T> findAll();
    void add(T t);
    void remove(int id);
    T findById(int id);
    boolean isIdExist(int id);
}
