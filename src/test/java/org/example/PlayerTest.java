package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest
{
    @Test
    void testGetMarker()
    {
        Player player = new Player('T');

        assertEquals('T', player.getMarker());
    }

}