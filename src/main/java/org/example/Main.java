package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.start();

        while (game.getGameState() == TicTacToe.GameState.IN_PROGRESS) {
            playTurn(scanner, game);
        }

        displayGameResult(game);
    }

    private static void playTurn(Scanner scanner, TicTacToe game) {
        System.out.println("Player: " + game.getCurrentPlayer().getMarker() +
                ", where do you want to place your marker?");

        System.out.print("row: ");
        int x = scanner.nextInt();
        x--;

        System.out.print("column: ");
        int y = scanner.nextInt();
        y--;

        if (game.getBoard().isCellEmpty(x, y)) {
            game.getBoard().place(x, y, game.getCurrentPlayer().getMarker());
            game.getBoard().print();
            game.updateGameState();

            if (game.getGameState() == TicTacToe.GameState.IN_PROGRESS) {
                game.switchCurrentPlayer();
            }
        } else {
            System.out.println("This cell is occupied! Try again!");
        }
    }

    private static void displayGameResult(TicTacToe game) {
        System.out.println("\n==================");
        System.out.println("   GAME OVER!");
        System.out.println("==================");

        switch (game.getGameState()) {
            case X_WINS:
                System.out.println("🎉 Player X wins! Congratulations!");
                break;
            case O_WINS:
                System.out.println("🎉 Player O wins! Congratulations!");
                break;
            case DRAW:
                System.out.println("It's a draw! Well played both!");
                break;
            default:
                break;
        }
        System.out.println("==================\n");
    }
}