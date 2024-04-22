import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println("Enter a position (1-9):");
            input = scanner.nextInt() - 1; // 0-based index
            int row = input / 3;
            int col = input % 3;
            if (board.getCell(row, col) == ' ') {
                board.markCell(row, col, symbol);
                break;
            } else {
                System.out.println("This cell is already taken. Choose another.");
            }
        } while (true);
    }
}
