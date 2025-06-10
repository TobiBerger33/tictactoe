package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest
{
    @Test
    void testStartCreatesBoard()
    {
        TicTacToe game = new TicTacToe();

        assertNotNull(game.getBoard());
    }

    @Test
    void testSwitchCurrentPlayer()
    {
        TicTacToe game = new TicTacToe();

        assertEquals('X', game.getCurrentPlayer().getMarker());

        game.switchCurrentPlayer();

        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

}