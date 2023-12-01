package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

public class ParticipantTest {

    private Participant participant;

    @Before
    public void setUp() {
        participant = new Participant();
    }

    @Test
    public void testAddCard() {
        Card card1 = new Card(1,'♠', "A");
        Card card2 = new Card(2, '♠', "2");

        participant.addCard(card1);
        participant.addCard(card2);

        ArrayList<Card> cards = participant.getCards();
        assertEquals(2, cards.size());
        assertTrue(cards.contains(card1));
        assertTrue(cards.contains(card2));

        int score = participant.getScore();
        assertEquals(3, score);
    }

    @Test
    public void testIsSoft() {
        Card card1 = new Card(11,'♠', "A");
        Card card2 = new Card(6, '♠', "6");

        participant.addCard(card1);
        participant.addCard(card2);

        assertTrue(participant.isSoft());

        participant.getCards().clear();

        Card card3 = new Card(10,'♠', "10");
        Card card4 = new Card(5,'♠', "5");
        Card card5 = new Card(2,'♠', "2");
        participant.addCard(card3);
        participant.addCard(card4);
        participant.addCard(card5);

        assertFalse(participant.isSoft());
    }
}
