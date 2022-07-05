package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Pet;
import com.accenture.javajoggers.pets.services.PetCreatorService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContainsCommando extends Commando {

    private Connection connection;
    private Scanner scanner;

    public ContainsCommando(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("What pet do you look for?");
        String petName = scanner.nextLine();

        System.out.println("Is it a cat or a dog?");
        String animalType = scanner.nextLine();

        String sql = "select count(*) as cnt from pets where name = ? and type = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt("cnt");

        if (count > 0) {
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
