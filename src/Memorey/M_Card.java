package Memorey;

public class M_Card {
    private char letter;
    private boolean flipped;

    public M_Card(char letter, boolean flipped) {
        this.letter = letter;
        this.flipped = flipped;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }
}
