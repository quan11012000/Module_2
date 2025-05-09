package ss3_mang.bai_tap;
import ss3_mang.common_method.ArrayCommonMethod;
public class MergeArr {
    public static void main(String[] args) {
        int[] arr1= ArrayCommonMethod.inputArr(5);
        int[] arr2= ArrayCommonMethod.inputArr(4);
        int[] arr12= ArrayCommonMethod.mergeArr(arr1,arr2);
        ArrayCommonMethod.displayArr(arr12);
    }
}
