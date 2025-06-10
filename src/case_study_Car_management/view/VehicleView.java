package case_study_Car_management.view;

import case_study_Car_management.entity.Vehicle;

import java.util.List;
import java.util.Scanner;

public class VehicleView {
    private final Scanner scanner;
    private final InputHelper inputHelper;

    public VehicleView() {
        scanner = new Scanner(System.in);
        inputHelper = new InputHelper(scanner);
    }

    public Vehicle getVehicleInput(List<Vehicle> existingVehicles, int vehicleTypeId) {
        showHeader();
        String name = inputHelper.promptValidatedString("Tên xe: ");
        String color = inputHelper.promptValidatedString("Màu xe: ");
        double price = inputHelper.promptDouble("Giá xe (VND): ");
        String licensePlate = inputHelper.inputLicensePlateWithValidationTruck("ô tô", existingVehicles);
        String manufacturer = inputHelper.promptValidatedString("Hãng sản xuất: ");
        String year = inputHelper.promptYear("Năm sản xuất: ");
        String description = inputHelper.promptDescription("Mô tả xe: ");
        return new Vehicle(name, color, price, licensePlate, manufacturer, year, description, vehicleTypeId);
    }

    public Vehicle editAllAttributes(Vehicle vehicle) {
        System.out.println("\n🔧 CẬP NHẬT TOÀN BỘ THÔNG TIN (ENTER để giữ nguyên)");
        String newName = inputHelper.promptWithDefault("Tên xe mới (hiện tại: " + vehicle.getVehicleName() + "): ", vehicle.getVehicleName(), true, 5, 100);
        String newColor = inputHelper.promptWithDefault("Màu xe mới (hiện tại: " + vehicle.getVehicleColor() + "): ", vehicle.getVehicleColor(), true, 3, 100);
        double newPrice = inputHelper.promptDoubleWithDefault("Giá xe mới (hiện tại: " + vehicle.getVehiclePrice() + "): ", vehicle.getVehiclePrice());
        String newManufacturer = inputHelper.promptWithDefault("Hãng sản xuất mới (hiện tại: " + vehicle.getVehicleManufacturer() + "): ", vehicle.getVehicleManufacturer(), true, 3, 100);
        String newYear = inputHelper.promptYearWithDefault("Năm sản xuất mới (hiện tại: " + vehicle.getVehicleYearManufacturer() + "): ", vehicle.getVehicleYearManufacturer());
        String newDescription = inputHelper.promptWithDefault("Mô tả mới: ", vehicle.getVehicleDescription(), false, 0, 500);
        vehicle.setVehicleName(newName);
        vehicle.setVehicleColor(newColor);
        vehicle.setVehiclePrice(newPrice);
        vehicle.setVehicleManufacturer(newManufacturer);
        vehicle.setVehicleYearManufacturer(newYear);
        vehicle.setVehicleDescription(newDescription);
        return vehicle;
    }
    private void showHeader() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("NHẬP THÔNG TIN XE");
        System.out.println("=".repeat(50));
    }

    public void showCarAdded() {
        System.out.println("✅ Đã thêm ô tô thành công!");
        System.out.println("🚗 Ô tô đã được lưu vào hệ thống.");
    }
}
