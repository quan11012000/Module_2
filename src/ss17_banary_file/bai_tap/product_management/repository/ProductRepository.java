package ss17_banary_file.bai_tap.product_management.repository;

import ss17_banary_file.bai_tap.product_management.modle.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static final String FILE_PATH = "products.dat";
    @Override
    public void add(Product product) throws ClassNotFoundException {
        List<Product> list =  getAll();
        list.add(product);
        writeFile(list);
    }

    private void writeFile(List<Product> list) {
    }

    @Override
    public List<Product> getAll()  {
        File file = new File(FILE_PATH);
        if(!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (List<Product>) ois.readObject();

        }catch (IOException e){
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> displayProducts() {
        return null;
    }

    @Override
    public Product finByCode(int code)  {
        for(Product p:getAll()){
            if(p.getCode()==(code)) return p;
        }
        return null;
    }
    private void writerFile(List<Product> list){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> seachByName(String name) {
        List<Product> seachList = new ArrayList<>();
        for (Product p : getAll()){
            if(p.getName().contains(name)){
                seachList.add(p);
            }
        }
        return seachList;
    }
}
