package ss6_ke_thua.bai_tap.circleAndCylinder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Cylinder cylinder = new Cylinder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ban kinh");
        double radius =sc.nextDouble();
        sc.nextLine();
        System.out.println("nhap mau");
        String color = sc.nextLine();
        System.out.println("Nhap chieu cao");
        double height = sc.nextDouble();
        circle.setRadius(radius);
        circle.setColor(color);
        cylinder.setHeight(height);
        cylinder.setRadius(radius);
        cylinder.setColor(color);
        System.out.println(circle);
        System.out.println(cylinder);


    }
}
