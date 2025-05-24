package ss13_thuat_toan.bai_tap.binary_tree;

import common.ArrayCommonMethod;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array= ArrayCommonMethod.inputArr(5);
        Scanner sc= new Scanner(System.in);
        int value = sc.nextInt();
        int foundIndex=RecursiveBinarySearch.binarySearch(array,0,array.length-1,value);
        if(foundIndex==-1){
            System.out.println("khong tim thay");
        }else{
            System.out.printf("tim thấy giá trị %d tai vị trí %d ",value,foundIndex);
        }
    }
}
