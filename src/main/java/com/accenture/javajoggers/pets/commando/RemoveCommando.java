package com.accenture.javajoggers.pets.commando;

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

        String sql = "delete from pets where name = ? and type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);
        preparedStatement.execute();

        System.out.println("Removed the pet");
    }


    @Override
    public boolean shouldExecute(String commandoName) {
        return "remove".equalsIgnoreCase(commandoName);
    }
}
