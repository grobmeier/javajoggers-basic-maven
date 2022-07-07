package com.accenture.javajoggers.mf;

import com.accenture.javajoggers.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TraineeTestApp {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("demo-file.txt"));
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(s);

            String[] split = s.split(";");

            Person p = new Person();
            p.name = split[0];
            p.name2 = split[1];
            p.birthYear = Integer.parseInt(split[2]);

            System.out.println(p);
        }

    }

    // x.intValue();
    public static void bla (Integer a) {
        System.out.println(a);
    }

}
