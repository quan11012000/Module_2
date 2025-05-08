package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap nam ");
        int year = sc.nextInt();
        boolean check=false;
        if((year % 4 == 0 && year % 100 !=0)|| year % 400 == 0){
            check = true;
        }
        if(check){
            System.out.println("Nam nhuan");
        }else System.out.println("Nam khong nhuan");
    }
}
