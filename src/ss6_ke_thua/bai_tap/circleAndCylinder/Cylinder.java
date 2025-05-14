package ss6_ke_thua.bai_tap.circleAndCylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){

    }
    public Cylinder(double height) {
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double cylindricalVolume(){
        return circleArea()*height;
    }
    @Override
    public String toString(){
        String str=String.format("Ban kinh la: %.2f | Chieu cao la: %.2f",getRadius(),height);
        str+=String.format(" | The tich la: %.2f",cylindricalVolume());
        str+=String.format(" | Mau : %s",getColor());
        return str;
    };
}
