package org.example;

public class LaserTower extends Tower {
    public LaserTower() {
        super(30, 5, 2);
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