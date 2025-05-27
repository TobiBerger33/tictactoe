package org.example;

public class TicTacToe
{
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;


    public TicTacToe()
    {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }


    public void start()
    {
        System.out.println("Welcome to the game!");
    }

    public void switchCurrentPlayer()
    {
        if(currentPlayer == player1)
        {
            currentPlayer = player2;
        }
        else
        {
            currentPlayer = player1;
        }
    }

    public Board getBoard()
    {
        return board;
    }

    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public boolean hasWinner()
    {
        return false;
    }

}


