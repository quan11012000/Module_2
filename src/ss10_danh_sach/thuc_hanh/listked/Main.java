package ss10_danh_sach.thuc_hanh.listked;

public class Main {
    public static void main(String[] args) {
        System.out.println("======/Testing========");
        MyLinkedList myLinkedList = new MyLinkedList(10);
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(11);
        myLinkedList.add(2,3);
        myLinkedList.add(2,5);
        myLinkedList.displayList();
    }
}
