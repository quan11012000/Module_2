package case_study_Car_management.view;

import case_study_Car_management.module.Car;
import case_study_Car_management.module.Vehicle;

import java.util.List;
import java.util.Scanner;

public class CarView {
    private final Scanner scanner;
    private final InputHelper inputHelper;

    public CarView() {
        scanner = new Scanner(System.in);
        inputHelper = new InputHelper(scanner);
    }

    public Car getCarInput(List<Vehicle> existingVehicles) {
        showHeader();

        String name = inputHelper.promptValidatedString("Tên xe: ");
        String color = inputHelper.promptValidatedString("Màu xe: ");
        double price = inputHelper.promptDouble("Giá xe (VND): ");
        String licensePlate = inputHelper.inputLicensePlateWithValidation("ô tô", existingVehicles);
        String manufacturer = inputHelper.promptValidatedString("Hãng sản xuất: ");
        String year = inputHelper.promptYear("Năm sản xuất: ");
        String description = inputHelper.promptDescription("Mô tả xe: ");

        return new Car(name, color, price, licensePlate, manufacturer, year, description);
    }

    public void editCarAllAttributes(Car car) {
        System.out.println("\n🔧 CẬP NHẬT TOÀN BỘ THÔNG TIN Ô TÔ (ENTER để giữ nguyên)");

        String newName = inputHelper.promptWithDefault("Tên xe mới (hiện tại: " + car.getVehicleName() + "): ", car.getVehicleName(), true, 5, 100);
        String newColor = inputHelper.promptWithDefault("Màu xe mới (hiện tại: " + car.getVehicleColor() + "): ", car.getVehicleColor(), true, 3, 100);
        double newPrice = inputHelper.promptDoubleWithDefault("Giá xe mới (hiện tại: " + car.getVehiclePrice() + "): ", car.getVehiclePrice());
        String newManufacturer = inputHelper.promptWithDefault("Hãng sản xuất mới (hiện tại: " + car.getVehicleManufacturer() + "): ", car.getVehicleManufacturer(), true, 3, 100);
        String newYear = inputHelper.promptYearWithDefault("Năm sản xuất mới (hiện tại: " + car.getVehicleYearManufacturer() + "): ", car.getVehicleYearManufacturer());
        String newDescription = inputHelper.promptWithDefault("Mô tả mới: ", car.getVehicleDescription(), false, 0, 500);

        car.setVehicleName(newName);
        car.setVehicleColor(newColor);
        car.setVehiclePrice(newPrice);
        car.setVehicleManufacturer(newManufacturer);
        car.setVehicleYearManufacturer(newYear);
        car.setVehicleDescription(newDescription);

        System.out.println("✅ Đã cập nhật toàn bộ thông tin ô tô.");
    }

    private void showHeader() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🚗          NHẬP THÔNG TIN Ô TÔ");
        System.out.println("=".repeat(50));
    }

    public void showCarAdded() {
        System.out.println("✅ Đã thêm ô tô thành công!");
        System.out.println("🚗 Ô tô đã được lưu vào hệ thống.");
    }
}
