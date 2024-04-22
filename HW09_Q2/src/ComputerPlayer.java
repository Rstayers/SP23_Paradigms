import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(Board board) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (board.getCell(row, col) != ' ');
        board.markCell(row, col, symbol);
    }
}
