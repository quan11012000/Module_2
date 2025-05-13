package ss5_accsess_modifier.bai_tap.circle;

public class Circle {
    private double radius=1.0;
    private String Color="red";
    public Circle() {
    }

    public Circle(double r) {
        this.radius=r;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
}
