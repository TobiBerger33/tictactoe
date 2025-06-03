package org.example;

public class Board
{
    protected char[][] cells;


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


    public boolean isCellEmpty(int x, int y) throws ArrayIndexOutOfBoundsException
    {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker)
    {
        cells[x][y] = marker;
    }

    public boolean isFull()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(cells[i][j] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
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
        System.out.print("_______");

        for(int i = 0; i < 3; i++)
        {
            System.out.print("\n|");

            for(int j = 0; j < 3; j++)
            {
                System.out.print(cells[i][j] + "|");
            }
        }
        System.out.println("\n_______\n");
    }

    public void printNewBoard()
    {
        System.out.print("_______");

        int n = 1;

        for(int i = 0; i < 3; i++)
        {
            System.out.print("\n|");

            for(int j = 0; j < 3; j++)
            {
                System.out.print(n + "|");
                n++;
            }
        }
        System.out.println("\n_______\n");
    }
}


