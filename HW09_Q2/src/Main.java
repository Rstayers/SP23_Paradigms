import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Welcome to Tic Tac Toe!");
        game.getBoard().display();

        while (!game.isGameEnded()) {
            if (game.getCurrentPlayer() instanceof HumanPlayer) {
                System.out.println("Your turn. You are 'X'.");
            } else {
                System.out.println("Computer's turn. It plays 'O'.");
            }

            game.playTurn();  // Will internally handle user or computer move based on current player

            if (!game.getGameStatus().equals("Playing")) {
                System.out.println(game.getGameStatus());  // This will print "Player 1 has won!", "Computer has won!", or "Draw!"
                break;
            }

        }

        scanner.close();
        System.out.println("Game Over. Thanks for playing!");
        System.exit(0);
    }
}
