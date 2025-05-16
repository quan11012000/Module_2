package ss13_thuat_toan.thuc_hanh;

import common.ArrayCommonMethod;

public class SumArr {
    public static void main(String[] args) {
        int[] arr= ArrayCommonMethod.inputArr(5);
        int sum = ArrayCommonMethod.sumArrRecursive(arr,arr.length);
        System.out.println(sum);
    }
}
