package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testAddCoin() {
        player.addCoin(10);
        assertEquals(10, player.getCoins());

        player.addCoin(20);
        assertEquals(30, player.getCoins());
    }

    @Test
    public void testRemoveCoin() {
        player.addCoin(50);
        player.removeCoin(20);
        assertEquals(30, player.getCoins());

        player.removeCoin(10);
        assertEquals(20, player.getCoins());
    }
}