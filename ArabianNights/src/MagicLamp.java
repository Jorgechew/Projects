public class MagicLamp {

    private int geniesCounter;
    private int srubLamp;
    private int maxGenies;

    public MagicLamp(int geniesCounter) {
        this.maxGenies = (int) Math.ceil(Math.random() * 8);
        this.geniesCounter = maxGenies;
        System.out.println();
    }

    public int getGeniesCounter() {
        return geniesCounter;
    }


    public int getMaxGenies() {
        return maxGenies;
    }

    public void scrubLamp () {
        if (this.geniesCounter > 0) {
            this.geniesCounter--;
            System.out.println(" The Genie :  " + geniesCounter);
            if (this.geniesCounter % 2 == 0) {
                //  FriendlyGenie friendlyGenie = new FriendlyGenie(5);
                //System.out.println("Friendly genie make wish : " + friendlyGenie.getMaxWishes());
                // System.out.println("Friendly used : " + friendlyGenie.getWishesleft());
            } else {
                GrumpyGenie grumpyGenie = new GrumpyGenie();
                System.out.println("Im Grummy, you have only: " + grumpyGenie.getMaxWishes() + " whishes!");

                grumpyGenie.grumpyWish();
            }

        }
        System.out.println(" ");
        if (this.geniesCounter >= 6) {
            RecyclableDemon demon = new RecyclableDemon();
            System.out.println("Summoned Demon!!!");
            System.out.println("I will make all your wishes, but you dont want those wishes!!!");
        }

    }

}




