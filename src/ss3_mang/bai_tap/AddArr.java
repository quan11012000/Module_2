package ss3_mang.bai_tap;
import java.util.Scanner;
import ss3_mang.common_method.ArrayCommonMethod;

public class AddArr {
    public static void main(String[] args) {
        int[] arr = ArrayCommonMethod.inputArr(5);
        Scanner sc = new Scanner(System.in);
        ArrayCommonMethod.displayArr(arr);
        System.out.println("nhap gia tri chen");
        int valueAdd= sc.nextInt();
        System.out.println("nhap vi tri can chen");
        int index = sc.nextInt();
        if(index<0||index>arr.length){
            ArrayCommonMethod.displayArr(arr);
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
            ArrayCommonMethod.displayArr(arrs);
        }
    }

}
