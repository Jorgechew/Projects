import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import javax.print.attribute.standard.RequestingUserName;
import java.util.HashMap;
import java.util.Map;

public class AddClient {

    private Map<String,Integer> clients = new HashMap<>();
    AddClient addClient;

    private Client client;
    private String userName;
    private int passWord;
    public AddClient() {


        Prompt send = new Prompt(System.in, System.out);

        StringInputScanner userName = new StringInputScanner();
        userName.setMessage(("What is your userName? "));

        if (clients.containsKey(userName)){
            System.out.println("This username exist ");
            menuCliente();
        }

        IntegerInputScanner passWord = new IntegerInputScanner();
        passWord.setMessage("What is your password? ");

        String name = send.getUserInput(userName);
        int password = send.getUserInput(passWord);

        client = new Client(name,password);

        System.out.println("GREAT JOB, YOUR LOGIN RIGHT  NOW!");
        System.out.println("Username: " + name + " Password: " + password);


        clients.put(client.getName() , client.getPassword());
        System.out.println(clients);

        menuCliente();

    }


    public void verificationLogin() {

        System.out.println("INSERT YOUR LOGIN CREDENTIALS:");

        Prompt prompt2 = new Prompt(System.in, System.out);

        StringInputScanner question3 = new StringInputScanner();
        question3.setMessage("Username: ");
        String name2 = prompt2.getUserInput(question3);

        StringInputScanner question4 = new StringInputScanner();
        question4.setMessage("PassWord: ");
        String pass1 = prompt2.getUserInput(question4);
        Integer pass2 = Integer.parseInt(pass1);


        if(clients.containsKey(name2) && clients.get(name2).equals(pass2)){

            System.out.println("Login Successful!");
            System.out.println("Welcome home, " + (name2) + " !");
        }else {

            System.out.println("Username or PassWord are wrong");
        }
    }

    public void menuCliente() {

        Prompt menu = new Prompt(System.in, System.out);
        String[] options = {"Go to menu", "Create Account","Login"};


        MenuInputScanner scanner = new MenuInputScanner(options);


        scanner.setMessage("Should you can Create Accont or should you can go to menu?");

        while (true) {
            int answerIndex = menu.getUserInput(scanner);

            switch (answerIndex -1) {

                case 0:
                    Menu menu1 = new Menu();
                    break;
                case 1:
                    addClient = new AddClient();
                    break;
                case 2:
                    verificationLogin();
                    break;
                default:
                    System.out.println("mhmhmhmmh");

            }

        }

    }
}
