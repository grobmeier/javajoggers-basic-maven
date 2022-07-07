package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.db.AnimalRepository;
import com.accenture.javajoggers.pets.db.AnimalRepositoryDB;
import com.accenture.javajoggers.pets.db.AnimalRepositoryException;

import java.sql.SQLException;
import java.util.Scanner;

public class AddCommando extends Commando {

    private AnimalRepository animalRepository;
    private Scanner scanner;

    public AddCommando(AnimalRepository animalRepository, final Scanner scanner) {
        this.animalRepository = animalRepository;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() throws AnimalRepositoryException {

        System.out.println("Add a pet");
        System.out.println("What is the pets name?");
        String petName = scanner.nextLine();

        System.out.println("Is it a cat or a dog?");
        String animalType = scanner.nextLine();

        animalRepository.addPet(petName, animalType);
        return true;
    }


    @Override
    public boolean shouldExecute(String commandoName) {
        return "add".equalsIgnoreCase(commandoName);
    }
}
