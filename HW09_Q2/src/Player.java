public abstract class Player {
    protected char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public abstract void makeMove(Board board);
}
