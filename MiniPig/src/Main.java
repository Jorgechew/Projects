public class Main {
    public static void main(String[] args) {

        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet();
        Pig pb = new Pig();

        Client p1 = new Client("Catarina", pb, w1, 500);
        System.out.println(p1);

        Client p2 = new Client("Joana", pb, w2, 0);
        System.out.println(p2);

        p1.saveMoney(200);
        System.out.println(p1);
        System.out.println(p2);

        p1.spend(100);
        System.out.println(p1);
        System.out.println(p2);

    }

}