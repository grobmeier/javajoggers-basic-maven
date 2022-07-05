package com.accenture.javajoggers.animals.commandos;

import com.accenture.javajoggers.animals.Animal;

import java.util.ArrayList;

public class AnimalPrinterCommando {
    public void execute(ArrayList<Animal> animals) {
        for (Animal animal: animals) {
            System.out.println("Animal: " + animal.species + ", " + animal.foodType);
        }
    }
}
