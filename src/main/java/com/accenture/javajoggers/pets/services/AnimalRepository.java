package com.accenture.javajoggers.pets.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalRepository {

    private Connection connection;

    public AnimalRepository(Connection connection) {
        this.connection = connection;
    }


    public void removeAnimal(String petName, String animalType) throws SQLException {
        String sql = "delete from pets where name = ? and type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);
        preparedStatement.execute();
    }
}
