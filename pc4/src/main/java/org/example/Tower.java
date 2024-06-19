package org.example;

import java.util.List;

public abstract class Tower {
    protected int damage;
    protected int range;
    protected int fireRate;
    protected int cooldown;
    protected int x;
    protected int y;

    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.cooldown = 0;
    }

    public boolean canAttack() {
        return cooldown == 0;
    }

    public void attack(List<Enemy> enemies) {
        if (canAttack()) {
            for (Enemy enemy : enemies) {
                double distance = calculateDistance(enemy);

                if (isInRange(distance)) {
                    inflictDamage(enemy);
                }
            }
            resetCooldown();
        }
    }

    private double calculateDistance(Enemy enemy) {
        return Math.sqrt(Math.pow(enemy.getX() - this.x, 2) +
                Math.pow(enemy.getY() - this.y, 2));
    }

    private boolean isInRange(double distance) {
        return distance <= range;
    }

    private void inflictDamage(Enemy enemy) {
        enemy.takeDamage(damage);
        System.out.println("Vida del enemigo: "+ enemy.getHealth());
    }

    private void resetCooldown() {
        cooldown = fireRate;
    }


    public void instante() {
        if (cooldown > 0) {
            cooldown--;
        }
    }

    public int getRange() {
        return range;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract void setPosition(int x, int y);
    public abstract void upgrade(); // Método para mejorar la torre

    public int getDamage() {
        return damage;
    }

    public int getFireRate() {
        return fireRate;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
