package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Pet;

import java.util.ArrayList;

public class ExitCommando extends Commando {

    @Override
    public boolean execute() {
        System.out.println("Exit");
        return false;
    }

    @Override
    public boolean shouldExecute(String commandoName) {
        return "exit".equalsIgnoreCase(commandoName);
    }

}
