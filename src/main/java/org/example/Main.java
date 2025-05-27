package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        game.start();
        Scanner scanner = new Scanner(System.in);

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


    }
}