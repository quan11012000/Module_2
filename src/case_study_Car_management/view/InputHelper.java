package case_study_Car_management.view;

import case_study_Car_management.entity.Vehicle;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String promptValidatedString(String message) {
        return promptWithDefault(message, "", true, 5, 100);
    }

    public String promptDescription(String message) {
        return promptWithDefault(message, "", false, 0, 500);
    }

    public String promptWithDefault(String message, String defaultValue, boolean required, int minLen, int maxLen) {
        while (true) {
            System.out.print("📝 " + message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty() || input.equalsIgnoreCase("null")) return defaultValue;

            if (required && (input.length() < minLen || input.length() > maxLen)) {
                System.out.printf("❌ Độ dài phải từ %d đến %d ký tự!\n", minLen, maxLen);
            } else if (!required && input.length() > maxLen) {
                System.out.printf("❌ Độ dài không vượt quá %d ký tự!\n", maxLen);
            } else {
                return input;
            }
        }
    }

    public double promptDouble(String message) {
        return promptDoubleWithDefault(message, -1);
    }

    public double promptDoubleWithDefault(String message, double defaultValue) {
        while (true) {
            System.out.print("💰 " + message);
            String input = scanner.nextLine().trim();

            if ((input.isEmpty() || input.equalsIgnoreCase("null")) && defaultValue >= 0) return defaultValue;

            try {
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("❌ Giá phải lớn hơn 0!");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public String promptYear(String message) {
        return promptYearWithDefault(message, "");
    }

    public String promptYearWithDefault(String message, String defaultYear) {
        int currentYear = Year.now().getValue();
        while (true) {
            System.out.print("🗓️ " + message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty() || input.equalsIgnoreCase("null")) return defaultYear;
            if (!input.matches("^\\d{4}$")) {
                System.out.println("❌ Năm phải gồm 4 chữ số!");
                continue;
            }
            int year = Integer.parseInt(input);
            if (year < (currentYear-30) || year > currentYear ) {
                System.out.printf("❌ Năm phải từ %d đến %d!\n",(currentYear-30), currentYear);
            } else {
                return input;
            }
        }
    }
    public String inputLicensePlateWithValidation(String vehicleType, List<Vehicle> vehicles) {
        String licensePlate;
        while (true) {
            System.out.print("🔑 Nhập biển số xe " + vehicleType + " (VD: 30A1-12345): ");
            licensePlate = scanner.nextLine().trim().toUpperCase();

            if (!isValidLicensePlateFormat(licensePlate)) {
                System.out.println("❌ Định dạng không hợp lệ! Ví dụ: 30A1-12345");
                continue;
            }

            if (isDuplicateLicensePlate(licensePlate, vehicles)) {
                System.out.println("❌ Biển số đã tồn tại trong hệ thống!");
                continue;
            }

            System.out.println("✅ Biển số hợp lệ!");
            break;
        }
        return licensePlate;
    }
    public String inputLicensePlateWithValidationTruck(String vehicleType, List<Vehicle> vehicles) {
        String licensePlate;
        while (true) {
            System.out.print("🔑 Nhập biển số xe " + vehicleType + " (VD: 30A-12345): ");
            licensePlate = scanner.nextLine().trim().toUpperCase();

            if (!isValidLicensePlateFormatxxA(licensePlate)) {
                System.out.println("❌ Định dạng không hợp lệ! Ví dụ: 30A-12345");
                continue;
            }

            if (isDuplicateLicensePlate(licensePlate, vehicles)) {
                System.out.println("❌ Biển số đã tồn tại trong hệ thống!");
                continue;
            }

            System.out.println("✅ Biển số hợp lệ!");
            break;
        }
        return licensePlate;
    }
    public boolean isValidLicensePlateFormatxxA(String licensePlate) {
        return licensePlate.matches("^\\d{2}[A-Z]\\d?-\\d{5}$");
    }
    public boolean isValidLicensePlateFormat(String licensePlate) {
        return licensePlate.matches("^\\d{2}[A-Z]\\d-\\d{5}$");
    }

    public boolean isDuplicateLicensePlate(String licensePlate, List<Vehicle> vehicles) {
        return vehicles.stream().anyMatch(v ->
                v.getVehicleLicensePlate().equalsIgnoreCase(licensePlate));
    }
}
