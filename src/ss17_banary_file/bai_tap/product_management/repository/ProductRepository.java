package ss17_banary_file.bai_tap.product_management.repository;

import ss17_banary_file.bai_tap.product_management.modle.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String filePath;

    public ProductRepository() {
        this("products.dat");
    }

    public ProductRepository(String filePath) {
        this.filePath = filePath;
        System.out.println("File dữ liệu sẽ được lưu tại: " + new File(filePath).getAbsolutePath());
    }

    @Override
    public void add(Product product) throws ClassNotFoundException {
        List<Product> list = getAll();
        list.add(product);
        writeFile(list);
    }

    private void writeFile(List<Product> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() throws ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Product>) ois.readObject();
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Product> displayProducts() {
        try {
            return getAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Product findByCode(String code) throws ClassNotFoundException {
        for (Product p : getAll()) {
            if (p.getCode() != null && p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> seachByName(String name) throws ClassNotFoundException {
        List<Product> searchList = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getName() != null && p.getName().toLowerCase().contains(name.toLowerCase())) {
                searchList.add(p);
            }
        }
        return searchList;
    }
}
