package org.example;

public class Board
{
    protected char[][] cells;


    public Board()
    {
        cells = new char[3][3];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                cells[i][j] = ' ';
            }
        }
    }


    public boolean isCellEmpty(int x, int y) throws ArrayIndexOutOfBoundsException
    {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) throws ArrayIndexOutOfBoundsException
    {
        cells[x][y] = marker;
    }

}