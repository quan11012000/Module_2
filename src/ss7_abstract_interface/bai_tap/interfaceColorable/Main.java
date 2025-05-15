package ss7_abstract_interface.bai_tap.interfaceColorable;

import ss7_abstract_interface.bai_tap.interfaceResizeable.Circle;
import ss7_abstract_interface.bai_tap.interfaceResizeable.Rectangle;
import ss7_abstract_interface.bai_tap.interfaceResizeable.Shape;
import ss7_abstract_interface.bai_tap.interfaceResizeable.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] arr ={
                new Circle(2,"blue",true),
                new Rectangle(5,3,"red",false),
                new Square(3,"white",true)
        };
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
            if(arr[i] instanceof Colorable){
                ((Colorable) arr[i]).howToColor();
            }
            System.out.println();
        }
    }

}
