package ss4_Oop.bai_tap.quadraticequation;

public class LinearEquation {
    private double a;
    private double b;

    public LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    public void solve(){
        if(a==0){
            if(b==0){
                System.out.println("Phuong trinh vo so nghiem");
            }else System.out.println("Phuong trinh vo nghiem");
        }else{
            System.out.println("Nghiem cua phuong trinh la: "+ (-b/a));
        }
    }
}
