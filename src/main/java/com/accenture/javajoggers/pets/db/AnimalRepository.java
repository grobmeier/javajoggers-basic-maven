package com.accenture.javajoggers.pets.db;

import com.accenture.javajoggers.pets.Pet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AnimalRepository extends A, B {

    boolean exists(String petName, String animalType) throws SQLException;

    List<Pet> readAnimals() throws SQLException;

    void addPet(String petName, String animalType) throws SQLException;

    void removeAnimal(String petName, String animalType) throws SQLException;
}
