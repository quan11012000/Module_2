package ss11_stack_queue.bai_tap.reverse_stack;

import common.ArrayCommonMethod;
import ss11_stack_queue.thuc_hanh.stack.MyGenericStack;

import java.util.Arrays;

public class GenericStackClient {

    private static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack();
        int[] arr= ArrayCommonMethod.inputArr(5);
        for(int i =0;i<arr.length;i++){
            stack.push(arr[i]);
        }
        System.out.println("mang ban dau la : "+ Arrays.toString(arr));
        int index = 0;
        while (!stack.isEmpty()){
            arr[index] = stack.pop();
            index++;
        }
        System.out.println("mang dao nguoc la : "+ Arrays.toString(arr));


    }
    private static void stackOfString() {
        MyGenericStack<String> stack = new MyGenericStack();
        String str = "đi. quá trai đẹp Quân anh ơi, trời Ôi";
        String[] arrStr = str.split(" ");
        for(int i = 0 ; i <arrStr.length;i++){
            stack.push(arrStr[i]);
        }
        System.out.println("chuoi chua ban dau la: "+str);
        int index=0;
        while (!stack.isEmpty()){
            arrStr[index] = stack.pop();
            index++;
        }
        System.out.println("chuoi dao nguoc la: "+String.join(" ",arrStr));





    }
    public static void main(String[] args) {

        stackOfIntegers();
        System.out.println("------test----------");
        stackOfString();
    }
}
