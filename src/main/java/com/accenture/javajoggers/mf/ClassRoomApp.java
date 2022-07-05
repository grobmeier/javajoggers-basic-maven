package com.accenture.javajoggers.mf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassRoomApp {

    public static void main(String[] args) {

        ArrayList<Human> humans = new ArrayList<>();
        Object[] es = humans
                .stream()
                .filter(human -> {
            if (human.name.startsWith("E")) return true;
            return false;
        }).toArray();
        // Lambda



        List<Object> objects = Arrays.asList(es);


        Human human = new Human();
        human.saySomething();

        Trainee trainee = new Trainee();
        trainee.saySomething();

        Human h1 = new Trainee();
        human.saySomething();

        System.out.println("");
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;


    }

    public ArrayList<Human> filterForCharacter(ArrayList<Human> humans, String startsWith) {
        ArrayList<Human> result = new ArrayList<>();
        for (Human human : humans) {
            if (human.name.startsWith(startsWith)) {
                result.add(human);
            }
        }
        return result;
    }
}
