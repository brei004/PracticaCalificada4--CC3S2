package org.example;

import org.example.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void testIsValidPosition() {
        char[][] grid = {
                {'C', 'C', ' ', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {' ', 'C', 'C', ' ', 'B'},
                {' ', ' ', 'C', 'C', 'C'},
                {' ', ' ', ' ', ' ', ' '}
        };
        Map map = new Map(grid);
        assertTrue(map.isValidPosition(2, 3));
        assertFalse(map.isValidPosition(0, 0));
    }

    @Test
    void testIsPath() {
        char[][] grid = {
                {'C', 'C', ' ', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {' ', 'C', 'C', ' ', 'B'},
                {' ', ' ', 'C', 'C', 'C'},
                {' ', ' ', ' ', ' ', ' '}
        };
        Map map = new Map(grid);
        assertTrue(map.isPath(0, 0));
        assertFalse(map.isPath(2, 3));
    }

    @Test
    void testIsBase() {
        char[][] grid = {
                {'C', 'C', ' ', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {' ', 'C', 'C', ' ', 'B'},
                {' ', ' ', 'C', 'C', 'C'},
                {' ', ' ', ' ', ' ', ' '}
        };
        Map map = new Map(grid);
        assertTrue(map.isBase(2, 4));
        assertFalse(map.isBase(0, 0));
    }
}
