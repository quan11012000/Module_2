package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap chieu cao ");
        float height = sc.nextFloat();
        System.out.println("Nhap can nang");
        float weight = sc.nextFloat();
        double bmi = weight / Math.pow(height,2);
        System.out.printf("%-10.2f%s", bmi, "Interpretation\n");
        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
