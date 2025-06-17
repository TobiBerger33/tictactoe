package org.example;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;


    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        System.out.println("\nWelcome to a new game!");
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchCurrentPlayer() {
        if(currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
