package ss4_Oop.bai_tap.quadraticequation;
import common.ValidateInput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        Scanner sc = new Scanner(System.in);
        a=ValidateInput.inputDouble(sc,"Nhap a: ");
        b=ValidateInput.inputDouble(sc,"Nhap b: ");
        c=ValidateInput.inputDouble(sc,"Nhap c: ");
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        quadraticEquation.solve();
    }
}
