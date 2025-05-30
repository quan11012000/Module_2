package ss17_banary_file.bai_tap.product_management.service;

import java.util.List;

public interface Iservice<T> {
    void add(T t) throws ClassNotFoundException;
    List<T> getAll() throws ClassNotFoundException;
    List<T> displayProducts();
    T finByCode(int code) throws ClassNotFoundException;
}
