public class Client {

    private String name;

    public Pig pignew;


    public Client(String name, Pig pignew){
        this.name = name;

        this.pignew = pignew;
    }

    public String getName() {
        return name;
    }

    public void deposit(int deposit){
        pignew.deposit(deposit);
        System.out.println(pignew.getBalance());
    }

    public void withdraw (int withdraw){
        pignew.withdraw(withdraw);
        System.out.println(pignew.getBalance());
    }
}



