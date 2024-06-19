package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.example.Enemy;
import org.example.Wave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class WaveTest {
    @Mock
    private Enemy basicEnemy;
    @Mock
    private Enemy bossEnemy;

    private Wave wave;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Creamos un stub para el método generateEnemies
        wave = new Wave(1) {
            @Override
            public List<Enemy> generateEnemies(int waveNumber) {
                return List.of(basicEnemy, bossEnemy);
            }
        };
    }

    @Test
    public void testGenerateEnemies() {
        List<Enemy> enemies = wave.generateEnemies(1);

        assertEquals(2, enemies.size());
        assertTrue(enemies.contains(basicEnemy));
        assertTrue(enemies.contains(bossEnemy));
    }
}

