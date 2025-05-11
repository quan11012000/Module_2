package ss3_mang.common_method;
import java.util.Scanner;

public class ArrayCommonMethod {
    public static void displayArr(int[] arr) {
        System.out.print("Mang cua ban la: ");
        for (int a : arr) {

            System.out.print(a + " ");
        }
    }

    public static int[] inputArr(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("nhap phan tu thu " + i);
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int[][] inputArrTwo(int n, int m) {
        int[][] arr = new int[n][m];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("nhap phan tu thu :[%d][%d]",i,j);
                arr[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        return arr;
    }

    public static void displayArrTwo(int[][] arr) {
        System.out.println("Mang cua ban la: ");
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[] mergeArr(int[] array1, int[] array2) {
        int[] mergeArr = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, mergeArr, 0, array1.length);
        System.arraycopy(array2, 0, mergeArr, array1.length, array2.length);
        return mergeArr;
    }

    public static int maxArr(int[] array) {
        int max = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (max <= array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int[] maxArrTow(int[][] array) {
        int max = array[0][0];
        int indexRow = 0;
        int indexCol = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max <= array[i][j]) {
                    max = array[i][j];
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        return new int[]{indexRow, indexCol};
    }

    public static int[] minArrTow(int[][] array) {
        int min = array[0][0];
        int indexRow = 0;
        int indexCol = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                    indexRow = i;
                    indexCol = j;

                }
            }
        }
        return new int[]{indexRow, indexCol};
    }

    public static int minArr(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
    public static int sumArr(int n){
        int sum=0;
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static int sumColArrTwo(int[][] arr){
        int sum=0;
        Scanner sc = new Scanner(System.in);
        int column;
        do{
            System.out.println("nhap so cot can tinh tong");
            column =sc.nextInt();
        }while (column <0 || column >=arr[0].length);
        for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    if(j==column)
                        sum+=arr[i][j];
                }
        }

        System.out.printf ("tong cot thu %d la : ",column);
        return sum;
    }
}