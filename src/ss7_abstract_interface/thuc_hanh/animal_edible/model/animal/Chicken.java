package ss7_abstract_interface.thuc_hanh.animal_edible.model.animal;

import ss7_abstract_interface.thuc_hanh.animal_edible.model.animal.Animal;
import ss7_abstract_interface.thuc_hanh.animal_edible.service.IEdible;

public class Chicken extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
    @Override
    public String howToEat(){
        return "could be fried";
    }
}
