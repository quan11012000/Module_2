package ss3_mang.bai_tap;
import ss3_mang.common_method.ArrayCommonMethod;
public class SumColArr {
    public static void main(String[] args) {
        int[][] arr = ArrayCommonMethod.inputArrTwo(3,2);
        ArrayCommonMethod.displayArrTwo(arr);
        int sum = ArrayCommonMethod.sumColArrTwo(arr);
        System.out.print(sum);
    }
}
