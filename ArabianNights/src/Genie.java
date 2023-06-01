public class Genie {

    private int maxGenies;
    private int wishesleft;
    private int maxWishes ;


    public Genie(int maxGenies){
        this.maxGenies=maxGenies;
    }


    public Genie (){
        this.maxWishes = (int) Math.ceil(Math.random() * 5);
        this.wishesleft = maxWishes;
    }

    public int getMaxWishes() {

        return maxWishes;
    }

    public int getWishesleft() {
        return wishesleft;

    }

    public void setMaxWishes(int maxWishes) {
        this.maxWishes = maxWishes;
    }

    public void setWishesleft() {
        this.wishesleft --;
    }
}
