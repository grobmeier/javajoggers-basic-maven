package com.accenture.javajoggers.cake.commandos;

import com.accenture.javajoggers.cake.entities.Cake;
import com.accenture.javajoggers.cake.repositories.CakeRepository;

import java.util.List;

public class ListCommando implements Commando {

    private CakeRepository cakeRepository;

    public ListCommando(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    @Override
    public boolean execute() {
        List<Cake> cakes = cakeRepository.listCakes();
        for (Cake cake : cakes) {
            System.out.println(cake);
        }
        return true;
    }

    @Override
    public boolean shouldExecute(String commando) {
        return "list".equalsIgnoreCase(commando);
    }
}
