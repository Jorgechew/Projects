public enum Hand {
    Paper("Paper"),
    Rock("Rock"),
    Scissors("Scissors");

    private String outhand;

    Hand(String outhand){
        this.outhand = outhand;
    }
    public String getouthand () {
        return this.outhand;
    }

    public static Hand showHand() {

       //System.out.println(Hand.values().length);

        return Hand.values() [(int) (Math.random() * Hand.values().length)];

    }
}