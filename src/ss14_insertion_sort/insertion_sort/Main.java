package ss14_insertion_sort.insertion_sort;

import common.ArrayCommonMethod;
import ss14_insertion_sort.insertion_sort.InsertionSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = ArrayCommonMethod.inputArr(5);
        ArrayCommonMethod.displayArr(arr);
        System.out.println("-------------------");
        InsertionSort.insertionSort(arr);
        ArrayCommonMethod.displayArr(arr);
    }
}
