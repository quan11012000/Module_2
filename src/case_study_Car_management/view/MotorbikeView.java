package case_study_Car_management.view;

import case_study_Car_management.module.Motorbike;
import case_study_Car_management.module.Vehicle;

import java.util.List;
import java.util.Scanner;

public class MotorbikeView {
    private final Scanner scanner;
    private final InputHelper inputHelper;

    public MotorbikeView() {
        scanner = new Scanner(System.in);
        inputHelper = new InputHelper(scanner);
    }

    public Motorbike getMotorbikeInput(List<Vehicle> existingVehicles) {
        showHeader();

        String name = inputHelper.promptValidatedString("Tên xe: ");
        String color = inputHelper.promptValidatedString("Màu xe: ");
        double price = inputHelper.promptDouble("Giá xe (VND): ");
        String licensePlate = inputHelper.inputLicensePlateWithValidation("xe máy", existingVehicles);
        String manufacturer = inputHelper.promptValidatedString("Hãng sản xuất: ");
        String year = inputHelper.promptYear("Năm sản xuất: ");
        String description = inputHelper.promptDescription("Mô tả xe: ");

        return new Motorbike(name, color, price, licensePlate, manufacturer, year, description);
    }

    public void editMotorbikeAllAttributes(Motorbike motorbike) {
        System.out.println("\n🔧 CẬP NHẬT TOÀN BỘ THÔNG TIN XE MÁY (ENTER để giữ nguyên)");

        String newName = inputHelper.promptWithDefault("Tên xe mới (hiện tại: " + motorbike.getVehicleName() + "): ", motorbike.getVehicleName(), true, 5, 100);
        String newColor = inputHelper.promptWithDefault("Màu xe mới (hiện tại: " + motorbike.getVehicleColor() + "): ", motorbike.getVehicleColor(), true, 3, 100);
        double newPrice = inputHelper.promptDoubleWithDefault("Giá xe mới (hiện tại: " + motorbike.getVehiclePrice() + "): ", motorbike.getVehiclePrice());
        String newManufacturer = inputHelper.promptWithDefault("Hãng sản xuất mới (hiện tại: " + motorbike.getVehicleManufacturer() + "): ", motorbike.getVehicleManufacturer(), true, 3, 100);
        String newYear = inputHelper.promptYearWithDefault("Năm sản xuất mới (hiện tại: " + motorbike.getVehicleYearManufacturer() + "): ", motorbike.getVehicleYearManufacturer());
        String newDescription = inputHelper.promptWithDefault("Mô tả mới: ", motorbike.getVehicleDescription(), false, 0, 500);

        motorbike.setVehicleName(newName);
        motorbike.setVehicleColor(newColor);
        motorbike.setVehiclePrice(newPrice);
        motorbike.setVehicleManufacturer(newManufacturer);
        motorbike.setVehicleYearManufacturer(newYear);
        motorbike.setVehicleDescription(newDescription);

        System.out.println("✅ Đã cập nhật toàn bộ thông tin xe máy.");
    }

    private void showHeader() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🏍️          NHẬP THÔNG TIN XE MÁY");
        System.out.println("=".repeat(50));
    }

    public void showMotorbikeAdded() {
        System.out.println("✅ Đã thêm xe máy thành công!");
        System.out.println("🏍️ Xe máy đã được lưu vào hệ thống.");
    }
}
