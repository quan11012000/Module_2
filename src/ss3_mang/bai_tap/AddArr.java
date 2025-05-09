package ss3_mang.bai_tap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddArr {
    public static void main(String[] args) {
        int[] arr = inputArr(5);
        Scanner sc = new Scanner(System.in);
        displayArr(arr);
        System.out.println("nhap gia tri chen");
        int valueAdd= sc.nextInt();
        System.out.println("nhap vi tri can chen");
        int index = sc.nextInt();
        if(index<0||index>arr.length){
            displayArr(arr);
            return;
        }else{
            int[] arrs = new int[arr.length+1];
            for(int i=0,j=0;i<arrs.length;i++){
                if(i == index) {
                    arrs[i]=valueAdd;
                }else{
                    arrs[i]= arr[j++];
                }
            }
            displayArr(arrs);
        }
    }
    public static void displayArr(int[] arr){
        System.out.print("Mang cua ban la: ");
        for (int a:arr) {

            System.out.print(a+" ");
        }
    }
    public static int[] inputArr(int n){
        Scanner sc = new Scanner(System.in);
        int[] arr= new int[n];
        for(int i =0;i<n;i++){
            System.out.println("nhap phan tu thu "+i);
            arr[i]=sc.nextInt();
        }
        return arr;
    }
}
