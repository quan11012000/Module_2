package ss4_Oop.bai_tap.fan;

public class Fan {
    static final int SLOW=1;
    static final int MEDIUM = 2;
    static final int FAST = 3;
    int speed = SLOW;
    boolean on;
    double radius;
    String color;

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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
    public Fan(){
    }
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    @Override
    public String toString() {
        if(on){
            return "Fan{" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    ", fan is on" +
                    '}';
        }else{
            return "Fan{" +
                    "radius=" + radius +
                    ", color='" + color + '\'' +
                    ", fan is off" +
                    '}';
        }

    }
}
