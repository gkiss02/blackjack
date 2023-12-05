package com.example;

import java.util.ArrayList;

/**
 * Represents a deck of playing cards.
 */
public class Deck {
    ArrayList<Card> cards;

    /**
     * Constructs a new deck of cards.
     * The deck is initialized with 52 standard playing cards.
     */
    public Deck() {
        this.cards = new ArrayList<Card>();

        String[] names = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        char[] symbols = { '♠', '♥', '♦', '♣' };

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cards.add(new Card(j >= 10 ? 10 : j, symbols[i], names[j - 1]));
            }
        }
    }

    /**
     * Returns the list of cards in the deck.
     * @return the list of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Draws a card from the deck.
     * The drawn card is removed from the deck.
     * @return the drawn card
     */
    public Card draw() {
        return cards.remove((int) (Math.random() * cards.size()));
    }
}
