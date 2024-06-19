package org.example;

public class Map {

    private char[][] tablero;

    public Map(char[][] initialGrid) {
        this.tablero = initialGrid;
    }

    public char getCell(int x, int y) {
        return tablero[x][y];
    }



    public int getWidth() {
        return tablero.length;
    }

    public int getHeight() {
        return tablero[0].length;
    }

    public void display() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidPosition(int x, int y) {
        if (x < 0 || x >= tablero.length || y < 0 || y >= tablero[0].length) {
            return false;
        }
        return tablero[x][y] == ' ';
    }

    public boolean isPath(int x, int y) {
        if (x < 0 || x >= tablero.length || y < 0 || y >= tablero[0].length) {
            return false;
        }
        return tablero[x][y] == 'C';
    }

    public boolean isBase(int x, int y) {
        if (x < 0 || x >= tablero.length || y < 0 || y >= tablero[0].length) {
            return false;
        }
        return tablero[x][y] == 'B';
    }
    public void putCell(int x, int y, char value) {
        tablero[x][y] = value;
    }
    public boolean isTower(int x, int y) {
        if (x < 0 || x >= tablero.length || y < 0 || y >= tablero[0].length) {
            return false;
        }
        return tablero[x][y] == 'T';
    }
}