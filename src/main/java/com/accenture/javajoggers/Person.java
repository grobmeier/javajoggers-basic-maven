package com.accenture.javajoggers;

public class Person {

    public String name;
    public String name2;
    public String eyeColor;
    public int birthYear;

    public void sayHello() {
        System.out.println("Hello, I am " + name);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
