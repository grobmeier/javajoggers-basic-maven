package com.accenture.javajoggers.animals;

import com.accenture.javajoggers.UserInputReader;
import com.accenture.javajoggers.animals.commandos.AddFishCommando;
import com.accenture.javajoggers.animals.commandos.AnimalPrinterCommando;
import com.accenture.javajoggers.animals.creators.AnimalCreator;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalApp {

    public void run() {
        System.out.println("Hallo Fremder.");
        System.out.println("Möge die Macht mit dir sein.");

        // TODO: Was kann man überhaupt machen????

        Scanner inputReader = new Scanner( System.in );

        AddFishCommando addFishCommando = new AddFishCommando();
        AnimalPrinterCommando printCommando = new AnimalPrinterCommando();

        AnimalCreator animalCreator = new AnimalCreator();
        ArrayList<Animal> fishList = animalCreator.createFish();
        ArrayList<Animal> mammals = animalCreator.createMammals();
        ArrayList<Animal> birds = animalCreator.createBirds();

        UserInputReader reader = new UserInputReader();

        boolean shouldRun = true;

        while (shouldRun) {
            String search = reader.readInput(inputReader, "Wie darf ich euch dienen?");

            if (search.equalsIgnoreCase("birds")) {
                printCommando.execute(birds);
            } else if (search.equalsIgnoreCase("add-bird")) {
                addFishCommando.execute(inputReader, "bird", birds);
            } else if (search.equalsIgnoreCase("add-fish")) {
                addFishCommando.execute(inputReader, "fish", fishList);
            } else if (search.equalsIgnoreCase("add-mammals")) {
                addFishCommando.execute(inputReader, "mammal", mammals);
            } else if (search.equalsIgnoreCase("mammals")) {
                printCommando.execute(mammals);
            } else if (search.equalsIgnoreCase("fish")) {
                printCommando.execute(fishList);
            } else if (search.equalsIgnoreCase("exit")) {
                shouldRun = false;
            } else {
                System.out.println("I don't know this");
            }
        }
    }

    public static void main(String[] args) {
        AnimalApp app = new AnimalApp();
        app.run();
    }
}
