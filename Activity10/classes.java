public class Game {
    private Board board;
    private Player currentPlayer;
    private String gameStatus;

    public Game() {
        this.board = new Board();
        // initialization of players
        // set game status
    }

    public void playTurn(int position) {
        // implementation
    }

    public void checkForWin() {
        // implementation
    }

    public void switchPlayer() {
        // implementation
    }

    public void restartGame() {
        // implementation
    }
}

public class Board {
    private char[][] cells;
    private final int size = 3;

    public Board() {
        this.cells = new char[size][size];
        // initialize board
    }

    public void markCell(int row, int col, char symbol) {
        // implementation
    }

    public boolean isFull() {
        // implementation
        return false;
    }

    public void clear() {
        // implementation
    }
}

public abstract class Player {
    protected char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public abstract void makeMove(Board board);
}

public class HumanPlayer extends Player {
    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(Board board) {
        // implementation
    }
}

public class ComputerPlayer extends Player {
    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(Board board) {
        // implementation
    }
}
