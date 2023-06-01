public class Client {

    private Hotel hotel;

    private String name;

    private int roomNr;

    public Client(String name, Hotel hotel){
        this.name = name;
        this.hotel = hotel;

    }
    public String getName() {
        return name;
    }


    //TODO checkIn(); and checkOut();
    //Where I use delegation to the hotel to perform these actions




}
