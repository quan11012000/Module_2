package ss3_mang.bai_tap;
import common.ArrayCommonMethod;
public class MinArr {
    public static void main(String[] args) {
        int[][] arr = ArrayCommonMethod.inputArrTwo(2,3);
        ArrayCommonMethod.displayArrTwo(arr);
        int[] indexes = ArrayCommonMethod.minArrTow(arr);
        System.out.print("phan tu nho nhat la : ");
        System.out.println(arr[indexes[0]][indexes[1]]);
    }
}
