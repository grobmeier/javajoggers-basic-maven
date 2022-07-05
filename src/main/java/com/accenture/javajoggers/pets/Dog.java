package com.accenture.javajoggers.pets;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
        this.animalType = "Dog";
    }

    public Dog() {
        super(null);
    }

    @Override
    public void makeSound() {
        System.out.println("Wuff wuff wuff");
    }

}
