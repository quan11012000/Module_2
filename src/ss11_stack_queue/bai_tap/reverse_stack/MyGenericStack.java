package ss11_stack_queue.bai_tap.reverse_stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    LinkedList<T> stack;
    public MyGenericStack(){
        stack = new LinkedList();
    }
    public boolean isEmpty(){
        if(stack.size()==0){
            return true;
        }
        return false;
    }
    public void push(T element){
        stack.addFirst(element);
    }
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public int size(){
        return stack.size();
    }

}
