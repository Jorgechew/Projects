public class Main {
    public static void main(String[] args) {


        Game game = new Game(Game.createObjects(20),new SniperRifle());
        game.start();
    }

}