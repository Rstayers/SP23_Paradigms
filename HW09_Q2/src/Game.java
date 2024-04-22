public class Game {
    private Board board;
    private Player currentPlayer;
    private Player humanPlayer;
    private Player computerPlayer;
    private String gameStatus;
    private boolean gameEnded;

    public Game() {
        board = new Board();
        humanPlayer = new HumanPlayer('X');
        computerPlayer = new ComputerPlayer('O');
        currentPlayer = humanPlayer; // Human starts first
        gameStatus = "Playing";
        gameEnded = false;
    }

    public void playTurn() {
        currentPlayer.makeMove(board);
        board.display();
        checkForWin();
        if (!gameEnded) {
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
    }

    private void checkForWin() {
        if (checkWinCondition(currentPlayer.symbol)) {
            gameStatus = currentPlayer == humanPlayer ? "Player 1 has won!" : "Computer has won!";
            gameEnded = true;
        } else if (board.isFull()) {
            gameStatus = "Draw!";
            gameEnded = true;
        }
    }

    private boolean checkWinCondition(char symbol) {
        // Check rows, columns, and diagonals for win condition
        for (int i = 0; i < 3; i++) {
            if ((board.getCell(i, 0) == symbol && board.getCell(i, 1) == symbol && board.getCell(i, 2) == symbol) ||
                    (board.getCell(0, i) == symbol && board.getCell(1, i) == symbol && board.getCell(2, i) == symbol)) {
                return true;
            }
        }
        // Check diagonals
        if ((board.getCell(0, 0) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 2) == symbol) ||
                (board.getCell(0, 2) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 0) == symbol)) {
            return true;
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    
}
