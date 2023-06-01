import com.sun.security.auth.SolarisNumericUserPrincipal;

public class Main {
    public static void main(String[] args) {

        Jogo Showman = new Jogo();
        Player playerA = new Player("Player A");
        Player playerB = new Player("Player B");

        int guest1 = 0;
        int guest2 = 0;
        int guest3 = Showman.guessnumber();

            System.out.println("Número de jogo " +guest3);
            while (guest1 != guest3 && guest2 != guest3) {
            guest1 = playerA.guessnumber();
            guest2 = playerB.guessnumber();

            System.out.println("Números da catarina " + guest1 + " Números da Mafalda " + guest2);

            if (guest1 == guest3) {
                System.out.println("Player 1 WIN!" );
                break;
            } else if (guest2 == guest3) {
                System.out.println("Player 2 WIN");

            }


        }



    }
    }
