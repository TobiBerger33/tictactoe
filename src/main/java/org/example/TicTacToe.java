package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe
{
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    protected static boolean playing = true;
    protected static boolean hasWinner;


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
        board.clear();

        Board newBoard = new Board();
        newBoard.printNewBoard();

        hasWinner = false;
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


    public void choosePosition()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true)
        {
            System.out.println("Player: " + getCurrentPlayer().getMarker() + "\nWhere do you want to place your marker? (1-9)");

            try
            {
                choice = scanner.nextInt();

                if (choice < 1 || choice > 9)
                {
                    System.out.println("Please enter a number between 1 and 9!");
                    throw new InputMismatchException();
                }
                else
                {
                    break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }

        getPosition(choice);
    }

    public void placeMarker(int x, int y)
    {
        try
        {
            if (getBoard().isCellEmpty(x, y))
            {
                getBoard().place(x, y, getCurrentPlayer().getMarker());

                getBoard().print();

                if(hasWinner())
                {
                    System.out.println("The winner is: Player " + getCurrentPlayer().getMarker());
                    hasWinner = true;
                }

                board.isFull();

                switchCurrentPlayer();

                if(hasWinner || board.isFull())
                {
                    continuePlaying();
                }
            }
            else
            {
                System.out.println("This cell is occupied! Select again");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid coordinates! Select again");
        }
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

    public void getPosition(int n)
    {
        int x;
        int y;

        switch(n)
        {
            case 1: x = 0; y = 0;
                break;
            case 2: x = 0; y = 1;
                break;
            case 3: x = 0; y = 2;
                break;
            case 4: x = 1; y = 0;
                break;
            case 5: x = 1; y = 1;
                break;
            case 6: x = 1; y = 2;
                break;
            case 7: x = 2; y = 0;
                break;
            case 8: x = 2; y = 1;
                break;
            case 9: x = 2; y = 2;
                break;
            default:
                System.out.println("Invalid position! Try again");
                return;
        }

        placeMarker(x, y);
    }

    public void continuePlaying()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Continue? (Y/N)");

            String playAgain = scanner.nextLine();

            switch (playAgain.toLowerCase())
            {
                case "y":
                    getBoard().clear();
                    playing = true;
                    return;
                case "n":
                    playing = false;
                    return;
                default:
                    System.out.println("Invalid input! Try again");
            }
        }
    }

}


