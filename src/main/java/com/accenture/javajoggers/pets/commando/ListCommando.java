package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Pet;
import com.accenture.javajoggers.pets.db.AnimalRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class ListCommando extends Commando {

    private AnimalRepository animalRepository;

    public ListCommando(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void execute() throws SQLException {
        ArrayList<Pet> pets = animalRepository.readAnimals();

        for (Pet pet : pets) {
            System.out.println("Pet:" + pet.getId() + " -> " + pet.getName() + ", Type: " + pet.getAnimalType());
            pet.makeSound();
        }
    }

    @Override
    public boolean shouldExecute(String commandoName) {
        return "list".equalsIgnoreCase(commandoName);
    }
}
