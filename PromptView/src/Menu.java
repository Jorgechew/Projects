import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {

    Prompt menu = new Prompt(System.in, System.out);
    String[] options = {"Login", "Create Account"};
    AddClient addClient;
    public Menu() {
        goToMenu();
    }

    public void goToMenu() {

        MenuInputScanner scanner = new MenuInputScanner(options);

        scanner.setMessage("Should you can Create Account or should you can login?");

        while (true) {
            int answerIndex = menu.getUserInput(scanner);

            switch (answerIndex - 1) {
                case 0:

                    break;
                case 1:
                    this.addClient = new AddClient();
                    break;

            }


        }
    }

}
