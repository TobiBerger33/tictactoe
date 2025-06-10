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


}