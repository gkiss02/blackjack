package com.example;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards;

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

    public Card draw() {
        return cards.remove((int) (Math.random() * cards.size()));
    }

    public void shuffle() {
        ArrayList<Card> newCards = new ArrayList<Card>();

        while (cards.isEmpty()) {
            newCards.add(cards.remove((int) (Math.random() * cards.size())));
        }

        cards = newCards;
    }
}
