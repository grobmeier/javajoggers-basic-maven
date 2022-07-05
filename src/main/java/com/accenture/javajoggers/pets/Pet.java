package com.accenture.javajoggers.pets;

import java.util.Objects;

public class Pet {

    protected int id;
    protected String name;
    protected String animalType;

    public Pet(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void breathe() {
        System.out.println("hech hech hech hech");
    }

    public void makeSound() {
        System.out.println("...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", animalType='" + animalType + '\'' +
                '}';
    }
}
