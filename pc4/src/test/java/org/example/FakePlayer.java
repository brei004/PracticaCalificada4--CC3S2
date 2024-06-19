package org.example;

import org.example.Player;

public class FakePlayer extends Player {
    private int fakeScore;
    private int fakeBaseHealth;

    public FakePlayer(int score, int baseHealth) {
        this.fakeScore = score;
        this.fakeBaseHealth = baseHealth;
    }

    @Override
    public void addScore(int points) {
        this.fakeScore += points;
    }

    @Override
    public void deductBaseHealth(int damage) {
        this.fakeBaseHealth -= damage;
    }

    @Override
    public int getScore() {
        return fakeScore;
    }

    @Override
    public int getBaseHealth() {
        return fakeBaseHealth;
    }
}
