package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.services.AnimalRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveCommando extends Commando {

    private Connection connection;
    private Scanner scanner;

    public RemoveCommando(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("What pet do you want to remove?");
        String petName = scanner.nextLine();

        System.out.println("Is it a cat or a dog?");
        String animalType = scanner.nextLine();

        new AnimalRepository(connection).removeAnimal(petName, animalType);

        System.out.println("Removed the pet");
    }



    @Override
    public boolean shouldExecute(String commandoName) {
        return "remove".equalsIgnoreCase(commandoName);
    }
}
