public class Player {

    public String nameplayer;

    public Player ( String nameplayer){
        this.nameplayer = nameplayer;
    }

    public Hand gamehand () {
        return Hand.showHand();
    }
}
