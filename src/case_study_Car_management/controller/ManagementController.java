package case_study_Car_management.controller;

import case_study_Car_management.entity.Vehicle;
import case_study_Car_management.entity.VehicleType;
import case_study_Car_management.service.IVehicleService;
import case_study_Car_management.service.IVehicleTypeService;
import case_study_Car_management.service.VehicleService;
import case_study_Car_management.service.VehicleTypeService;
import case_study_Car_management.view.MaintenanceView;
import case_study_Car_management.view.VehicleView;
import case_study_Car_management.view.View;

import java.util.ArrayList;
import java.util.List;

public class ManagementController {
    private final IVehicleService vehicleService = new VehicleService();
    private final IVehicleTypeService vehicleTypeService = new VehicleTypeService();
    private final VehicleView vehicleView = new VehicleView();
    private final View mainView = new View();
    private final MaintenanceView maintenanceView = new MaintenanceView();
    public void start() {
        mainView.showWelcome();
        while (true) {
            int choice = mainView.showMainMenuAndGetChoice();
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    displayAllVehicles();
                    break;
                case 3:
                    editVehicle();
                    break;
                case 4:
                    removeVehicle();
                    break;
                case 5:
                    searchVehicle();
                    break;
                case 6:
                    mainView.showExitMessage();
                    return;
                case 7:
                    maintenanceView.showMenu();
                    break;
                default:
                    mainView.showInvalidChoice();
            }
        }
    }
    private void addVehicle() {
        List<Vehicle> existingVehicles = vehicleService.findAll();
        List<VehicleType> vehicleTypes = vehicleTypeService.findAll();
        int vehicleTypeId = mainView.showVehicleTypeMenuAndGetChoice(vehicleTypes);
        Vehicle vehicle = vehicleView.getVehicleInput(existingVehicles, vehicleTypeId);
        if (vehicleService.add(vehicle)) {
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }

    private void editVehicle() {
        List<Vehicle> existingVehicles = vehicleService.findAll();
        if (existingVehicles.isEmpty()) {
            mainView.showErrorMessage("Danh sách xe trống!");
            return;
        }
        String licensePlate = mainView.getInputWithPrompt("Nhập biển số xe cần sửa: ");
        Vehicle vehicle = vehicleService.findByLicensePlate(licensePlate);
        if (vehicle == null) {
            mainView.showErrorMessage("Không tìm thấy xe với biển số: " + licensePlate);
            return;
        }
        mainView.showVehicleToEdit(vehicle);
        Vehicle newVehicle = vehicleView.editAllAttributes(vehicle);
        if (vehicleService.edit(newVehicle)) {
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Sửa không thành công");
        }
    }

    private void displayAllVehicles() {
        int choice = mainView.selectDisplayType();
        switch (choice) {
            case 1:
                List<Vehicle> existingVehicles = vehicleService.findAll();
                mainView.showAllVehicles(existingVehicles);
                break;
            case 2:
                List<VehicleType> vehicleTypes = vehicleTypeService.findAll();
                System.out.println("Chọn loại xe muốn hiển thị:");
                int vehicleTypeId = mainView.showVehicleTypeMenuAndGetChoice(vehicleTypes);
                List<Vehicle> matchedVehicles = vehicleService.findByType(vehicleTypeId);
                mainView.showAllVehicles(matchedVehicles);
                break;
        }
    }
    private void removeVehicle() {
        List<Vehicle> existingVehicles = vehicleService.findAll();
        if (existingVehicles.isEmpty()) {
            mainView.showErrorMessage("Danh sách xe trống!");
            return;
        }
        String licensePlate = mainView.getInputWithPrompt("Nhập biển số xe cần xóa: ");
        Vehicle vehicle = vehicleService.findByLicensePlate(licensePlate);
        if (vehicle == null) {
            mainView.showErrorMessage("Không tìm thấy xe với biển số: " + licensePlate);
            return;
        } else {
            System.out.println("🚗 Tìm thấy xe: " + vehicle.getInfo());
            String confirm = mainView.getInputWithPrompt("⚠️ Bạn có chắc chắn muốn xóa xe này? (1 = Có / còn lại là không = Không): ");
            if (confirm.equals("1")) {
                if (vehicleService.delete(licensePlate)) {
                    System.out.println("✅ Đã xóa xe thành công!");
                } else {
                    System.out.println("❌ Xóa thất bại!");
                }
            } else {
                System.out.println("❌ Hủy thao tác xóa xe.");
            }
        }
    }
    private void searchVehicle() {
        List<Vehicle> existingVehicles = vehicleService.findAll();
        if (existingVehicles.isEmpty()) {
            mainView.showErrorMessage("Danh sách xe trống!");
            return;
        }
        String keyword = mainView.getInputWithPrompt("Nhập từ khóa cần tìm (Tên hoặc biển số): ").toLowerCase();
        List<Vehicle> matchedVehicles = vehicleService.findByKeyword(keyword);
        if (!matchedVehicles.isEmpty()) {
            mainView.showSuccessMessage("🔍 Tìm thấy " + matchedVehicles.size() + " xe phù hợp:");
            mainView.showAllVehicles(matchedVehicles);
        } else {
            mainView.showErrorMessage("❌ Không tìm thấy xe nào phù hợp với từ khóa: " + keyword);
        }
    }
}

