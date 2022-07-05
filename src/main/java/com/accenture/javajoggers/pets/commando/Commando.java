package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Pet;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Commando {
    public abstract void execute() throws SQLException;

    public abstract boolean shouldExecute(String commandoName);
}
