import java.sql.SQLOutput;

public class Game {

    private static GameObject[] gameObjects;

    private SniperRifle sniperRifle;

    private int shotsFired;


    public Game(GameObject[] gameObjects, SniperRifle sniperRifle) {
        this.gameObjects = gameObjects;
        this.sniperRifle = sniperRifle;
    }


    //what is the goal of the method createObjects? Where do the objects created go? How do I access them later?
    //tip: there's a cool variable that is an array of GameObjects that you can use O.o
    public static GameObject[] createObjects(int n) {
        gameObjects = new GameObject[n];

        for (int i = 0; i < gameObjects.length; i++) {
            gameObjects[i] = new GameObject();

            double object = Math.random();
            if (object < 0.33) {
                gameObjects[i] = new Tree();
                System.out.println("TREE");
            } else if (object > 0.33 && object < 0.66) {
                gameObjects[i] = new SoldierEnemy();
                System.out.println("SOLDIER");
            } else if (object > 0.66) {
                gameObjects[i] = new ArmouredEnemy();
                System.out.println("ARMOUR");
            }
            //do you really want to instantiate a GameObject?
        }
        return gameObjects;
    }

    public void start() {

       for(GameObject g: gameObjects){
            if(g instanceof Enemy) {
            while(!((Enemy) g).isDead()) {
                sniperRifle.shoot((Enemy) g);
                shotsFired++;
            }
                ((Enemy) g).setDead();
                continue;

        }
           System.out.println("-- Game Over --" ); // You are a loser player!!
    }
    }
}
