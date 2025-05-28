package ss4_Oop.thuc_hanh.student.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    void add(T t);
    void remove(int id);
    T findById(int id);
    boolean isIdExist(int id);
}
