package ss15_ngoai_le.Illegal_triangle_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhap canh a");
            double a = sc.nextDouble();

            System.out.println("Nhap canh b");
            double b = sc.nextDouble();

            System.out.println("Nhap canh c");
            double c = sc.nextDouble();
            checkTriangle(a, b, c);
            System.out.println("\u001B[32mTam giác hợp lệ với ba cạnh: " + a + ", " + b + ", " + c + "\u001B[0m");
        }catch (InputMismatchException e){
            System.out.println("\u001B[31mLỗi: Vui lòng nhập số thực.\u001B[0m");
        }catch (IllegalTriangleException e){
            System.out.println("\u001B[31mLỗi tam giác: " + e.getMessage() + "\u001B[0m");
        }finally {
            sc.close();
            System.out.println("Kết thúc chương trình");
        }


    }
    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác phải lớn hơn 0.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
