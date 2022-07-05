package com.accenture.javajoggers;

public class PersonApp {

    public static void main(String[] args) {
//      Reference (Variable) type
//      |      Reference (Variable) name
//      v      v
        Person p1 = new Person();
        p1.eyeColor = "Blue";
        p1.name = "Madelaine";

        Person p2 = new Person();
        p2.eyeColor = "Brown";
        p2.name = "Maja";

        p1.sayHello();
        p2.sayHello();


    }
}
