package org.academiadecodigo.bootcamp;

public class CarCrashX {

    public static void main(String[] args) throws InterruptedException {

        //Game g = new Game(GridType.LANTERNA, 80, 25, 200);
        Game g = new Game(GridType.SIMPLE_GFX, 30, 50, 80);

        g.init();
        g.start();

    }

}
