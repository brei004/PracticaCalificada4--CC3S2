package org.example;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player;
    private int currentWave;
    private List<Wave> waves;
    private Map map;
    private List<Tower> towers;


    public Game(Map map, Player player) {
        this.waves = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.map = map;
        this.player = player;
        this.currentWave = 0;
    }
    public List<Tower> getTowers(){
        return towers;
    }

    public void nextWave() {
        currentWave++;
        waves.add(new Wave(currentWave));
        System.out.println("Ronda" + currentWave);
    }

    public void instante() {
        List<Enemy> enemies = waves.get(currentWave - 1).getEnemies();

        for (Enemy enemy : enemies) {
            if (enemy.remain()) {
                enemy.move(map, player);
                //System.out.println(enemy.getX()+" ,"+enemy.getY());
            }

        }
        if(player.getBaseHealth()<0){
            return ;
        }

        for (Tower tower : towers) {
            tower.attack(enemies);
            tower.instante();
        }
        for (Enemy enemy : enemies) {
            if (!enemy.remain() && !enemiesToBase(enemy)) {
                player.addScore(enemy.getPoints());
            }
        }

        actualState();

        if (waves.get(currentWave - 1).end()) {
            System.out.println("Oleada " + currentWave + " completada.");
        }
    }

    boolean enemiesToBase(Enemy enemy) {
        return enemy.getHealth() <= 0 && map.isBase(enemy.getX(), enemy.getY());
    }

    void actualState() {
        System.out.println("Puntuación: " + player.getScore());
        System.out.println("Vida de la base: " + player.getBaseHealth());
    }
    public void placeTower(Tower tower, int x, int y) {
        if (map.isValidPosition(x, y)) {
            towers.add(tower);
            map.putCell(x, y, 'T'); // Marcamos la posicion de la torre
            System.out.println("Torre colocada en (" + x + ", " + y + ")");
        } else {
            System.out.println("No se puede colocar la torre en (" + x + ", " + y + ")");
        }
    }

    public static void main(String[] args) {
        char[][] initialGrid = {
                {'C', 'C', ' ', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {' ', 'C', 'C', ' ', 'B'},
                {' ', ' ', 'C', 'C', 'C'},
                {' ', ' ', ' ', ' ', ' '}
        };

        Map map = new Map(initialGrid);
        Player player = new Player();
        Game game = new Game(map, player);

        Scanner scanner = new Scanner(System.in);

        while (player.getBaseHealth() > 0) {
            System.out.print("Ingrese comando: ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            if (parts[0].equals("PLACE_TOWER")) {
                String towerType = parts[1];
                int x = Integer.parseInt(parts[2]);
                int y = Integer.parseInt(parts[3]);
                Tower tower = null;
                if (towerType.equals("Cannon")) {
                    tower = new CannonTower();
                } else if (towerType.equals("Laser")) {
                    tower = new LaserTower();
                } else if (towerType.equals("Sniper")) {
                    tower = new SniperTower();
                } else if (towerType.equals("Arrow")) {
                    tower = new ArrowTower();
                }
                if (tower != null) {
                    game.placeTower(tower, x, y);
                } else {
                    System.out.println("Tipo de torre desconocido.");
                }
            } else if (parts[0].equals("START_WAVE")) {
                game.nextWave();
                while (!game.waves.get(game.currentWave - 1).end() && player.getBaseHealth() > 0) {
                    game.instante();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Comando desconocido.");
            }
        }

        System.out.println("Fin,Obtuviste: " + player.getScore());
    }


    public int getCurrentWave() {
        return currentWave;
    }

    public List<Wave> getWaves() {
        return waves;
    }
}
