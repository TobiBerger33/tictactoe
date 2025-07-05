package org.example;

public class TicTacToe {
    public enum GameState {
        IN_PROGRESS,
        X_WINS,
        O_WINS,
        DRAW
    }
    
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    private GameState gameState;


    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
        gameState = GameState.IN_PROGRESS;
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
    
    public GameState getGameState() {
        return gameState;
    }
    
    public void updateGameState() {
        if (board.checkWin('X')) {
            gameState = GameState.X_WINS;
        } else if (board.checkWin('O')) {
            gameState = GameState.O_WINS;
        } else if (board.isFull()) {
            gameState = GameState.DRAW;
        }
    }
    
    public void reset() {
        board.reset();
        currentPlayer = player1;
        gameState = GameState.IN_PROGRESS;
    }
}
