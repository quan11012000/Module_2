package ss17_banary_file.bai_tap.product_management.repository;

import java.util.List;

public interface Irepository<T> {
    void add(T t) throws ClassNotFoundException;
    List<T> getAll() throws ClassNotFoundException;
    List<T> displayProducts();
    T findByCode(String code) throws ClassNotFoundException;

}
