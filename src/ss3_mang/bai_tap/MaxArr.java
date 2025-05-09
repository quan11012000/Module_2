package ss3_mang.bai_tap;
import ss3_mang.common_method.ArrayCommonMethod;
public class MaxArr {
    public static void main(String[] args) {
        int[][] arr = ArrayCommonMethod.inputArrTwo(2,3);
        ArrayCommonMethod.displayArrTwo(arr);
        int[] indexes = ArrayCommonMethod.maxArrTow(arr);
        System.out.print("phan tu lon nhat la : ");
        System.out.println(arr[indexes[0]][indexes[1]]);


    }
}
