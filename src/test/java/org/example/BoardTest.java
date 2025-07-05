package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
    @Test
    void testIsCellEmpty_EmptyCell()
    {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmpty_OccupiedCell()
    {
        Board board = new Board();

        board.place(0, 0, 'T');

        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void testPlace()
    {
        Board board = new Board();

        board.place(2, 2, 'T');

        assertEquals('T', board.cells[2][2]);
    }

    @Test
    void testIsCellEmpty_ArrayOutOfBounds()
    {
        Board board = new Board();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.isCellEmpty(3, 3));
    }

    @Test
    void testPlace_ArrayOutOfBounds()
    {
        Board board = new Board();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.place(3, 3, 'T'));
    }

    @Test
    void testCheckWin_HorizontalWin()
    {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testCheckWin_VerticalWin()
    {
        Board board = new Board();
        board.place(0, 0, 'O');
        board.place(1, 0, 'O');
        board.place(2, 0, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testCheckWin_DiagonalWin()
    {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testCheckWin_NoWin()
    {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        assertFalse(board.checkWin('X'));
        assertFalse(board.checkWin('O'));
    }

    @Test
    void testIsFull_EmptyBoard()
    {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    void testIsFull_FullBoard()
    {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');
        board.place(2, 0, 'X');
        board.place(2, 1, 'O');
        board.place(2, 2, 'X');
        assertTrue(board.isFull());
    }

    @Test
    void testReset_ClearsBoard()
    {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');
        
        board.reset();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }


}