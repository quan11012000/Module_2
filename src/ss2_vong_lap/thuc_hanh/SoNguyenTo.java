package ss2_vong_lap.thuc_hanh;


import java.util.Scanner;

public class SoNguyenTo {
    public static boolean soNguyenTo(int n){
        if(n<2){
            return false;
        }else{
            for (int i=2 ; i<= Math.sqrt(n);i++){
                if(n%i==0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so");
        int n = sc.nextInt();
        System.out.println(soNguyenTo(n));
    }
}
