package ss15_ngoai_le.Illegal_triangle_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleApp {
    public static void main(String[] args) {
        double a = inputOneSide(1);
        double b = inputOneSide(2);
        double c = inputOneSide(3);
        try {
            checkTriangle(a, b, c);
            System.out.println("\u001B[32mBa cạnh hợp lệ để tạo thành tam giác.\u001B[0m");
        } catch (IllegalTriangleException e) {
            System.out.println("\u001B[31mLỗi: " + e.getMessage() + "\u001B[0m");
        }
    }
    // Hàm nhập và kiểm tra từng cạnh tam giác
    public static double inputOneSide(int edge) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập cạnh " + edge + ": ");
                double side = sc.nextDouble();
                if (side <= 0) {
                    throw new IllegalTriangleException("Cạnh phải lớn hơn 0.");
                }
                return side;
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mLỗi: Vui lòng nhập số thực.\u001B[0m");
                sc.next(); // Xóa giá trị không hợp lệ khỏi bộ nhớ đệm
            } catch (IllegalTriangleException e) {
                System.out.println("\u001B[31mLỗi: " + e.getMessage() + "\u001B[0m");
            }
        }
    }
    // Hàm kiểm tra điều kiện tạo thành tam giác
    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
