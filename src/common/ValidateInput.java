package common;
import ss4_Oop.thuc_hanh.student.model.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ValidateInput {
    // check so thuc
    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // check so nguyen
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isPositiveInteger(String input) {
        try {
            int num = Integer.parseInt(input);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //chu cai co dau va khoang trang
    public static boolean isVietnameseLettersAndSpaces(String input) {
        return input.matches("[\\p{L}\\s]+");
    }
    // kiem tra email
    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    public static boolean isValidBirthday(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(input, formatter);
            return !date.isAfter(LocalDate.now()); // Không được lớn hơn ngày hiện tại
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static boolean isCodeExists(String code, List<Student> students) {
        return students.stream().anyMatch(s -> String.valueOf(s.getCode()).equals(code));
    }
    public static boolean isValidPhoneNumber(String phone) {
        // Định dạng số điện thoại Việt Nam: bắt đầu với 0, sau đó là 9 số.
        return phone.matches("^0(3|5|7|8|9)[0-9]{8}$");
    }
    public static double inputDouble(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                value = Double.parseDouble(input);
                if (value>1000||value<-1000) {
                    System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
                    continue;
                }
                break; // nhập đúng
            } catch (NumberFormatException e) {
                System.out.println("Không phải số hợp lệ. Vui lòng nhập lại.");
            }
        }
        return value;
    }
    public static boolean isString(String input) {
        return input.matches("[A-Za-zÀ-ÿ\\s]+");  // Kiểm tra chỉ có chữ cái và khoảng trắng
    }
}
