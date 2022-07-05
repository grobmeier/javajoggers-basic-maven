package com.accenture.javajoggers.pets;

public class Cat extends Pet {


    public Cat() {
        // Constructor chaining
        this("");

    }

    public Cat(String name) {
        // hier wird automatisch der Pet Konstruktor aufgerufen
        super(name);


    }



    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public void makeSound() {
        System.out.println("Miau Miau");
    }

    public void snuggle() {
        System.out.println("miaaaaaaaaaaaaaau");
    }


    public void snuggle(Object timeout) {
        System.out.println("miaaaaaaaaaaaaaau with a human");
    }
}
