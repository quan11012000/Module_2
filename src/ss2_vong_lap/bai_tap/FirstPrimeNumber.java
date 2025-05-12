package ss2_vong_lap.bai_tap;
import ss2_vong_lap.bai_tap.number.Numeric;

import java.util.Scanner;

public class FirstPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so luong so nguyen to : ");
        int number= sc.nextInt();
        int i=2;
        while (number>0){
            if(Numeric.isPrimeNumber(i)){
                System.out.println(i);
                number--;
            }
            i++;
        }
    }

}
