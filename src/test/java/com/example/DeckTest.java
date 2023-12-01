package com.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
    private Deck deck;
    @Before
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @Test
    public void testDeck() {
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void testDraw() {
        Card card = deck.draw();

        assertNotNull(card);
        assertFalse(deck.getCards().contains(card));
    }
}