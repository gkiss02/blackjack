package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class StaticsTest {
    private Statics statics;

    @Before
    public void setUp() {
        statics = new Statics();
    }

    @Test
    public void testIncreaseWins() {
        statics.increaseWins();
        statics.increaseWins();
        statics.increaseWins();
        assertEquals(3, statics.getWins());
    }

    @Test
    public void testIncreaseTies() {
        statics.increaseTies();
        statics.increaseTies();
        statics.increaseTies();
        statics.increaseTies();
        statics.increaseTies();
        assertEquals(5, statics.getTies());
    }

    @Test
    public void testIncreaseLoses() {
        statics.increaseLoses();
        assertEquals(1, statics.getLoses());
    }

    @Test
    public void testSetCoinsWon() {
        statics.setCoinsWon(10);
        statics.setCoinsWon(30);
        assertEquals(40, statics.getCoinsWon());
    }

    @Test
    public void testSetCoinsLost() {
        statics.setCoinsLost(5);
        statics.setCoinsLost(10);
        assertEquals(15, statics.getCoinsLost());
    }


    @Test
    public void testIncreaseContinuousPlays() {
        statics.increaseContinuousPlays();
        assertEquals(1, statics.getContinuousPlays());
    }

    @Test
    public void testSetContinuousPlays() {
        statics.setContinuousPlays(3);
        assertEquals(3, statics.getContinuousPlays());
    }

    @Test
    public void testSetCoins() {
        statics.setCoins(50);
        assertEquals(50, statics.getCoins());

        statics.setCoins(5);
        assertEquals(5, statics.getCoins());
    }

    @Test
    public void testTotalGames() {
        statics.increaseWins();
        statics.increaseTies();
        statics.increaseLoses();
        assertEquals(3, statics.totalGames());
    }
}