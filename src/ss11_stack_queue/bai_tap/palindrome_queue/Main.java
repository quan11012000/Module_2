package ss11_stack_queue.bai_tap.palindrome_queue;
import ss11_stack_queue.bai_tap.reverse_stack.GenericStackClient;
import ss11_stack_queue.bai_tap.reverse_stack.MyGenericStack;
import ss11_stack_queue.thuc_hanh.queue_array.MyQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        str=str.toLowerCase();
        Stack<Character> chrStack = new Stack<>();
        Queue<Character> chrQueue = new ArrayDeque<>();
        for(int i = 0 ; i<str.length();i++){
            chrStack.push(str.charAt(i));
            chrQueue.add(str.charAt(i));
        }
        boolean ok=true;
        while (!chrQueue.isEmpty()){
            if(chrQueue.remove() != chrStack.pop()){
                ok =false;
                break;
            }
        }


        if(ok){
            System.out.println("chuỗi Palindrome");
        }else System.out.println("khong phai chuỗi Palindrome");
    }

}
