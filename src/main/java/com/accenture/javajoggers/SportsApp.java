package com.accenture.javajoggers;

public class SportsApp {

    public static void main(String[] args) {

        System.out.println("Hello World");

        if (args.length > 0) {
            System.out.println(args[0]);
        }

        String[] names = new String[] {
                "Kathrin",
                "Ekaterina",
                "Peter",
                "Theresa",
                "Malte",
                "Madelaine",
                "Maja"
        };

        for (String name: names) {
            if (args.length > 0) {
                if (name.startsWith(args[0])) {
                    System.out.println(name);
                }
            } else {
                System.out.println(name);
            }
        }

        /**
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        */
    }

}
