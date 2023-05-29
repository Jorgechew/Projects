public class Pig {


    private int balance;



    public Pig(int balance) {
        this.balance = balance;

    }

    public int getBalance() {
        return this.balance;
    }

    public int deposit(int amount){

        balance = balance + amount;
        return balance;
    }
    public void withdraw(int amount) {

        if (amount >= balance) {
            System.out.println("go to work");
        } else {
            balance = balance - amount;
            //System.out.println(balance);


        }
    }
}
