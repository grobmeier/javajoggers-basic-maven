package com.accenture.javajoggers.animals.creators;

import com.accenture.javajoggers.animals.Animal;

import java.util.ArrayList;

public class AnimalCreator {

    public ArrayList<Animal> createFish() {
        Animal fish1 = new Animal();
        fish1.species = "Reef Shark";
        fish1.foodType = "Carnivore";

        Animal fish2 = new Animal();
        fish2.species = "Goatfish";
        fish2.foodType = "Herbivore";

        ArrayList<Animal> fishList = new ArrayList<>();
        fishList.add(fish1);
        fishList.add(fish2);

        return fishList;
    }

    public ArrayList<Animal>  createMammals() {
        Animal mammal1 = new Animal();
        mammal1.species = "Cow";
        mammal1.foodType = "Herbivore";


        Animal mammal2 = new Animal();
        mammal2.species = "Pig";
        mammal2.foodType = "Omnivore";

        ArrayList<Animal> mammals = new ArrayList<>();
        mammals.add(mammal1);
        mammals.add(mammal2);

        return mammals;
    }

    public ArrayList<Animal>  createBirds() {

        Animal bird1 = new Animal();
        bird1.species = "Puffbird";
        bird1.species = "Herbivore";

        Animal bird2 = new Animal();
        bird2.species = "Starling";
        bird2.species = "Herbivore";

        Animal bird3 = new Animal();
        bird3.species = "Crow";
        bird3.species = "Omnivore";

        ArrayList<Animal> birds = new ArrayList<>();
        birds.add(bird1);
        birds.add(bird2);
        birds.add(bird3);

        return birds;
    }
}
