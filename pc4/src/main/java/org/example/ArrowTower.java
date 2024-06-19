package org.example;

public class ArrowTower extends Tower {
    public ArrowTower() {
        super(10, 3, 1);
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
