package org.example;

public class CannonTower extends Tower {
    public CannonTower() {
        super(50, 2, 3);
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