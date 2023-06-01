package org.academiadecodigo.carcrash;

import java.text.FieldPosition;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game g = new Game(100, 25, 200);


        System.out.println();
        g.init(); // Creates a bunch of cars and randomly puts them in the field
        g.start(); // Starts the car crash animation

    }
}
