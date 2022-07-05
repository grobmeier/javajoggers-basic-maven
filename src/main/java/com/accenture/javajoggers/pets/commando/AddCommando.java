package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Pet;
import com.accenture.javajoggers.pets.services.PetCreatorService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddCommando extends Commando {

    private Connection connection;
    private Scanner scanner;

    public AddCommando(Connection connection, final Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    @Override
    public void execute() throws SQLException {

        System.out.println("Add a pet");
        System.out.println("What is the pets name?");
        String petName = scanner.nextLine();

        System.out.println("Is it a cat or a dog?");
        String animalType = scanner.nextLine();

        String sql = "insert into pets (name, type) values (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);
        preparedStatement.execute();

    }

    @Override
    public boolean shouldExecute(String commandoName) {
        return "add".equalsIgnoreCase(commandoName);
    }
}
