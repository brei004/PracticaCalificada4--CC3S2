package org.example;

import org.example.BasicEnemy;
import org.example.Enemy;
import org.example.Map;
import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void testTakeDamage() {
        Enemy enemy = new BasicEnemy();
        int initialHealth = enemy.getHealth();
        enemy.takeDamage(10);
        assertEquals(initialHealth - 10, enemy.getHealth());
    }

    @Test
    void testIsAlive() {
        Enemy enemy = new BasicEnemy();
        assertTrue(enemy.remain());
        enemy.takeDamage(enemy.getHealth());
        assertFalse(enemy.remain());
    }

    @Test
    void testMove() {
        char[][] grid = {
                {'C', 'C', ' ', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {' ', 'C', 'C', ' ', 'B'},
                {' ', ' ', 'C', 'C', 'C'},
                {' ', ' ', ' ', ' ', ' '}
        };
        Map map = new Map(grid);
        Player player = new Player();
        Enemy enemy = new BasicEnemy();
        enemy.move(map, player);
        enemy.move(map, player);
        assertEquals(1, enemy.getX());
        assertEquals(1, enemy.getY());
    }
}
