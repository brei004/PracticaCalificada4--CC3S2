package org.example;

public class SniperTower extends Tower {
    public SniperTower() {
        super(100, 4, 2); // daño alto, alcance largo, velocidad de disparo baja
    }

    @Override
    public void setPosition(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public void upgrade() {

    }
}
