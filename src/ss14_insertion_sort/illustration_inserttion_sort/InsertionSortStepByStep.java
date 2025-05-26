package ss14_insertion_sort.illustration_inserttion_sort;

import common.ArrayCommonMethod;

public class InsertionSortStepByStep {
    public static void insertionSort(int[] arr) {
        int pos;
        int x;
        ArrayCommonMethod.displayArr(arr);
        System.out.println("-----------------");
        for (int i = 1; i < arr.length; i++) {
            x=arr[i];
            pos = i;
            int j = i - 1;
            System.out.println("Vòng lặp i = " + i + ", key = " + x);
            while (pos > 0 && arr[pos - 1] > x) {
                System.out.println("  So sánh arr[" + j + "] = " + arr[i-1] + " > key = " + x + " => dịch arr[" + j + "] sang phải");
                arr[pos]=arr[pos-1];
                pos--;
            }
            arr[pos] = x;
            System.out.println("  Chèn key vào vị trí " + (pos));
            printArray(arr);
            System.out.println("---------------------");
        }
        System.out.println("Mảng đã được sắp xếp:");
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
