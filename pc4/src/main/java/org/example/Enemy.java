package org.example;

public abstract class Enemy {
    protected int speed;
    protected int health;
    protected int reward;
    protected int X;
    protected int Y;

    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
        this.X = 0; // Define el punto de partida del enemigo en X
        this.Y = 0; // Define el punto de partida del enemigo en Y
    }
    public void setPosition(int x,int y){
        this.X=x;
        this.Y =y;
    }

    public void move(Map map, Player player) {
        if (map.isBase(X + 1, Y)) {
            player.deductBaseHealth(10);
            health = 0;
        } else if (map.isBase(X, Y + 1)) {
            player.deductBaseHealth(10);
            health = 0;
        } else if (map.isBase(X - 1, Y)) {
            player.deductBaseHealth(10);
            health = 0;
        } else if (map.isBase(X, Y - 1)) {
            player.deductBaseHealth(10);
            health = 0;
        } else {

            if (map.isPath(X + 1, Y)) {

                X += 1;
            } else if (map.isPath(X, Y + 1)) {

                Y += 1;
            }else if (map.isPath(X-1, Y )) {

                X -= 1;
            } else if (map.isPath(X , Y-1)) {

                Y -= 1;
            }

        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getPoints() {
        return reward;
    }

    public boolean remain() {
        return health > 0;
    }



    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }
}
