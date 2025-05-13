package ss4_Oop.bai_tap.stopwatch;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random random=new Random();
        for (int i =0;i<100000;i++){
            arr[i]=random.nextInt();
        }
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        selectionSort(arr);
        stopWatch.end();
        System.out.println("thoi gian sort la : "+ stopWatch.getElapsedTime());
    }
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n-1; j++) {
                if (arr[j] < arr[j+1]) {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }
}
