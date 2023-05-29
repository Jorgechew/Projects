public class Main {
    public static void main(String[] args) {



        Client client = new Client("Jorge", new Pig(1000));

        System.out.println(client.getName());
        client.deposit(140);
        client.withdraw(120);



    }
}