package Memorey;

import java.util.Scanner;

public class M_Game {
    private final M_Board mBoard;
    private final Scanner scanner;

    public M_Game(int size) {
        mBoard = new M_Board(size);
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        mBoard.printBoard();
        System.out.print("First Card i: ");
        int i1 = scanner.nextInt();

        System.out.print("First Card j: ");
        int j1 = scanner.nextInt();

        mBoard.flipCard(i1, j1);
        mBoard.printBoard();


        System.out.print("Second Card i: ");
        int i2 = scanner.nextInt();

        System.out.print("Second Card j: ");
        int j2 = scanner.nextInt();

        mBoard.flipCard(i2, j2);
        mBoard.printBoard();

        if (!mBoard.checkCards(i1, j1, i2, j2)) {
            mBoard.flipCard(i1, j1);
            mBoard.flipCard(i2, j2);
            System.out.println("Nicht richtig! versuche noch einmal");
        }else{
            System.out.println("Richtig! weiter so");
        }

        System.out.println();
    }
}
