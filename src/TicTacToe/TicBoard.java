package TicTacToe;

public class TicBoard {
    private char [][] board;

    public TicBoard() {
        this.initBoard();
    }

    private void initBoard(){
        this.board = new char[3][3];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                this.board[i][j] = '-';
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public char[][] getBoard() {
        return board;
    }
}
