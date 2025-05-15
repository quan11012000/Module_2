package ss7_abstract_interface.thuc_hanh.test_abstract;

abstract class Animal {
    String name;
    Animal(String name){
        this.name= name;
    }
    abstract void makeSound();
    void sleep(){
        System.out.println(name+" is sleep");
    }
}

