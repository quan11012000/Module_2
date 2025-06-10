package case_study_Car_management.view;
import case_study_Car_management.controller.ManagementController;
import case_study_Car_management.entity.Vehicle;
import case_study_Car_management.entity.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class View {
    public static void main(String[] args) {
        new ManagementController().start();
    }


    private Scanner scanner;
    public View() {
        scanner = new Scanner(System.in);
    }
    public void showWelcome() {
        System.out.println("=== HỆ THỐNG QUẢN LÝ XE ===");
    }
    public int showMainMenuAndGetChoice() {
        showMainMenu();
        return getChoice();
    }
    private void showMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                    MENU CHÍNH");
        System.out.println("=".repeat(50));
        System.out.println("1. Thêm xe");
        System.out.println("2. Hiển thị danh sách xe");
        System.out.println("3. Sửa thông tin xe");
        System.out.println("4. Xóa xe");
        System.out.println("5. Tìm kiếm xe");
        System.out.println("6. Thoát");
        System.out.println("=".repeat(50));
        System.out.print("Nhập lựa chọn của bạn: ");
    }
    public int showVehicleTypeMenuAndGetChoice(List<VehicleType> vehicleTypes) {
        for (VehicleType type: vehicleTypes) {
            System.out.printf("%d. %s %s\n", type.getId(), type.getIcon(), type.getName());
        }
        List<Integer> ids = vehicleTypes.stream().map(v -> v.getId()).toList();
        int choice;
        while (true){
            try {
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
                if(ids.contains(choice)){
                    return choice;
                }else{
                    System.out.println("Bạn phải nhập lựa chọn nằm trong menu");
                }
            }catch (NumberFormatException e){
                System.out.println("Bạn phải nhập số. Vui lòng nhập lại");
            }

        }
    }
    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static String getTableHeader() {
        return String.format(
                "| %-15s | %-20s | %-10s | %-12s | %-12s | %-15s | %-4s | %-50s |",
                "Loại xe", "Tên xe", "Màu", "Giá", "Biển số", "Hãng", "Năm", "Mô tả"
        );
    }
    public String getInputWithPrompt(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public void showSuccessMessage(String message) {
        System.out.println("✅ " + message);
    }
    public void showErrorMessage(String message) {
        System.out.println("❌ " + message);
    }
    public void showInvalidChoice() {
        System.out.println("❌ Lựa chọn không hợp lệ! Vui lòng chọn lại.");
    }
    public void showExitMessage() {
        System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
    }
    public void showAllVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            showErrorMessage("Danh sách xe trống!");
            return;
        }
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                        DANH SÁCH XE");
        System.out.println("=".repeat(80));
        System.out.println(getTableHeader());
        System.out.println("-".repeat(161));
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).getInfo());
        }
        System.out.println("📊 Tổng số xe: " + vehicles.size());
    }
    public void showVehicleToEdit(Vehicle vehicle) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           THÔNG TIN XE CẦN SỬA");
        System.out.println("=".repeat(60));
        System.out.println(vehicle.getInfo());
        System.out.println("=".repeat(60));
    }

    public int selectDisplayType() {
        System.out.println("\t1. Hiển thị tất cả");
        System.out.println("\t2. Hiển thị theo loại xe");
        int choice;
        while (true) {
            try {
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice == 1 || choice == 2){
                    return choice;
                }else{
                    System.out.println("Bạn phải nhập lựa chọn nằm trong menu");
                }
            }catch (NumberFormatException e){
                System.out.println("Bạn phải nhập số. Vui lòng nhập lại");
            }
        }
    }
}