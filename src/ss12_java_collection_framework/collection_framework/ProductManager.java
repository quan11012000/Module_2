package ss12_java_collection_framework.collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ProductManager {
    ArrayList<Product> products ;
    public ProductManager(){
        products = new ArrayList<>();
    }
    public void add(Product product){
        for(int i =0;i<products.size();i++){
            if(product.getId()==products.get(i).getId()){
                System.out.println("ID đã tồn tại !");
                return;
            }
        }
        products.add(product);
    }
    public void delete(int id){
        for(int i =0;i<products.size();i++){
            if(id==products.get(i).getId()){
                products.remove(i);
                System.out.println("Đã xoá thành công");
                return;
            }
        }
        System.out.println("không tim thấy id");
    }
    public void displayProducts(){
        for(int i =0;i<products.size();i++){
            System.out.println(i+" " +products.get(i));
        }
    }
    public void editProduct(Product product){
        for(int i =0;i<products.size();i++){
            if(product.getId()==products.get(i).getId()){
                products.set(i,product);
                System.out.println("Đã sửa thành công");
                return;
            }
        }
        System.out.println("không tìm thấy id");
    }
    public void displayFind(ArrayList<Product> products){
        if(products.size()>0){
            System.out.println("danh sach tim kiem theo ten là : ");
            for(int i=0;i<products.size();i++){
                System.out.println(products.get(i));
            }
        }else {
            System.out.println("khong tim thay san pham co keyword");
        }
    }
    public ArrayList<Product> searchProductByName(String keyword){
        ArrayList<Product> arrSearch= new ArrayList<>();
        for(int i = 0 ;i<products.size();i++){
            if(products.get(i).getName().contains(keyword)){
                arrSearch.add(products.get(i));
            }
        }
        return arrSearch;
    }
    public ArrayList<Product> sortProductByPrice(boolean ascending){
        if(ascending==true){
            products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        }else{
            products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        }
        return products;
    }

}
