
    public class Hotel {
        private String name;
        private int maxBedrooms;
        private Bedrooms[] rooms;
        public Hotel(String name, int maxBedrooms) {
            this.name = name;
            this.maxBedrooms = maxBedrooms;
            this.rooms = new Bedrooms[maxBedrooms];
            for (int i = 0; i < rooms.length; i++) {
                rooms[i] = new Bedrooms(false);
            }
        }


        // TODO
        // Checkin and Checkout where the hotel returns a roomNr to the client


        public String getName() {
            return name;
        }

        public int getMaxBedrooms() {
            return maxBedrooms;
        }
    }








