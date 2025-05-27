package org.example;

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
//        System.out.println("Welcome to the game!");
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

        return false;
    }

}


