package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.Pet;
import com.accenture.javajoggers.pets.db.AnimalRepositoryException;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Commando {
    public abstract boolean execute() throws AnimalRepositoryException;

    public abstract boolean shouldExecute(String commandoName);
}
