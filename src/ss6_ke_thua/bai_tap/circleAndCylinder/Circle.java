package ss6_ke_thua.bai_tap.circleAndCylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle(){

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double circleArea(){
        return radius*radius*Math.PI;
    }
    @Override
    public String toString(){
        String str=String.format("Ban kinh la: %.2f",radius);
        str+=String.format(" | Dien tich la: %.2f",circleArea());
        str+=String.format(" | Mau: %s",color);
        return str;
    };
}
