package com.accenture.javajoggers.cake.commandos;

public interface Commando {

    boolean execute();

    boolean shouldExecute(String commando);

}
