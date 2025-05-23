package ss12_java_collection_framework.collection_framework;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        manager.add(new Product(1, "Laptop", 1500));
        manager.add(new Product(2, "LaptopAsus", 800));
        manager.add(new Product(3, "Tablet", 1200));
        System.out.println("-------------------------display----------------------------");
        manager.displayProducts();
        System.out.println();
        System.out.println("-------------------------edit----------------------------");
        manager.editProduct(new Product(3,"LaptopDell",1800));
        manager.displayProducts();
        System.out.println("-------------------------saerch----------------------------");
        manager.displayFind(manager.searchProductByName("Lap"));
        System.out.println("-----------------sap xep tang dan theo gia-----------------");
        manager.sortProductByPrice(true);
        manager.displayProducts();
        System.out.println("-----------------sap xep giam dan theo gia-----------------");
        manager.sortProductByPrice(false);
        manager.displayProducts();
    }

}
