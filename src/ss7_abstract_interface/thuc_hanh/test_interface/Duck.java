package ss7_abstract_interface.thuc_hanh.test_interface;

public class Duck implements Flyable,Swimmable{
    @Override
    public void fly(){
        System.out.println("Duck is flying!");
    }
    @Override
    public void swim(){
        System.out.println("Duck is swimming!");
    }
}
