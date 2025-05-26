package ss14_insertion_sort.illustration_inserttion_sort;

import common.ArrayCommonMethod;

public class Main {
    public static void main(String[] args) {
        int[] arr = ArrayCommonMethod.inputArr(5);
        InsertionSortStepByStep.insertionSort(arr);
    }
}
