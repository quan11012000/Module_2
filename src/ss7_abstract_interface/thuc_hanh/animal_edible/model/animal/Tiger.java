package ss7_abstract_interface.thuc_hanh.animal_edible.model.animal;

import ss7_abstract_interface.thuc_hanh.animal_edible.model.animal.Animal;

public class Tiger extends Animal {

    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }
}
