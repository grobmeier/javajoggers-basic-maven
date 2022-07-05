package com.accenture.javajoggers.pets.services;

import com.accenture.javajoggers.pets.Cat;
import com.accenture.javajoggers.pets.Dog;
import com.accenture.javajoggers.pets.Pet;

public class PetCreatorService {

    public Pet createPet(String petName, String animalType) {
        Pet searchPet;

        if ("cat".equalsIgnoreCase(animalType)) {
            searchPet = new Cat(petName);
        } else {
            searchPet = new Dog(petName);
        }

        searchPet.setAnimalType(animalType);
        return searchPet;
    }
}
