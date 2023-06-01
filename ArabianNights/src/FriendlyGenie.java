public class FriendlyGenie extends Genie {

    public FriendlyGenie(int maxGenies){
        super(maxGenies);

    }

    private String friendly;

    private int maxWishes;


  // public FriendlyGenie (int maxWishes) {
    //   this.friendly = friendly;

  // }





    public void makeWish () {
        if (getWishesleft() > 0) ;
        setWishesleft();
        System.out.println("Wishes left: " + getWishesleft());
    }



    }



