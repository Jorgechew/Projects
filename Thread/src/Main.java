public class Main {
    public static void main(String[] args){

        for (int i = 0; i < 5; i++) {
            Multithreading thing = new Multithreading(i);
            Thread myThread = new Thread(thing);
            myThread.start();
            try {
                myThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        throw  new RuntimeException();




    }
}