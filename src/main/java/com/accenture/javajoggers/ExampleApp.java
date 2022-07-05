package com.accenture.javajoggers;

public class ExampleApp {

    public static void main(String[] args) {

        String a = new String("Maja");
        String b = "Maja";

        // a == b
        if (a.equals(b)) {
            System.out.println("equals");
        } else {
            System.out.println("not equal");
        }

        // Primitive datatype
        int z = 10;
        int y = 10;

        if (z == y) {
            System.out.println("OK");
        }


    }
}
