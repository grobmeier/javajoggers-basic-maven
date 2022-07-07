package com.accenture.javajoggers.pets;

import com.accenture.javajoggers.pets.commando.AddCommando;
import com.accenture.javajoggers.pets.commando.Commando;
import com.accenture.javajoggers.pets.commando.ContainsCommando;
import com.accenture.javajoggers.pets.commando.ExitCommando;
import com.accenture.javajoggers.pets.commando.ListCommando;
import com.accenture.javajoggers.pets.commando.RemoveCommando;
import com.accenture.javajoggers.pets.db.AnimalRepository;
import com.accenture.javajoggers.pets.db.AnimalRepositoryDB;
import com.accenture.javajoggers.pets.db.AnimalRepositoryException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PetsApp {

    /*Ü
    public
    protected
    <package>
    private
     */



    private void run() {
        Connection connection = new Connector().getConnection();

        AnimalRepository animalRepository = null;
        try {
             animalRepository = new AnimalRepositoryDB(connection);
        } catch(IllegalArgumentException ex) {
            // can catch, but not mandatory
            System.out.println("Could not create repository");
            throw ex;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pets App");
        Commando listCommando = new ListCommando(animalRepository);
        Commando addCommando = new AddCommando(animalRepository, scanner);
        Commando exitCommando = new ExitCommando();
        Commando containsCommando = new ContainsCommando(animalRepository, scanner);
        Commando removeCommando = new RemoveCommando(animalRepository, scanner);

        ArrayList<Commando> commandos = new ArrayList<>();
        commandos.add(listCommando);
        commandos.add(addCommando);
        commandos.add(exitCommando);
        commandos.add(containsCommando);
        commandos.add(removeCommando);

        try {
            boolean shouldContinue = true;
            while (shouldContinue) {
                System.out.println("What do you want to do?");
                String command = scanner.nextLine();

                try {
                    for (Commando commando : commandos) {
                        if (commando.shouldExecute(command)) {
                            shouldContinue = commando.execute();
                        }
                    }
                } catch (AnimalRepositoryException ex) {
                    System.out.println("exception occurred sorry");
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PetsApp app = new PetsApp();
        app.run();
    }

}
