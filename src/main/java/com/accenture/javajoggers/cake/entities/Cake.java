package com.accenture.javajoggers.cake.entities;

import java.util.ArrayList;

public class Cake {

    private int id;
    private String name;
    ArrayList<CakeIngredient> cakeIngredients = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CakeIngredient> getCakeIngredients() {
        return cakeIngredients;
    }

    public void setCakeIngredients(ArrayList<CakeIngredient> cakeIngredients) {
        this.cakeIngredients = cakeIngredients;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cakeIngredients=" + cakeIngredients +
                '}';
    }
}
