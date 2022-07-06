package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.db.AnimalRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ContainsCommando extends Commando {

    private AnimalRepository animalRepository;
    private Scanner scanner;

    public ContainsCommando(AnimalRepository animalRepository, Scanner scanner) {
        this.animalRepository = animalRepository;
        this.scanner = scanner;
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("What pet do you look for?");
        String petName = scanner.nextLine();

        System.out.println("Is it a cat or a dog?");
        String animalType = scanner.nextLine();

        if (animalRepository.exists(petName, animalType)) {
            System.out.println("Have the pet already");
        } else {
            System.out.println("It is missing");
        }
    }

    @Override
    public boolean shouldExecute(String commandoName) {
        return "contains".equalsIgnoreCase(commandoName);
    }
}
