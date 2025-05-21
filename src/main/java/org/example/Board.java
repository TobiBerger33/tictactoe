package org.example;

public class Board
{
    private char[][] cells;


    public Board()
    {
        cells = new char[3][3];

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                cells[i][j] = ' ';
            }
        }
    }


    public boolean isCellEmpty(int x, int y)
    {
        if(cells[x][y] == ' ')
        {
            return true;
        }
        return false;
    }

    public void place(int x, int y, char marker)
    {
        cells[x][y] = marker;
    }

    public boolean isFull(int x, int y)
    {
        if(cells[x][y] != ' ')
        {
            return true;
        }
        return false;
    }

    public void clear()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                cells[i][j] = ' ';
            }
        }
    }

    public void print()
    {
        System.out.println("_______");

        for(int i = 0; i < 3; i++)
        {
            System.out.println("\n|");
            for(int j = 0; j < 3; j++)
            {
                System.out.print(cells[i][j] + "|");
            }
        }
        System.out.println("_______\n");
    }
}


