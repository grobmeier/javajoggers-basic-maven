package com.accenture.javajoggers;

import java.util.Scanner;

public class UserInputReader {


    public String readInput(Scanner inputReader, String question) {
        System.out.println(question);
        String search = inputReader.nextLine();
        return search;
    }

}
