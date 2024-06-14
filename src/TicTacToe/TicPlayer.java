package TicTacToe;

public class TicPlayer {
    private String name;
    private char symbol;

    public TicPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

}
