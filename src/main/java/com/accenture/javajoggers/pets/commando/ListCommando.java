package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Cat;
import com.accenture.javajoggers.pets.Dog;
import com.accenture.javajoggers.pets.Pet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListCommando extends Commando {

    private Connection connection;

    public ListCommando(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() throws SQLException {
        String sql = "select * from pets";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");

            Pet result = null;
            if ("dog".equals(type)) {
                result = new Dog(name);
                result.setAnimalType(type);
            } else if ("cat".equals(type)){
                result = new Cat(name);
                result.setAnimalType(type);
            }

            System.out.println("Pet:" + result.getName() + ", Type: " + result.getAnimalType());
            result.makeSound();
        }
    }

    @Override
    public boolean shouldExecute(String commandoName) {
        return "list".equalsIgnoreCase(commandoName);
    }
}
