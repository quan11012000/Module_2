package ss4_Oop.bai_tap.quadraticequation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(){

    }
    public QuadraticEquation(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant(){
        return b*b-4*a*c;
    }
    public double getRoot(){
        return -b/2*a;
    }
    public double getRoot1(){
        return (-b+Math.sqrt(getDiscriminant()))/2*a;
    }
    public double getRoot2(){
        return (-b-Math.sqrt(getDiscriminant()))/2*a;
    }
    public void solve(){
        if(a==0){
            LinearEquation linearEquation= new LinearEquation(b,c);
            linearEquation.solve();
        }else{
            if(getDiscriminant()<0){
                System.out.println("Phuong trinh vo nghiem");
            }else if(getDiscriminant()==0){
                System.out.println("Nghiem kep la: "+ getRoot());
            }else System.out.printf("Nghiep rieng biet la x1=%.2f, x2=%.2f ",getRoot1(),getRoot2());
        }
    }
}
