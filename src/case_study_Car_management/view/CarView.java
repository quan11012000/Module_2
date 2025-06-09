package case_study_Car_management.view;
import case_study_Car_management.module.Car;
import case_study_Car_management.module.Vehicle;

import java.util.List;
import java.util.Scanner;
public class CarView {
    private Scanner scanner;


    public CarView() {
        scanner = new Scanner(System.in);
    }

    public Car getCarInput() {
        showHeader();

        String vehicleName = getValidInput("Tên xe: ");
        String vehicleColor = getValidInput("Màu xe: ");
        double vehiclePrice = getValidPrice("Giá xe (VND): ");
        String vehicleLicensePlate = getValidInput("Biển số xe: ");
        String vehicleManufacturer = getValidInput("Hãng sản xuất: ");
        String vehicleYearManufacturer = getValidInput("Năm sản xuất: ");
        String vehicleDescription = getValidInput("Mô tả xe: ");

        // Thêm thuộc tính riêng của Car nếu có
        return new Car(vehicleName, vehicleColor, vehiclePrice, vehicleLicensePlate,
                vehicleManufacturer, vehicleYearManufacturer, vehicleDescription);
    }

    public void editCarAttribute(Car car, int attributeChoice) {
        System.out.println("\n🔧 SỬA THÔNG TIN Ô TÔ");

        switch (attributeChoice) {
            case 1: // Tên xe
                String newName = getValidInput("Tên xe mới: ");
                car.setVehicleName(newName);
                System.out.println("✅ Đã cập nhật tên xe!");
                break;

            case 2: // Màu xe
                String newColor = getValidInput("Màu xe mới: ");
                car.setVehicleColor(newColor);
                System.out.println("✅ Đã cập nhật màu xe!");
                break;

            case 3: // Giá xe
                double newPrice = getValidPrice("Giá xe mới (VND): ");
                car.setVehiclePrice(newPrice);
                System.out.println("✅ Đã cập nhật giá xe!");
                break;

            case 4: // Biển số
                String newLicensePlate = getValidInput("Biển số mới: ");
                car.setVehicleLicensePlate(newLicensePlate);
                System.out.println("✅ Đã cập nhật biển số xe!");
                break;

            case 5: // Hãng sản xuất
                String newManufacturer = getValidInput("Hãng sản xuất mới: ");
                car.setVehicleManufacturer(newManufacturer);
                System.out.println("✅ Đã cập nhật hãng sản xuất!");
                break;

            case 6: // Năm sản xuất
                String newYear = getValidInput("Năm sản xuất mới: ");
                car.setVehicleYearManufacturer(newYear);
                System.out.println("✅ Đã cập nhật năm sản xuất!");
                break;

            case 7: // Mô tả
                String newDescription = getValidInput("Mô tả mới: ");
                car.setVehicleDescription(newDescription);
                System.out.println("✅ Đã cập nhật mô tả xe!");
                break;

            default:
                System.out.println("❌ Lựa chọn không hợp lệ!");
        }
    }

    private void showHeader() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🚗           NHẬP THÔNG TIN Ô TÔ");
        System.out.println("=".repeat(50));
    }

    private String getValidInput(String prompt) {
        String input;
        do {
            System.out.print("📝 " + prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ Vui lòng nhập thông tin!");
            }
        } while (input.isEmpty());
        return input;
    }

    private double getValidPrice(String prompt) {
        double price;
        do {
            try {
                System.out.print("💰 " + prompt);
                price = Double.parseDouble(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("❌ Giá xe phải lớn hơn 0!");
                    price = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số hợp lệ!");
                price = -1;
            }
        } while (price == -1);
        return price;
    }
    public boolean isDuplicateLicensePlate(String licensePlate, String vehicleType,List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleLicensePlate().equalsIgnoreCase(licensePlate) &&
                    vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidLicensePlateFormat(String licensePlate) {
        // Regex cho biển số VN: 2 số + 1 chữ + 5 số (ví dụ: 30A-12345)
        String regex = "^\\d{2}[A-Z]\\d-\\d{5}$";;
        return licensePlate.matches(regex);
    }

    public String inputLicensePlateWithValidation(String vehicleType) {
        String licensePlate;

        while (true) {
            System.out.print("Nhập biển số xe " + vehicleType + " (định dạng: 30A1-12345): ");
            licensePlate = scanner.nextLine().trim().toUpperCase();

            // Kiểm tra định dạng
            if (!isValidLicensePlateFormat(licensePlate)) {
                System.out.println("❌ Định dạng biển số không hợp lệ! Vui lòng nhập theo định dạng: 30A-12345");
                continue;
            }

            // Kiểm tra trùng lặp

            // Nếu không trùng và đúng định dạng
            System.out.println("✅ Biển số " + licensePlate + " hợp lệ!");
            break;
        }

        return licensePlate;
    }

    public void showCarAdded() {
        System.out.println("✅ Đã thêm ô tô thành công!");
        System.out.println("🚗 Ô tô đã được lưu vào hệ thống.");
    }
}
