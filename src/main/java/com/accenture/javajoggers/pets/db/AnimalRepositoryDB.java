package com.accenture.javajoggers.pets.db;

import com.accenture.javajoggers.pets.Cat;
import com.accenture.javajoggers.pets.Dog;
import com.accenture.javajoggers.pets.Pet;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepositoryDB implements AnimalRepository {

    private Connection connection;

    public AnimalRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    @Override
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

    @Override
    public List<Pet> readAnimals() throws SQLException {
        ArrayList<Pet> result = new ArrayList<>();

        String sql = "select * from pets";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");

            Pet pet = null;
            if ("dog".equalsIgnoreCase(type)) {
                pet = new Dog(name);
                pet.setAnimalType(type);
                pet.setId(id);
            } else if ("cat".equalsIgnoreCase(type)) {
                pet = new Cat(name);
                pet.setId(id);
                pet.setAnimalType(type);
            }
            result.add(pet);
        }

        return result;
    }

    @Override
    public void addPet(String petName, String animalType) throws SQLException {
        String sql = "insert into pets (name, type) values (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);
        preparedStatement.execute();
    }

    @Override
    public void removeAnimal(String petName, String animalType) throws SQLException {
        String sql = "delete from pets where name = ? and type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, petName);
        preparedStatement.setString(2, animalType);
        preparedStatement.execute();
    }
}
