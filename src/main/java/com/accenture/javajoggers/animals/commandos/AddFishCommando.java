package com.accenture.javajoggers.animals.commandos;

import com.accenture.javajoggers.animals.Animal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Blablabla
 */
public class AddFishCommando {
    public void execute(Scanner inputReader, String animalType, ArrayList<Animal> animalList) {
        System.out.println("Adding a " + animalType);
        System.out.println("What is the name of the " + animalType + "?");
        String fishName = inputReader.nextLine();
        System.out.println("What does the "+ animalType +" eat?");
        String foodType = inputReader.nextLine();

        Animal animal = new Animal();
        animal.foodType = foodType;
        animal.species = fishName;

        animalList.add(animal);
    }
}
