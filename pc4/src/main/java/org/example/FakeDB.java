package org.example;

import java.util.List;
import java.util.ArrayList;

public class FakeDB {
    private List<String> users = new ArrayList<>();
    private int points = 0;

    public void newUser(String user) {
        users.add(user);
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public List<String> getUsers() {
        return users;
    }
}


