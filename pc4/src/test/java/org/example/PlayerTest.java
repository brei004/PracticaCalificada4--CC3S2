package org.example;

import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testAddScore() {
        Player player = new Player();
        player.addScore(10);
        assertEquals(10, player.getScore());
    }

    @Test
    void testMinusBaseHealth() {
        Player player = new Player();
        player.deductBaseHealth(10);
        assertEquals(90, player.getBaseHealth());
    }

    @Test
    void testGetScore() {
        Player player = new Player();
        assertEquals(0, player.getScore());
        player.addScore(10);
        assertEquals(10, player.getScore());
    }

    @Test
    void testGetBaseHealth() {
        Player player = new Player();
        assertEquals(100, player.getBaseHealth());
    }
}
