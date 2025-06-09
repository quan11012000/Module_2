package case_study_Car_management.view;

import case_study_Car_management.module.Truck;

import java.util.Scanner;

public class TruckView {

        private Scanner scanner;

        public TruckView() {
            scanner = new Scanner(System.in);
        }

        public Truck getTruckInput() {
            showHeader();

            String vehicleName = getValidInput("Tên xe: ");
            String vehicleColor = getValidInput("Màu xe: ");
            double vehiclePrice = getValidPrice("Giá xe (VND): ");
            String vehicleLicensePlate = getValidInput("Biển số xe: ");
            String vehicleManufacturer = getValidInput("Hãng sản xuất: ");
            String vehicleYearManufacturer = getValidInput("Năm sản xuất: ");
            String vehicleDescription = getValidInput("Mô tả xe: ");

            return new Truck(vehicleName, vehicleColor, vehiclePrice, vehicleLicensePlate,
                    vehicleManufacturer, vehicleYearManufacturer, vehicleDescription);
        }

        public void editTruckAttribute(Truck truck, int attributeChoice) {
            System.out.println("\n🔧 SỬA THÔNG TIN XE TẢI");

            switch (attributeChoice) {
                case 1: // Tên xe
                    String newName = getValidInput("Tên xe mới: ");
                    truck.setVehicleName(newName);
                    System.out.println("✅ Đã cập nhật tên xe!");
                    break;

                case 2: // Màu xe
                    String newColor = getValidInput("Màu xe mới: ");
                    truck.setVehicleColor(newColor);
                    System.out.println("✅ Đã cập nhật màu xe!");
                    break;

                case 3: // Giá xe
                    double newPrice = getValidPrice("Giá xe mới (VND): ");
                    truck.setVehiclePrice(newPrice);
                    System.out.println("✅ Đã cập nhật giá xe!");
                    break;

                case 4: // Biển số
                    String newLicensePlate = getValidInput("Biển số mới: ");
                    truck.setVehicleLicensePlate(newLicensePlate);
                    System.out.println("✅ Đã cập nhật biển số xe!");
                    break;

                case 5: // Hãng sản xuất
                    String newManufacturer = getValidInput("Hãng sản xuất mới: ");
                    truck.setVehicleManufacturer(newManufacturer);
                    System.out.println("✅ Đã cập nhật hãng sản xuất!");
                    break;

                case 6: // Năm sản xuất
                    String newYear = getValidInput("Năm sản xuất mới: ");
                    truck.setVehicleYearManufacturer(newYear);
                    System.out.println("✅ Đã cập nhật năm sản xuất!");
                    break;

                case 7: // Mô tả
                    String newDescription = getValidInput("Mô tả mới: ");
                    truck.setVehicleDescription(newDescription);
                    System.out.println("✅ Đã cập nhật mô tả xe!");
                    break;

                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }

        private void showHeader() {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("🚛          NHẬP THÔNG TIN XE TẢI");
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

        public void showTruckAdded() {
            System.out.println("✅ Đã thêm xe tải thành công!");
            System.out.println("🚛 Xe tải đã được lưu vào hệ thống.");
        }
    }

