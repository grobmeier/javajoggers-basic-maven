package com.accenture.javajoggers.cake.entities;

public class CakeIngredient {
    private int id;
    private String ingredientName;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CakeIngredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
