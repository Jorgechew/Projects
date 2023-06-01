public class RecyclableDemon extends Genie{
    private String demon;

    public RecyclableDemon (int maxGenies){
        super(maxGenies);
    }

    public void makeWish () {
        if (getWishesleft() > 0) ;
        setWishesleft();
        System.out.println("Wishes left: " + getWishesleft());

    }
}
