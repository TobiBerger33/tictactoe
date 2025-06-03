package org.example;

public class Main {
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();

        while(TicTacToe.playing)
        {
            game.start();

            while(!TicTacToe.hasWinner)
            {
                game.choosePosition();

                if(TicTacToe.hasWinner)
                {
                    break;
                }
                else if(game.getBoard().isFull())
                {
                    System.out.println("The game is a draw!");
                    break;
                }
            }
        }

        System.out.println("Have a nice day!");

    }
}