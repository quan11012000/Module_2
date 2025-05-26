package ss14_insertion_sort.insertion_sort;

import common.ArrayCommonMethod;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int pos;
        int x;
        for (int i = 1; i < arr.length; i++) {
            x=arr[i];
            pos = i;
            while (pos > 0 && arr[pos - 1] > x) {
                arr[pos]=arr[pos-1];
                pos--;
            }
            arr[pos] = x;
            System.out.println("--------");
            ArrayCommonMethod.displayArr(arr);
        }
    }
}




