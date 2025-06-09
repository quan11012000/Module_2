package case_study_Car_management.view;
import case_study_Car_management.controller.ManagementController;
import case_study_Car_management.module.Vehicle;

import java.util.ArrayList;
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

    public int showVehicleTypeMenuAndGetChoice() {
        showVehicleTypeMenu();
        return getChoice();
    }

    private void showVehicleTypeMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("          CHỌN LOẠI XE");
        System.out.println("=".repeat(40));
        System.out.println("1. 🚗 Ô tô");
        System.out.println("2. 🚛 Xe tải");
        System.out.println("3. 🏍️  Xe máy");
        System.out.println("4. ⬅️  Quay lại");
        System.out.println("=".repeat(40));
        System.out.print("Chọn loại xe: ");
    }

    public int showEditAttributeMenuAndGetChoice() {
        showEditAttributeMenu();
        return getChoice();
    }

    private void showEditAttributeMenu() {
        System.out.println("\n" + "=".repeat(45));
        System.out.println("        CHỌN THUỘC TÍNH CẦN SỬA");
        System.out.println("=".repeat(45));
        System.out.println("1. 📝 Tên xe");
        System.out.println("2. 🎨 Màu xe");
        System.out.println("3. 💰 Giá xe");
        System.out.println("4. 📋 Biển số xe");
        System.out.println("5. 🏭 Hãng sản xuất");
        System.out.println("6. 📅 Năm sản xuất");
        System.out.println("7. 📄 Mô tả xe");
        System.out.println("8. ⬅️  Quay lại");
        System.out.println("=".repeat(45));
        System.out.print("Chọn thuộc tính: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
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

    public void showAllVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            showErrorMessage("Danh sách xe trống!");
            return;
        }
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                        DANH SÁCH XE");
        System.out.println("=".repeat(80));
        System.out.print("Nhóm xe || ");
        System.out.print(" 📝 Tên xe || ");
        System.out.print(" 🎨 Màu xe || ");
        System.out.print(" 💰 Giá xe || ");
        System.out.print(" 📋 Biển số xe || ");
        System.out.print(" 🏭 Hãng sản xuất || ");
        System.out.print(" 📅 Năm sản xuất || ");
        System.out.print(" 📄 Mô tả xe");
        System.out.println();
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).getInfo());
            System.out.println();
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
}