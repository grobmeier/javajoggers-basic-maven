package com.accenture.javajoggers.pets;

import java.util.ArrayList;

public class TestPetApp {

    public static void main(String[] args) {

        HUman h = new HUman("");



        PetsApp petsApp = new PetsApp();
//        petsApp.


        ArrayList<Pet> animals = new ArrayList<>();

        System.out.println("DOG");
        Dog dog = new Dog("Woflie");

        Dog dog2 = new Dog("Hans");
        Dog dog3 = new Dog("Felix");
        Cat cat = new Cat("Maunzi");
        cat.name = "";

        ArrayList animals2 = new ArrayList();
        animals2.add(dog);
        animals2.add(cat);
        animals2.add("String");

        for (Object o : animals2) {
            if (o instanceof Pet) {
                Pet p1 = (Pet)o;
                p1.makeSound();
            }
        }

        for (Pet animal : animals) {
            animal.makeSound();
        }


        Pet a = cat; // (implicit) Upcast
        Pet b = (Pet)cat; // explicit Upcast

        animals.add(dog);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(cat);
        print(animals);
    }

    public static void print(ArrayList<Pet> animals) {
        for (Pet animal : animals) {
            // when cat dann alarm!!!

            if (animal instanceof Cat) {
                System.out.println("alarm");
                Cat cat = (Cat)animal; // (explicit) Downcast
                cat.snuggle();
            }

            animal.breathe();
            animal.makeSound();
        }
    }

}
