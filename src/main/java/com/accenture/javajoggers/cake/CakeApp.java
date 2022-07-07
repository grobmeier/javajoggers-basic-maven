package com.accenture.javajoggers.cake;

import com.accenture.javajoggers.cake.commandos.AddCommando;
import com.accenture.javajoggers.cake.commandos.Commando;
import com.accenture.javajoggers.cake.commandos.ExitCommando;
import com.accenture.javajoggers.cake.commandos.ListCommando;
import com.accenture.javajoggers.cake.entities.Cake;
import com.accenture.javajoggers.cake.repositories.CakeRepository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CakeApp {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello to the World of cakes.");

        Connector connector = new Connector();
        Connection connection = connector.getConnection();

        CakeRepository cakeRepository = new CakeRepository(connection);

        Commando addCommando = new AddCommando(scanner, cakeRepository);
        Commando listCommando = new ListCommando(cakeRepository);
        Commando exitCommando = new ExitCommando();

        ArrayList<Commando> commandos = new ArrayList<>();
        commandos.add(addCommando);
        commandos.add(listCommando);
        commandos.add(exitCommando);

        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("What do you want to do?");
            String line = scanner.nextLine();

            for (Commando commando : commandos) {
                if (commando.shouldExecute(line)) {
                    shouldContinue = commando.execute();
                }
            }
        }
    }

    public static void main(String[] args) {
        new CakeApp().run();
    }

}
