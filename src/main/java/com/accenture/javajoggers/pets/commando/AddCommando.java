package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.db.AnimalRepository;

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
    public void execute() throws SQLException {

        System.out.println("Add a pet");
        System.out.println("What is the pets name?");
        String petName = scanner.nextLine();

        System.out.println("Is it a cat or a dog?");
        String animalType = scanner.nextLine();

        animalRepository.addPet(petName, animalType);
    }


    @Override
    public boolean shouldExecute(String commandoName) {
        return "add".equalsIgnoreCase(commandoName);
    }
}
