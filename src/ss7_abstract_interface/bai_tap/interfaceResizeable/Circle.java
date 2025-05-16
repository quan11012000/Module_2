package ss7_abstract_interface.bai_tap.interfaceResizeable;
public class Circle extends Shape implements Resizeable {

    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius= "
                + String.format("%.2f", getRadius())  // làm tròn 2 chữ số sau dấu phẩy
                + " | Area= "
                + String.format("%.2f", getArea());
    }
               // + ", which is a subclass of "
                //+ super.toString();


    @Override
    public void resize(int percent) {
        radius = radius+(radius*percent/100);
    }
}