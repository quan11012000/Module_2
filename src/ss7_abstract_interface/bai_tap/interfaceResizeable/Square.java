package ss7_abstract_interface.bai_tap.interfaceResizeable;


import ss7_abstract_interface.bai_tap.interfaceColorable.Colorable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }
    @Override
    public String toString() {
        return "A Square with side= "
                + String.format("%.2f", getSide())   // 2 chữ số thập phân
                + " | Area= "
                + String.format("%.2f", getArea());
                //+ ", which is a subclass of "
               // + super.toString();
    }
    @Override
    public void howToColor(){
        System.out.print(" | Color all four sides.");
    }
}