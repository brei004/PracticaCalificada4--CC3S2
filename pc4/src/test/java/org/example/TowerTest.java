package org.example;

import org.example.Enemy;
import org.example.Tower;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TowerTest {
    @Mock
    private Enemy enemy;

    private Tower tower;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tower = new Tower(10, 5, 1) {
            @Override
            public void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public void upgrade() {
                this.damage += 5;
            }
        };
    }
    @Test
    public void testAttack() {
        tower.setPosition(0, 0);
        List<Enemy> enemies = List.of(enemy);

        when(enemy.getX()).thenReturn(0);
        when(enemy.getY()).thenReturn(3);
        when(enemy.remain()).thenReturn(true);

        tower.attack(enemies);

        verify(enemy).takeDamage(10);
    }
}

