package ss17_banary_file.bai_tap.product_management.view;

import ss17_banary_file.bai_tap.product_management.modle.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n===== QUẢN LÝ SẢN PHẨM =====");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. Tìm kiếm sản phẩm theo mã");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public int inputChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public Product inputProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        String code = scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            price = -1;
        }

        System.out.print("Nhập hãng sản xuất: ");
        String item = scanner.nextLine();

        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();

        return new Product(code, name, price, item, description);
    }

    public String inputId(String action) {
        System.out.print("Nhập mã sản phẩm cần " + action + ": ");
        return scanner.nextLine();
    }

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        products.forEach(System.out::println);
    }

    public void displayProduct(Product product) {
        System.out.println(product);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
