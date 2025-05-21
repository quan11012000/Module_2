package ss10_danh_sach.bai_tap.library_arrayslist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        display(list);
        list.add(3,5);
        display(list);
        list.remove(2);
        display(list);

    }

    public static void display(MyList<Integer> list){
        for (int i = 0 ;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
