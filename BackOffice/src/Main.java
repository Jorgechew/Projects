public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("Rivaldi",60);
        Client name = new Client("Jorge", hotel);

        System.out.println("Hotel "+ hotel.getName() +"this is your room: " + hotel.getMaxBedrooms());
        System.out.println("Hotel "+ hotel.getName() +"this is your room: " + hotel.getMaxBedrooms());
        System.out.println();


        }
}