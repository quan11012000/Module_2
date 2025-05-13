package ss3_mang.bai_tap;
import java.util.Scanner;
import common.ArrayCommonMethod;

public class DeleteArr {
    public static void main(String[] args) {
        int[] arr = ArrayCommonMethod.inputArr(5);
        int[] arrs;
        byte count = 0 ;
        Scanner sc = new Scanner(System.in);
        ArrayCommonMethod.displayArr(arr);
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
        ArrayCommonMethod.displayArr(arrs);
    }

}
