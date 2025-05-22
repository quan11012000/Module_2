package ss11_stack_queue.bai_tap.convert_to_binary;
import ss11_stack_queue.thuc_hanh.stack.MyGenericStack;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so ban can chuyen qua he nhi phan");
        int number = sc.nextInt();
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        while (number>0){
            stack.push(number%2);
            number=number/2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
