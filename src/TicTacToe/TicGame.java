package TicTacToe;

import java.util.Scanner;

public class TicGame {
    private final TicPlayer player1;
    private final TicPlayer player2;
    private final TicBoard ticBoard;
    private TicPlayer currentPlayer;
    private final Scanner scanner;
    private final char[][] board;

    public TicGame(String name1, char symbol1, String name2, char symbol2) {
        this.player1 = new TicPlayer(name1, symbol1);
        this.player2 = new TicPlayer(name2, symbol2);
        this.ticBoard = new TicBoard();
        currentPlayer = this.player1;
        scanner = new Scanner(System.in);
        board = ticBoard.getBoard();
    }

    public void start() {
        while (true) {
            ticBoard.printBoard();

            boolean isAdded;
            do {
                System.out.println(currentPlayer.getName() + "'s turn: ");
                System.out.print("row: ");
                int i = scanner.nextInt();
                System.out.print("col: ");
                int j = scanner.nextInt();
                isAdded = placeSymbol(i, j, currentPlayer.getSymbol());
                if (!isAdded) {
                    System.out.println(currentPlayer.getName() + " bitte ein gültiges index eingeben!");
                }
            } while (!isAdded);


            if (checkWin()) {
                System.out.println(currentPlayer.getName() + " hat gewonnen!");
                ticBoard.printBoard();
                break;
            }

            if (isBoardFull() && !checkWin()) {
                System.out.println("Game over. unentschieden!");
                ticBoard.printBoard();
                break;
            }

            changePlayer();
        }

    }

    public boolean isBoardFull() {
        for (int i = 0; i < ticBoard.getBoard().length; i++) {
            for (int j = 0; j < ticBoard.getBoard().length; j++) {
                if (this.ticBoard.getBoard()[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (row >= 0 && row < board.length) {
            if (col >= 0 && col < board.length) {
                if (board[row][col] == '-') {
                    board[row][col] = symbol;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWin() {
        if (checkRowsForWin() || checkColsForWin() || checkDiagolansForWin()) {
            return true;
        }
        return false;
    }

    public boolean checkRowsForWin() {
        for (int i = 0; i < board.length; i++) {
            if (checkRowEquals(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColsForWin() {
        for (int i = 0; i < board.length; i++) {
            if (checkRowEquals(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagolansForWin() {
        if (checkRowEquals(board[0][0], board[1][1], board[2][2])
                || checkRowEquals(board[0][2], board[1][1], board[2][0])) {
            return true;
        }
        return false;
    }

    public boolean checkRowEquals(char c1, char c2, char c3) {
        if ((c1 != '-') && (c1 == c2) && (c2 == c3)) {
            return true;
        }
        return false;
    }

    public void changePlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

}
