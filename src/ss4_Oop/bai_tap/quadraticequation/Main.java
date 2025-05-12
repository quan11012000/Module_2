package ss4_Oop.bai_tap.quadraticequation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        a=sc.nextDouble();
        System.out.print("Nhap b: ");
        b=sc.nextDouble();
        System.out.print("Nhap c: ");
        c=sc.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        quadraticEquation.solve();

    }
}
