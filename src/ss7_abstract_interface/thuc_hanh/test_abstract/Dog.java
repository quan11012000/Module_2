package ss7_abstract_interface.thuc_hanh.test_abstract;

public class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name+" says: Woof!");
    }
}
