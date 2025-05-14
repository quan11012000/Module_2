package ss5_accsess_modifier.bai_tap.circle;

import common.ValidateInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double radius;
        Scanner sc=new Scanner(System.in);
        radius=ValidateInput.inputDouble(sc,"Nhap ban kinh: ");
        Circle circle = new Circle(radius);
        System.out.println("ban kinh la : "+ circle.getRadius());
        System.out.printf("dien tich la :%.2f ", circle.getArea());


    }
}
