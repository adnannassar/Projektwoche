package Memorey;

import java.util.Random;

public class M_Board {
    private final M_Card[][] board;
    private final Random rand;

    public M_Board(int size) {
        board = new M_Card[size][size];
        rand = new Random();
        initBoard();

    }

    private void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new M_Card(' ', false);
            }
        }
        fillBoard();
    }

    private void fillBoard() {
        char currentChar = (char) rand.nextInt(65, 91);

        for (int i = 0; i < board.length * board.length / 2; i++) {
            addLetterTwice(currentChar);
            if (currentChar == 'Z') {
                currentChar = 'A';
            } else {
                currentChar = (char) (currentChar + 1);
            }
        }
    }

    private void addLetterTwice(char currentChar) {
        for (int i = 0; i < 2; i++) {
            int row, col;
            do {
                row = rand.nextInt(board.length);
                col = rand.nextInt(board.length);
            } while (board[row][col].getLetter() != ' '); // find empty index

            board[row][col].setLetter(currentChar);
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].isFlipped()){
                    System.out.print(board[i][j].getLetter() + "\t");
                }else{
                    System.out.print("?\t");
                }
            }
            System.out.println();
        }
    }

    public void flipCard(int i, int j) {
        board[i][j].setFlipped(!board[i][j].isFlipped());
    }

    public boolean checkCards(int i1, int j1, int i2, int j2) {
        if(board[i1][j1].getLetter() == board[i2][j2].getLetter()){
            return true;
        }
        return false;
    }
}