package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FakeDBTest {

    @Test
    public void testNewUser() {
        FakeDB fakeDB = new FakeDB();
        fakeDB.newUser("Alice");

        List<String> users = fakeDB.getUsers();
        Assertions.assertTrue(users.contains("Alice"));
        Assertions.assertEquals(1, users.size());
    }

    @Test
    public void testAddPointsAndGetPoints() {
        FakeDB fakeDB = new FakeDB();
        fakeDB.addPoints(100);
        fakeDB.addPoints(50);

        Assertions.assertEquals(150, fakeDB.getPoints());
    }
}
