package ss3_mang.bai_tap;
import java.util.Scanner;

public class DeleteArr {
    public static void main(String[] args) {
        int[] arr = inputArr(5);
        int[] arrs;
        byte count = 0 ;
        Scanner sc = new Scanner(System.in);
        displayArr(arr);
        System.out.println("nhap gia tri can xoa");
        int valueDelete= sc.nextInt();
        for(int i = 0 ; i<arr.length;i++){
            if (arr[i]==valueDelete) count++;
        }
        if(count>0){
             arrs = new  int[arr.length-1];
        }else {
             arrs = new  int[arr.length];
        }
        for(int i=0,j=0;i<arr.length;i++){
            if(arr[i]==valueDelete) continue;
            arrs[j++]= arr[i];
        }
        displayArr(arrs);
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
