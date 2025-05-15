package ss7_abstract_interface.bai_tap.interfaceResizeable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Shape[] arr ={
            new Circle(2,"blue",true),
            new Rectangle(5,3,"red",false),
            new Square(3,"white",true)
        };
        for(int i = 0 ;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("-------------------------------------");
        for(int i = 0 ; i <arr.length;i++){
            int randomValue = (int) (Math.random() * 100);
            if(arr[i] instanceof Circle){
                ((Circle) arr[i]).resize(randomValue);
            }else if(arr[i] instanceof Square){
                ((Square) arr[i]).resize(randomValue);
            }else if(arr[i] instanceof Rectangle){
                ((Rectangle) arr[i]).resize(randomValue);
            }
            System.out.println(arr[i]);
        }
    }
}
