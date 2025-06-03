package org.example;

import java.sql.SQLOutput;

public class TicTacToe
{
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;


    public TicTacToe()
    {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }


    public void start()
    {
        System.out.println("\nWelcome to a new game!");

        Board newBoard = new Board();
        newBoard.printNewBoard();
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
        for(int i = 0; i < 3; i++)
        {
            if(!board.isCellEmpty(i, 0))
            {
                if(board.cells[i][0] == board.cells[i][1] && board.cells[i][1] == board.cells[i][2])
                {
                    return true;
                }
            }
        }

        for(int j = 0; j < 3; j++)
        {
            if(!board.isCellEmpty(0, j))
            {
                if(board.cells[0][j] == board.cells[1][j] && board.cells[1][j] == board.cells[2][j])
                {
                    return true;
                }
            }
        }

        if(!board.isCellEmpty(0, 0) &&
                board.cells[0][0] == board.cells[1][1] && board.cells[1][1] == board.cells[2][2])
        {
            return true;
        }

        if(!board.isCellEmpty(0, 2) &&
                board.cells[0][2] == board.cells[1][1] && board.cells[1][1] == board.cells[2][0])
        {
            return true;
        }

        return false;
    }

    public int[] getPosition(int n)
    {
        int x;
        int y;
        int[] pos = new int[2];

        switch(n)
        {
            case 1: pos[0] = 0; pos[1] = 0;
                break;
            case 2: pos[0] = 0; pos[1] = 1;
                break;
            case 3: pos[0] = 0; pos[1] = 2;
                break;
            case 4: pos[0] = 1; pos[1] = 0;
                break;
            case 5: pos[0] = 1; pos[1] = 1;
                break;
            case 6: pos[0] = 1; pos[1] = 2;
                break;
            case 7: pos[0] = 2; pos[1] = 0;
                break;
            case 8: pos[0] = 2; pos[1] = 1;
                break;
            case 9: pos[0] = 2; pos[1] = 2;
                break;
            default:
                System.out.println("Invalid position! Try again");
                return null;
        }

        return pos;
    }

}


