package ss11_stack_queue.thuc_hanh.queue_array;

public class MyQueue<E> {
    private int capacity;
    private Object queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize=0;
    public MyQueue(int capacity){
        this.capacity=capacity;
        queueArr= new  Object[this.capacity];
    }
    public boolean isQueueFull(){
        boolean status = false;
        if(currentSize == capacity){
            status=true;
        }
        return status;
    }
    public boolean isQueueEmpty(){
        boolean status = false;
        if(currentSize == 0 ){
            status=true;
        }
        return status;
    }
    public void enqueue(E item){
        if(isQueueFull()){
            System.out.println("Overflow ! Unable to add element:"+ item);
        }else{
            tail= (tail+1)%capacity;
            queueArr[tail]=item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue ! ");
        }
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow! Unable to remove element from Queue");
        } else {
            System.out.println("Pop operation done! removed: " + queueArr[head]);
            head = (head + 1) % capacity;
            currentSize--;
        }
    }

}
