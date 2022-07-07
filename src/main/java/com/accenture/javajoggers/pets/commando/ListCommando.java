package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Pet;
import com.accenture.javajoggers.pets.db.AnimalRepository;
import com.accenture.javajoggers.pets.db.AnimalRepositoryException;

import java.sql.SQLException;
import java.util.List;

public class ListCommando extends Commando {

    private AnimalRepository animalRepository;

    public ListCommando(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public boolean execute() throws AnimalRepositoryException {
        List<Pet> pets = animalRepository.readAnimals();

        for (Pet pet : pets) {
            System.out.println("Pet:" + pet.getId() + " -> " + pet.getName() + ", Type: " + pet.getAnimalType());
            pet.makeSound();
        }
        return true;
    }

    @Override
    public boolean shouldExecute(String commandoName) {
        return "list".equalsIgnoreCase(commandoName);
    }
}
