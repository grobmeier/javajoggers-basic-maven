package com.accenture.javajoggers.cake.commandos;

import com.accenture.javajoggers.cake.entities.Cake;
import com.accenture.javajoggers.cake.entities.CakeIngredient;
import com.accenture.javajoggers.cake.repositories.CakeRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class AddCommando implements Commando {

    private Scanner scanner;
    private CakeRepository cakeRepository;

    public AddCommando(Scanner scanner, CakeRepository cakeRepository) {
        this.scanner = scanner;
        this.cakeRepository = cakeRepository;
    }

    @Override
    public boolean execute() {
        System.out.println("What is the name of the cake?");
        String cakeName = scanner.nextLine();

        Cake cake = new Cake();
        cake.setName(cakeName);

        ArrayList<CakeIngredient> cakeIngredients = new ArrayList<>();
        CakeIngredient cakeIngredient;
        do {
            cakeIngredient = createCakeIngredient();
            cakeIngredients.add(cakeIngredient);
        } while(cakeIngredient != null);

        cake.setCakeIngredients(cakeIngredients);

        cakeRepository.addCake(cake);
        return true;
    }

    private CakeIngredient createCakeIngredient() {
        System.out.println("What is the name of the ingredient (hit enter if none)");
        String ingredientName = scanner.nextLine();

        if ("".equals(ingredientName)) {
            return null;
        }

        System.out.println("What is the amount of the ingredient");
        String ingredientAmount = scanner.nextLine();

        CakeIngredient ingredient = new CakeIngredient();
        ingredient.setIngredientName(ingredientName);
        ingredient.setAmount(Integer.parseInt(ingredientAmount));

        return ingredient;
    }

    @Override
    public boolean shouldExecute(String commando) {
        return "add".equalsIgnoreCase(commando);
    }
}
