package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args){
        float width;
        float height;
        float area;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chiều rộng là ");
        width = scanner.nextFloat();
        System.out.println("Chiều cao là ");
        height = scanner.nextFloat();
        area= width*height;
        System.out.println("dien tich hinh chu nhat la "+ area );
    }
}
