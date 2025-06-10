package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
    @Test
    void testIsCellEmpty_OccupiedCell_ReturnsFalse()
    {
        Board board = new Board();

        board.place(0, 0, 'X');

        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmpty_EmptyCell_ReturnsTrue()
    {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testPlace_ValidPosition_SetsMarker()
    {
        Board board = new Board();

        board.place(0, 0, 'X');

        assertEquals('X', board.cells[0][0]);
    }

    @Test
    void testPlace_InvalidPosition_DoesNotSetMarker()
    {
        Board board = new Board();

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> board.place(0, 3, 'X'));
    }

    @Test
    void testClear_SetsMarkerThenClearsBoard()
    {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');

        board.clear();

        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    void testisFull_BoardIsFull_ReturnsTrue()
    {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');

    }
}