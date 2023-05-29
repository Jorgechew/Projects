public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Jorge");
        Player player2 = new Player("Tiago");

        System.out.println(player1.gamehand());

        // int hand1 = player1.gamehand();

        boolean endGame = false;

        while (endGame) {

            if (player1.gamehand() == Hand.Rock) {
                switch (player2.gamehand()) {
                    case Rock:
                        System.out.println("Draw");
                        break;
                    case Paper:
                        System.out.println(player2 + " Win");
                        break;
                    case Scissors:
                        System.out.println(player1 + " Win");
                        break;
                }


                //if( (player1.gamehand() == Hand.Paper) && (player2.gamehand() == Hand.Paper) )
                // System.out.println("Empate");
                // } else if (player1.gamehand() == Hand.Paper) && (player2.gamehand() == Hand.Rock)




        /*while (!endGame) {
        if( player1(Hand.&& player2(Han) )
*/


            }
        }
    }

}