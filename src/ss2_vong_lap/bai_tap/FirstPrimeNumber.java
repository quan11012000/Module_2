package ss2_vong_lap.bai_tap;

import java.util.Scanner;

public class FirstPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so luong so nguyen to : ");
        int number= sc.nextInt();
        int i=2;
        while (number>0){
            if(prime(i)){
                System.out.println(i);
                number--;
                i++;
                continue;
            }else i++;
        }
    }
    public static boolean prime(int number){
        if(number<2){
            return false;
        }else{
            for (int i=2 ; i<= Math.sqrt(number);i++){
                if(number%i==0) return false;
            }
        }
        return true;
    }
}
