public class GrumpyGenie extends Genie{

    public  GrumpyGenie (int maxGenies){
        super(maxGenies);
    }

    private String grumpy;

    public void grumpyWish() {
        while (getWishesleft() == getMaxWishes()) {

            setWishesleft();
            System.out.println("But maybe dont have all wishes!!!");
        }
        System.out.println("No more Wishes!");
    }


    public GrumpyGenie (){
        this.grumpy= grumpy;
    }




}
