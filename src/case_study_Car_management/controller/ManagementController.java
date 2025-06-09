package case_study_Car_management.controller;

import case_study_Car_management.module.Car;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.module.Truck;
import case_study_Car_management.module.Vehicle;
import case_study_Car_management.repository.ITruckRepository;
import case_study_Car_management.service.*;
import case_study_Car_management.view.CarView;
import case_study_Car_management.view.MotorbikeView;
import case_study_Car_management.view.TruckView;
import case_study_Car_management.view.View;

import java.util.ArrayList;
import java.util.List;

public class ManagementController {
    private ICarService carService = new CarService();
    private ITruckService truckService = new TruckService();
    private IMotorbikeService  motorbikeService = new MotorbikeService();

    private View mainView;
    private CarView viewCar;
    private TruckView viewTruck;
    private MotorbikeView viewMotorbike;

        public ManagementController() {
            mainView = new View();
            viewCar = new CarView();
            viewTruck = new TruckView();
            viewMotorbike = new MotorbikeView();
        }

        public void start() {
            mainView.showWelcome();

            while (true) {
                int choice = mainView.showMainMenuAndGetChoice();

                switch (choice) {
                    case 1:
                        addVehicle();
                        break;
                    case 2:
                        ArrayList<Vehicle> vehicles = getAllVehicle();
                        displayAllVehicles(vehicles);
                        break;
                    case 3:
                        editVehicle(); // ← THÊM MỚI
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
                    default:
                        mainView.showInvalidChoice();
                }
            }
        }

        private void addVehicle() {
            int vehicleType = mainView.showVehicleTypeMenuAndGetChoice();

            Vehicle newVehicle = null;

            switch (vehicleType) {
                case 1: // Ô tô
                    newVehicle = viewCar.getCarInput();
                    if (newVehicle != null) {
                        carService.add((Car) newVehicle);
                        viewCar.showCarAdded();
                    }
                    break;

                case 2: // Xe tải
                    newVehicle = viewTruck.getTruckInput();
                    if (newVehicle != null) {
                        truckService.add((Truck) newVehicle);
                        viewTruck.showTruckAdded();
                    }
                    break;

                case 3: // Xe máy
                    newVehicle = viewMotorbike.getMotorbikeInput();
                    if (newVehicle != null) {
                        motorbikeService.add((Motorbike) newVehicle);
                        viewMotorbike.showMotorbikeAdded();
                    }
                    break;

                case 4: // Quay lại
                    return;

                default:
                    mainView.showInvalidChoice();
            }
        }

        // ← THÊM MỚI: Chức năng sửa xe
        private void editVehicle() {
            ArrayList<Vehicle> vehicles = getAllVehicle();
            if (vehicles.isEmpty()) {
                mainView.showErrorMessage("Danh sách xe trống!");
                return;
            }

            String licensePlate = mainView.getInputWithPrompt("Nhập biển số xe cần sửa: ");

            Vehicle vehicleToEdit = vehicles.stream()
                    .filter(v -> v.getVehicleLicensePlate().equalsIgnoreCase(licensePlate))
                    .findFirst()
                    .orElse(null);

            if (vehicleToEdit == null) {
                mainView.showErrorMessage("Không tìm thấy xe với biển số: " + licensePlate);
                return;
            }

            mainView.showVehicleToEdit(vehicleToEdit);
            int attributeChoice = mainView.showEditAttributeMenuAndGetChoice();

            if (attributeChoice == 8) return; // Quay lại

            // Gọi view tương ứng để sửa
            if (vehicleToEdit instanceof Car) {
                viewCar.editCarAttribute((Car) vehicleToEdit, attributeChoice);
            } else if (vehicleToEdit instanceof Truck) {
                viewTruck.editTruckAttribute((Truck) vehicleToEdit, attributeChoice);
            } else if (vehicleToEdit instanceof Motorbike) {
                viewMotorbike.editMotorbikeAttribute((Motorbike) vehicleToEdit, attributeChoice);
            }
        }

        private void displayAllVehicles(ArrayList<Vehicle> vehicles) {
            mainView.showAllVehicles(vehicles);
        }

        private void removeVehicle() {
            ArrayList<Vehicle> vehicles = getAllVehicle();
            if (vehicles.isEmpty()) {
                mainView.showErrorMessage("Danh sách xe trống!");
                return;
            }
            String licensePlate = mainView.getInputWithPrompt("Nhập biển số xe cần xóa: ");
            if(carService.delete(licensePlate) || truckService.delete(licensePlate) || motorbikeService.delete(licensePlate)){
                System.out.println("đã xoá thành công");
            }else{
                System.out.println("không tìm thấy biển số xe tương ứng");
            }
        }

        private void searchVehicle() {
            ArrayList<Vehicle> vehicles = getAllVehicle();
            if (vehicles.isEmpty()) {
                mainView.showErrorMessage("Danh sách xe trống!");
                return;
            }

            String licensePlate = mainView.getInputWithPrompt("Nhập biển số xe cần tìm: ");

            Vehicle found = vehicles.stream()
                    .filter(v -> v.getVehicleLicensePlate().equalsIgnoreCase(licensePlate))
                    .findFirst()
                    .orElse(null);

            if (found != null) {
                mainView.showSuccessMessage("Tìm thấy xe:");
                System.out.println(found.getInfo());
            } else {
                mainView.showErrorMessage("Không tìm thấy xe với biển số: " + licensePlate);
            }
        }
        private ArrayList<Vehicle> getAllVehicle(){
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            List<Car> cars = carService.findAll();
            vehicles.addAll(cars);
            List<Truck> trucks = truckService.findAll();
            vehicles.addAll(trucks);
            List<Motorbike> motorbikes = motorbikeService.findAll();
            vehicles.addAll(motorbikes);
            return vehicles;
        }
    }

