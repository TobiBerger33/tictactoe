package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();

        Scanner scanner = new Scanner(System.in);

        boolean playing = true;

        while(playing)
        {
            game.start();
            game.getBoard().print();

            while(!game.hasWinner())
            {
                System.out.println("Player: " + game.getCurrentPlayer().getMarker() + "\nWhere do you want to place your marker?");

                System.out.print("Enter row: ");
                    int x = scanner.nextInt();
                System.out.print("Enter column: ");
                    int y = scanner.nextInt();

                try
                {
                    if(game.getBoard().isCellEmpty(x, y))
                    {
                        game.getBoard().place(x, y, game.getCurrentPlayer().getMarker());

                        game.getBoard().print();

                        game.switchCurrentPlayer();

                        if(game.hasWinner())
                        {
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("This cell is occupied! Select again");
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Invalid coordinates! Select again");
                }

                if(game.getBoard().isFull())
                {
                    System.out.println("The game is a draw!");
                    break;
                }
            }

            if(game.hasWinner())
            {
                System.out.println("The winner is: Player " + game.getCurrentPlayer().getMarker());
            }

            scanner.nextLine();

            while(true)
            {
                System.out.println("Continue? (Y/N)");

                String playAgain = scanner.nextLine();

                switch (playAgain.toLowerCase())
                {
                    case "y":
                        game.getBoard().clear();
                        break;
                    case "n":
                        playing = false;
                        break;
                    default:
                        System.out.println("Invalid input! Try again");
                        continue;
                }
                break;
            }

        }

        System.out.println("Have a nice day!");

    }
}