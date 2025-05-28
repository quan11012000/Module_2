package ss12_java_collection_framework.mvc.view;

import ss12_java_collection_framework.mvc.controller.ProductController;
import ss12_java_collection_framework.mvc.model.Product;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        System.out.println("---- DANH SÁCH SẢN PHẨM ----");
        for (Product p : products) {
            System.out.println("ID: " + p.getId() +
                    " | Tên: " + p.getName() +
                    " | Giá: " + p.getPrice());
        }
        System.out.println("----------------------------");
    }

    public Product inputProduct() {

        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Product(id, name, price);
    }

    public int inputId() {
        System.out.print("Nhập ID sản phẩm: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputChoice() {
        System.out.print("Chọn chức năng: ");
        return Integer.parseInt(scanner.nextLine());
    }
}