package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TicTacToe game = new TicTacToe();
        game.start();

        while(true) {
            System.out.println("Player: " + game.getCurrentPlayer().getMarker() +
                                    ", where do you want to place your marker?");

            System.out.print("row: ");
            int x = scanner.nextInt();
            x--;

            System.out.print("column: ");
            int y = scanner.nextInt();
            y--;

            if(game.getBoard().isCellEmpty(x, y)) {
                game.getBoard().place(x, y, game.getCurrentPlayer().getMarker());

                game.getBoard().print();

                game.switchCurrentPlayer();
            } else {
                System.out.println("This cell is occupied! Try again!");
            }
        }

    }
}