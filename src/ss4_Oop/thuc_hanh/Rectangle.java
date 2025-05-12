package ss4_Oop.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    private double height;
    private double width;
    public Rectangle(){
    }
    public Rectangle(double width,double height ){
        this.height= height;
        this.width = width;
    }
    public double getArea(){
        return this.width*this.height;
    }
    public double getPerimeter(){
        return (this.height+this.width)*2;
    }
    public String display(){
        return "Rectangle{" + "width=" +width+" height="+height+"}";
    }
}
