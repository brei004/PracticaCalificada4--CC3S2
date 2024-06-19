package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;


public class GameTest {
    private Map mockMap;
    private Player mockPlayer;
    private Wave mockWave;
    private Tower mockTower;
    private Enemy mockEnemy;
    private Game game;

    private Enemy mockEnemy1;
    private Enemy mockEnemy2;

    @BeforeEach
    public void setUp() {
        mockEnemy1 = Mockito.mock(Enemy.class);
        mockEnemy2 = Mockito.mock(Enemy.class);

        // Crear un mock de Tower
        mockTower = Mockito.mock(Tower.class);

        // Configurar los métodos necesarios
        when(mockEnemy1.remain()).thenReturn(true);
        when(mockEnemy2.remain()).thenReturn(true);
        when(mockTower.canAttack()).thenReturn(true);
    }
    @Test
    public void testInteraccionTowerEnemy() {
        // Crear la lista de enemigos
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mockEnemy1);
        enemies.add(mockEnemy2);

        // Llamar al método attack
        mockTower.attack(enemies);

        // Verificar que el método takeDamage se llame en los enemigos
        verify(mockTower).attack(enemies);
    }

    @Test
    public void testWaves(){

        //Creamos el stub
        Game gamestub = new Game(mockMap,mockPlayer){

            public List<Tower> getTowers(){
                return List.of(new CannonTower(),new LaserTower(),new ArrowTower());
            }
        };
        List<Tower> towers = gamestub.getTowers();
        assertEquals(3,towers.size());
        assertInstanceOf(CannonTower.class, towers.get(0));
        assertInstanceOf(LaserTower.class, towers.get(1));
        assertInstanceOf(ArrowTower.class, towers.get(2));
    }


}
