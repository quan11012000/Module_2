package ss3_mang.bai_tap;
import ss3_mang.common_method.ArrayCommonMethod;

import java.util.Scanner;

public class DiagonalMain {
    public static void main(String[] args) {
        int length;
        int sum=0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Nhap canh cua manh : ");
            length= sc.nextInt();
        }while(length<0||length>=1000);
        int[][] arr = ArrayCommonMethod.inputArrTwo(length,length);
        ArrayCommonMethod.displayArrTwo(arr);
        for(int i =0;i<length;i++){
            for(int j = 0; j<length;j++){
                if(i==j){
                    sum+=arr[i][j];
                }
            }
        }
        System.out.println("Tong duong cheo chinh la : "+ sum);
    }
}
