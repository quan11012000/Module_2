package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class PhuongTrinhBacNhat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a va b");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        if(a==0){
            System.out.println("phuong trinh vo nghiem ");
        }else if(b==0){
            System.out.println("phuong trinh vo so nghiem");
        }else System.out.println("phuong trinh co nghiem la "+((-b)/a));

    }
}
