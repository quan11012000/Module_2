package ss14_insertion_sort.minhhoa;

import ss14_insertion_sort.insertion_sort.InsertionSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = inputInt(3, 50);
        System.out.println("Initial array: ");
        for (int j : arr) System.out.print(j + "\t");
        System.out.println();
        InsertionSort.insertionSort(arr);
        System.out.println("\nSorted array: ");
        for (int j : arr) System.out.print(j + "\t");
    }
    public static int[] inputInt(int min, int max, String message, String subMessage) {
        Scanner sc = new Scanner(System.in);
        int[] array;
        int size = inputNumOfElement(min, max, message);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print(subMessage + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static int[] inputInt(int min, int max) {
        return inputInt(min, max, "Nhập số lượng phần tử của mảng: ", "Nhập phần tử thứ ");
    }
    private static int inputNumOfElement(int min, int max, String message) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.print(message);
            number = sc.nextInt();
            if (number < min) {
                System.out.printf("Số lượng không được nhỏ hơn %d\n", min);
            } else if (number > max) {
                System.out.printf("Số lượng không được vượt quá %d\n", max);
            }
        } while (number < min || number > max);
        return number;
    }
}
