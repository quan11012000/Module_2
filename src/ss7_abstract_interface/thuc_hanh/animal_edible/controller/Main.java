package ss7_abstract_interface.thuc_hanh.animal_edible.controller;
import ss7_abstract_interface.thuc_hanh.animal_edible.model.animal.Animal;
import ss7_abstract_interface.thuc_hanh.animal_edible.model.animal.Chicken;
import ss7_abstract_interface.thuc_hanh.animal_edible.model.animal.Tiger;
import ss7_abstract_interface.thuc_hanh.animal_edible.model.fruit.Apple;
import ss7_abstract_interface.thuc_hanh.animal_edible.model.fruit.Fruit;
import ss7_abstract_interface.thuc_hanh.animal_edible.model.fruit.Orange;
import ss7_abstract_interface.thuc_hanh.animal_edible.service.IEdible;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                IEdible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }

    }
}
