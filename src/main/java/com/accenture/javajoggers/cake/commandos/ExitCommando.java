package com.accenture.javajoggers.cake.commandos;

public class ExitCommando implements Commando {

    @Override
    public boolean execute() {
        System.out.println("exit");
        return false;
    }

    @Override
    public boolean shouldExecute(String commando) {
        return "exit".equalsIgnoreCase(commando);
    }
}
