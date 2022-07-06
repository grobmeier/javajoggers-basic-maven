package com.accenture.javajoggers.pets.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalRepository {

    private Connection connection;

    public AnimalRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean exists(String petName, String animalType) throws SQLException {
        String sql = "select count(*) as cnt from pets where name = ? and type = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt("cnt");

        return (count > 0);
    }

    public void removeAnimal(String petName, String animalType) throws SQLException {
        String sql = "delete from pets where name = ? and type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);
        preparedStatement.execute();
    }
}
