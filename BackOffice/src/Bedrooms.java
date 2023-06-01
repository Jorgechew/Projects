public class Bedrooms {
    private boolean available;
    public Bedrooms (boolean available){
        this.available = available;
    }
    public boolean checkIn() {
        return available = true;
    }
    public boolean checkOut() {
        return available = false;
    }
    public boolean isAvailable() {
        return available;
    }
}

