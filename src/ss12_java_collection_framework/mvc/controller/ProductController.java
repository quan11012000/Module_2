package ss12_java_collection_framework.mvc.controller;
import ss12_java_collection_framework.mvc.model.Product;
import ss12_java_collection_framework.mvc.service.ProductService;
import ss12_java_collection_framework.mvc.view.ProductView;
import java.util.List;
public class ProductController {
    private ProductService service = new ProductService();
    private ProductView view = new ProductView();
    public void run() {
        while (true) {
            System.out.println("========= MENU QUẢN LÝ SẢN PHẨM =========");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Sắp xếp theo tên (trùng tên thì theo ID)");
            System.out.println("0. Thoát");
            int choice = view.inputChoice();
            switch (choice) {
                case 1:
                    List<Product> products = service.findAll();
                    view.displayProducts(products);
                    break;
                case 2:
                    Product product = view.inputProduct();
                    service.add(product);
                    System.out.println("Đã thêm sản phẩm.");
                    break;
                case 3:
                    int id = view.inputId();
                    Product toDelete = service.findById(id);
                    if (toDelete != null) {
                        service.delete(id);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với ID này.");
                    }
                    break;
                case 4:
                    List<Product> sortedProducts = service.sortByName(true);
                    System.out.println("Danh sách sản phẩm đã sắp xếp:");
                    view.displayProducts(sortedProducts);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời nhập lại!");
            }
        }
    }
}