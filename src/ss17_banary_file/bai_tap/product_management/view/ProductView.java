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

    public Product inputProduct(List<String> existingCodes) {
        String code;
        while (true) {
            System.out.print("Nhập mã sản phẩm (số nguyên, không trống, không trùng): ");
            code = scanner.nextLine().trim();

            if (code.isEmpty()) {
                System.out.println("Mã sản phẩm không được để trống, vui lòng nhập lại.");
                continue;
            }
            try {
                Integer.parseInt(code);
            } catch (NumberFormatException e) {
                System.out.println("Mã sản phẩm phải là số nguyên, vui lòng nhập lại.");
                continue;
            }
            if (existingCodes.contains(code)) {
                System.out.println("Mã sản phẩm đã tồn tại, vui lòng nhập mã khác.");
                continue;
            }
            break;
        }

        String name;
        while (true) {
            System.out.print("Nhập tên sản phẩm (chỉ chữ và khoảng trắng, không trống): ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên sản phẩm không được để trống, vui lòng nhập lại.");
                continue;
            }
            if (!name.matches("[a-zA-Z\\s]+")) {
                System.out.println("Tên sản phẩm chỉ được chứa chữ cái và khoảng trắng, vui lòng nhập lại.");
                continue;
            }
            break;
        }

        double price;
        while (true) {
            System.out.print("Nhập giá sản phẩm (số thực >= 0): ");
            String input = scanner.nextLine();
            try {
                price = Double.parseDouble(input);
                if (price < 0) {
                    System.out.println("Giá phải lớn hơn hoặc bằng 0, vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ, vui lòng nhập số.");
            }
        }

        String item;
        while (true) {
            System.out.print("Nhập hãng sản xuất (chỉ chữ và khoảng trắng, không trống): ");
            item = scanner.nextLine().trim();
            if (item.isEmpty()) {
                System.out.println("Hãng sản xuất không được để trống, vui lòng nhập lại.");
                continue;
            }
            if (!item.matches("[a-zA-Z\\s]+")) {
                System.out.println("Hãng sản xuất chỉ được chứa chữ cái và khoảng trắng, vui lòng nhập lại.");
                continue;
            }
            break;
        }

        String description;
        while (true) {
            System.out.print("Nhập mô tả sản phẩm (chỉ chữ và khoảng trắng, không trống): ");
            description = scanner.nextLine().trim();
            if (description.isEmpty()) {
                System.out.println("Mô tả không được để trống, vui lòng nhập lại.");
                continue;
            }
            if (description.length() < 5 || description.length() > 500) {
                System.out.println("Mô tả phải từ 5 đến 500 ký tự, vui lòng nhập lại.");
                continue;
            }
            break;
        }

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
