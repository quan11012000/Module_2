package ss7_abstract_interface.bai_tap.interfaceResizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    /*@Override
    public String toString() {
        return "A Rectangle with width= "
                + String.format("%.2f", getWidth())      // làm tròn width
                + " and length= "
                + String.format("%.2f", getLength())     // làm tròn length
                + " | Area= "
                + String.format("%.2f", getArea());
                // làm tròn diện tích
    }
               // + ", which is a subclass of "
                //+ super.toString();*/
    @Override
    public void resize(int percent) {
        width = width+ (width*percent/100);
        length = length + (length*percent/100);
    }
}
