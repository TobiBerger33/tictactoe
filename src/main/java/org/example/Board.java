package org.example;

public class Board {
    protected char[][] cells;


    public Board() {
        cells = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }


    public boolean isCellEmpty(int x, int y) throws ArrayIndexOutOfBoundsException {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) throws ArrayIndexOutOfBoundsException {
        cells[x][y] = marker;
    }

    public void print() {
        System.out.print("_______");

        for(int i = 0; i < 3; i++) {
            System.out.print("\n|");

            for(int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + "|");
            }
        }
        System.out.println("\n_______\n");
    }

    public boolean checkWin(char marker) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (cells[0][j] == marker && cells[1][j] == marker && cells[2][j] == marker) {
                return true;
            }
        }

        if (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) {
            return true;
        }
        return cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

}