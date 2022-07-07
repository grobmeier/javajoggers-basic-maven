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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepositoryDB implements AnimalRepository {

    private Connection connection;

    public AnimalRepositoryDB(Connection connection) {
        if (connection == null) {
            IllegalArgumentException ei = new IllegalArgumentException();
            throw ei;
        }

        this.connection = connection;
    }

    @Override
    public boolean exists(String petName, String animalType) throws AnimalRepositoryException {
        String sql = "selectAAAAAAA count(*) as cnt from pets where name = ? and type = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, petName);
            preparedStatement.setString(2, animalType);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("cnt");
            return (count > 0);
        } catch (SQLException ex) {
            throw new AnimalRepositoryException("SQL caused a problem");
        }
    }

    @Override
    public List<Pet> readAnimals() throws AnimalRepositoryException {
        ArrayList<Pet> result = new ArrayList<>();

        String sql = "select * from pets";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            // time in ms since 1.1.1970
            long time = timestamp.getTime() / 1000;

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
        } catch(SQLException ex) {
            throw new AnimalRepositoryException(ex.getMessage());
        }
    }

    @Override
    public void addPet(String petName, String animalType) throws AnimalRepositoryException {
        String sql = "insert into pets (name, type) values (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, petName);
            preparedStatement.setString(2, animalType);
            preparedStatement.execute();
        } catch (SQLException ex) {
            throw new AnimalRepositoryException("Add pet failed", ex);
        }
    }

    @Override
    public void removeAnimal(String petName, String animalType) throws AnimalRepositoryException {
        String sql = "delete from pets where name = ? and type = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, petName);
            preparedStatement.setString(2, animalType);
            preparedStatement.execute();
        } catch (SQLException ex) {
            throw new AnimalRepositoryException("remove animal failed", ex);
        }
    }
}
