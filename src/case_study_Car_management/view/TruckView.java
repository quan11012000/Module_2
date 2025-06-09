package case_study_Car_management.view;

import case_study_Car_management.module.Truck;
import case_study_Car_management.module.Vehicle;

import java.util.List;
import java.util.Scanner;

public class TruckView {
    private final Scanner scanner;
    private final InputHelper inputHelper;

    public TruckView() {
        scanner = new Scanner(System.in);
        inputHelper = new InputHelper(scanner);
    }

    public Truck getTruckInput(List<Vehicle> existingVehicles) {
        showHeader();

        String name = inputHelper.promptValidatedString("Tên xe: ");
        String color = inputHelper.promptValidatedString("Màu xe: ");
        double price = inputHelper.promptDouble("Giá xe (VND): ");
        String licensePlate = inputHelper.inputLicensePlateWithValidation("xe tải", existingVehicles);
        String manufacturer = inputHelper.promptValidatedString("Hãng sản xuất: ");
        String year = inputHelper.promptYear("Năm sản xuất: ");
        String description = inputHelper.promptDescription("Mô tả xe: ");

        return new Truck(name, color, price, licensePlate, manufacturer, year, description);
    }

    public void editTruckAllAttributes(Truck truck) {
        System.out.println("\n🔧 CẬP NHẬT TOÀN BỘ THÔNG TIN XE TẢI (ENTER để giữ nguyên)");

        String newName = inputHelper.promptWithDefault("Tên xe mới (hiện tại: " + truck.getVehicleName() + "): ", truck.getVehicleName(), true, 5, 100);
        String newColor = inputHelper.promptWithDefault("Màu xe mới (hiện tại: " + truck.getVehicleColor() + "): ", truck.getVehicleColor(), true, 3, 100);
        double newPrice = inputHelper.promptDoubleWithDefault("Giá xe mới (hiện tại: " + truck.getVehiclePrice() + "): ", truck.getVehiclePrice());
        String newManufacturer = inputHelper.promptWithDefault("Hãng sản xuất mới (hiện tại: " + truck.getVehicleManufacturer() + "): ", truck.getVehicleManufacturer(), true, 3, 100);
        String newYear = inputHelper.promptYearWithDefault("Năm sản xuất mới (hiện tại: " + truck.getVehicleYearManufacturer() + "): ", truck.getVehicleYearManufacturer());
        String newDescription = inputHelper.promptWithDefault("Mô tả mới: ", truck.getVehicleDescription(), false, 0, 500);

        truck.setVehicleName(newName);
        truck.setVehicleColor(newColor);
        truck.setVehiclePrice(newPrice);
        truck.setVehicleManufacturer(newManufacturer);
        truck.setVehicleYearManufacturer(newYear);
        truck.setVehicleDescription(newDescription);

        System.out.println("✅ Đã cập nhật toàn bộ thông tin xe tải.");
    }

    private void showHeader() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🚛          NHẬP THÔNG TIN XE TẢI");
        System.out.println("=".repeat(50));
    }

    public void showTruckAdded() {
        System.out.println("✅ Đã thêm xe tải thành công!");
        System.out.println("🚛 Xe tải đã được lưu vào hệ thống.");
    }
}
